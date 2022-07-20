package net.liquid.hwli;

import lombok.Getter;
import net.liquid.hwli.ast.HWLLexer;
import net.liquid.hwli.ast.HWLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.concurrent.Callable;

import static picocli.CommandLine.*;

@Command(
        name = "hwli",
        description = "Hello World Lang Interpreter",
        version = "1.0-SNAPSHOT",
        mixinStandardHelpOptions = true
)
public class Main implements Callable<Integer> {

    @Getter
    @Parameters
    private static HashSet<Path> targets;

    @Getter
    @Option(names = {"--color", "-c"}, description = "Enable ANSI color output")
    private static boolean ansi;

    public static void main(String[] args) {
        System.exit(new CommandLine(new Main()).execute(args));
    }

    @Override
    public Integer call() throws IOException {

        if (targets == null || targets.isEmpty()) {
            Logger.terminate("No targets specified.");
            return 1;
        }

        if (targets.size() > 1) {
            Logger.terminate("Only one target can be specified.");
            return 1;
        }

        Path target = Path.of(new File(String.valueOf(targets.iterator().next().getFileName())).getAbsolutePath());

        if (!Files.exists(target)) {
            Logger.terminate(String.format("File not found: %s", target));
            return 1;
        }

        if (!target.getFileName().toString().endsWith(".hw") && !target.getFileName().toString().endsWith(".hwl")) {
            Logger.terminate(String.format("Invalid file type for: %s, valid options: [hw, hwl]", target));
            return 1;
        }

        parse(target);

        return 0;
    }

    private void parse(Path target) throws IOException {

        HWLLexer lex = new HWLLexer(CharStreams.fromPath(target));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        HWLParser parser = new HWLParser(tokens);

        parser.removeErrorListeners();

        var sem = new SemanticAnalyzer();

        new ParseTreeWalker().walk(sem, parser.unit());

    }

}