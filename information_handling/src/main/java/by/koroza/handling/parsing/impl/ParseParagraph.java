package by.koroza.handling.parsing.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.handling.entity.Paragraph;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.Parse;

public class ParseParagraph implements Parse {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String REG_EX_FIND_END_SENTENCE_SIGN_WITH_SPACE = "(\\.{3}|\\.|\\!|\\?)\\s+";
	private static final String REG_EX_FIND_END_SENTENCE_SIGN = "\\.{3}|\\.|\\!|\\?";

	@Override
	public Paragraph parse(String paragraph) throws CustomException {
		Paragraph paragraphObject = null;
		if (paragraph != null) {
			String[] sentences = paragraph.trim().split(REG_EX_FIND_END_SENTENCE_SIGN_WITH_SPACE);
			ParseSentence parseSentence = new ParseSentence();
			paragraphObject = new Paragraph();
			if (sentences.length > 1) {
				connectSentenceEndingSignsAndSentences(paragraph, sentences);
				paragraphObject.setSentences(Arrays.stream(sentences).map(sentence -> {
					try {
						return parseSentence.parse(sentence);
					} catch (CustomException e) {
						LOGGER.log(Level.ERROR, e.getMessage());
						e.printStackTrace();
						return null;
					}
				}).toList());
			} else {
				paragraphObject.setSentence(parseSentence.parse(sentences[0]));
			}
		} else {
			throw new CustomException("Link paragraph - " + paragraph);
		}
		return paragraphObject;
	}

	private void connectSentenceEndingSignsAndSentences(String paragraph, String[] sentences) {
		List<String> sentenceEndingSigns = saveSentenceEndingSigns(paragraph);
		for (int i = 0; i < sentences.length - 1; i++) {
			sentences[i] = sentences[i] + sentenceEndingSigns.get(i);
		}
	}

	private List<String> saveSentenceEndingSigns(String paragraph) {
		List<String> sentenceEndingSigns = new ArrayList<>();
		Pattern p = Pattern.compile(REG_EX_FIND_END_SENTENCE_SIGN_WITH_SPACE);
		Matcher m = p.matcher(paragraph);
		while (m.find()) {
			String sentenceEndingSignsWithSpace = m.group();
			Pattern pat = Pattern.compile(REG_EX_FIND_END_SENTENCE_SIGN);
			Matcher mat = pat.matcher(sentenceEndingSignsWithSpace);
			if (mat.find()) {
				sentenceEndingSigns.add(mat.group());
			}
		}
		return sentenceEndingSigns;
	}

}