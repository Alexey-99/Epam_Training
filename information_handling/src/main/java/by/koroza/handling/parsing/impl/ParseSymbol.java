package by.koroza.handling.parsing.impl;

import by.koroza.handling.entity.Symbol;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.Parse;

public class ParseSymbol implements Parse {

	@Override
	public Symbol parse(String symbol) throws CustomException {
		char ch = 0;
		if (symbol != null) {
			ch = symbol.charAt(0);
		} else {
			throw new CustomException("Link symbol - " + symbol);
		}
		return new Symbol(ch);
	}
}