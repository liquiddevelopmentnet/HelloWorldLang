package net.liquid.hwli;

import net.liquid.hwli.ast.HWLParser;
import net.liquid.hwli.ast.HWLParserBaseListener;

public class SemanticAnalyzer extends HWLParserBaseListener {

    public SemanticAnalyzer() {
        super();
    }

    @Override
    public void enterUnit(HWLParser.UnitContext ctx) {
        System.out.println("Hello, world!");
    }
}
