// Generated from C:/Users/Finn/IdeaProjects/HelloWorldLangInterpreter/src/main/resources\HWLParser.g4 by ANTLR 4.10.1

package net.liquid.hwli.ast;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link HWLParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class HWLParserBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements HWLParserVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitUnit(HWLParser.UnitContext ctx) { return visitChildren(ctx); }
}