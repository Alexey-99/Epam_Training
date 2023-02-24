package by.koroza.handling.parsing.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.handling.entity.Lexeme;
import by.koroza.handling.entity.Sentence;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.Parse;

public class ParseSentence implements Parse {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String REG_EX_SPLIT_BY_LEXEME = "\\s+";

	@Override
	public Sentence parse(String sentence) throws CustomException {
		List<Lexeme> lexemes = null;
		if (sentence != null) {
			lexemes = Arrays.stream(sentence.trim().split(REG_EX_SPLIT_BY_LEXEME)).map(lexeme -> {
				try {
					return new ParseLexeme().parse(lexeme);
				} catch (CustomException e) {
					LOGGER.log(Level.ERROR, e.getMessage());
					e.printStackTrace();
					return null;
				}
			}).toList();
		} else {
			throw new CustomException("Link sentence - " + sentence);
		}
		return new Sentence.SentenceBuilder().setLexemes(lexemes).build();
	}
}