// Generated from C:/Users/Finn/IdeaProjects/HelloWorldLangInterpreter/src/main/resources\HWLParser.g4 by ANTLR 4.10.1

package net.liquid.hwli.ast;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HWLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HWLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HWLParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(HWLParser.UnitContext ctx);
}