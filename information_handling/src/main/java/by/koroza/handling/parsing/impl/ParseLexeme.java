package by.koroza.handling.parsing.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.handling.entity.Lexeme;
import by.koroza.handling.entity.Symbol;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.interpreter.expression.AbstractExpression;
import by.koroza.handling.interpreter.expression.impl.EvaluateExpression;
import by.koroza.handling.parsing.Parse;

public class ParseLexeme implements Parse {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String REG_EX_SPLIT_BY_SYMBOL = "";
	private static final String REG_EX_FIND_BIT_EXPRESSIONS = "((\\W+)?(\\d+)(\\W+)?)+";

	@Override
	public Lexeme parse(String lexeme) throws CustomException {
		List<Symbol> symbolsLexemeList = null;
		if (lexeme != null) {
			AbstractExpression avaluate = null;
			if (lexeme.trim().matches(REG_EX_FIND_BIT_EXPRESSIONS)) {
				avaluate = new EvaluateExpression().evaluateExpression(lexeme);
			}
			symbolsLexemeList = Arrays.stream(lexeme.trim().matches(REG_EX_FIND_BIT_EXPRESSIONS)
					? Integer.toString(avaluate.interpret(avaluate)).split(REG_EX_SPLIT_BY_SYMBOL)
					: lexeme.split(REG_EX_SPLIT_BY_SYMBOL)).map(symbol -> {
						try {
							return new ParseSymbol().parse(symbol);
						} catch (CustomException e) {
							LOGGER.log(Level.ERROR, e.getMessage());
							e.printStackTrace();
							return null;
						}
					}).toList();
		} else {
			throw new CustomException("Link lexeme - " + lexeme);
		}
		return new Lexeme.LexemeBuilder().setSymbols(symbolsLexemeList).build();
	}
}