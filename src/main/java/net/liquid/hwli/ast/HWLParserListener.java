// Generated from C:/Users/Finn/IdeaProjects/HelloWorldLangInterpreter/src/main/resources\HWLParser.g4 by ANTLR 4.10.1

package net.liquid.hwli.ast;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HWLParser}.
 */
public interface HWLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HWLParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(HWLParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link HWLParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(HWLParser.UnitContext ctx);
}