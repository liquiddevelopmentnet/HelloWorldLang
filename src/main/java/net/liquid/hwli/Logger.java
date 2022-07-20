package net.liquid.hwli;

import org.fusesource.jansi.Ansi;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Paths;

public class Logger {

    private static final PrintStream STDOUT;
    private static final PrintStream STDERR;
    private static final String PREFIX;


    private static final String FORMAT_ERROR = "%c1%%c2%%p%: error: %s\n";
    private static final String FORMAT_WARNING = "%c1%%c2%%p%: warning: %s\n";
    private static final String FORMAT_INFO = "%c1%%c2%%p%: %s\n";
    private static final String FORMAT_TERMINATE = "%c1%%c2%%p%: %s\nterminating.\n";

    static {
        STDOUT = System.out;
        STDERR = System.err;
        PREFIX = "hwli";
    }

    private Logger() {}

    public static void error(String s) {
        STDERR.print(formatLog(FORMAT_ERROR, Ansi.ansi().fg(Ansi.Color.RED).toString(), null, s));
    }

    public static void error(String s, int line, int col, String file) {
        STDERR.print(formatLog(FORMAT_ERROR, Ansi.ansi().fg(Ansi.Color.RED).toString(), null, s + "\nat " + Paths.get(file).toAbsolutePath().toString().replace(File.separator, "/") + " " + line + ":" + col + "\n"));
    }

    public static void warn(String s) {
        STDOUT.print(formatLog(FORMAT_WARNING, Ansi.ansi().fg(Ansi.Color.YELLOW).toString(), null, s));
    }

    public static void warn(String s, int line, int col, String file) {
        STDOUT.print(formatLog(FORMAT_WARNING, Ansi.ansi().fg(Ansi.Color.YELLOW).toString(), null, s + "\nat " + Paths.get(file).toAbsolutePath().toString().replace(File.separator, "/") + " " + line + ":" + col + "\n"));
    }

    public static void info(String s) {
        STDOUT.print(formatLog(FORMAT_INFO, Ansi.ansi().fg(Ansi.Color.WHITE).toString(), null, s));
    }

    public static void terminate(String s) {
        STDOUT.print(formatLog(FORMAT_TERMINATE, Ansi.ansi().fg(Ansi.Color.RED).toString(), Ansi.ansi().bold().toString(), s));
    }

    private static String formatLog(String input, String c1, String c2, String s) {
        if (Main.isAnsi())
            return input.replace("%c1%", c1).replace("%c2%", c2 == null ? "" : c2).replace("%p%", PREFIX).replace("%s", s);
        else
            return input.replace("%c1%", "").replace("%c2%", "").replace("%p%", PREFIX).replace("%s", s);
    }

}
