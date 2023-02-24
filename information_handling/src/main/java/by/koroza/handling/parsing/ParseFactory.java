package by.koroza.handling.parsing;

import by.koroza.handling.parsing.impl.ParseLexeme;
import by.koroza.handling.parsing.impl.ParseParagraph;
import by.koroza.handling.parsing.impl.ParseSentence;
import by.koroza.handling.parsing.impl.ParseSymbol;
import by.koroza.handling.parsing.impl.ParseText;

public class ParseFactory {

	public static ParseText newParseText() {
		return new ParseText();
	}

	public static ParseParagraph newParseParagraph() {
		return new ParseParagraph();
	}

	public static ParseSentence newParseSentence() {
		return new ParseSentence();
	}

	public static ParseLexeme newParseLexeme() {
		return new ParseLexeme();
	}

	public static ParseSymbol newParseSymbol() {
		return new ParseSymbol();
	}
}