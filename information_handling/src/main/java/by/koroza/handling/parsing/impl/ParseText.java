package by.koroza.handling.parsing.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.handling.entity.Paragraph;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.Parse;

public class ParseText implements Parse {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String REG_EX_SPLIT_BY_PARAGRAPH = "\\t";

	@Override
	public Text parse(String text) throws CustomException {
		List<Paragraph> paragraphs = null;
		if (text != null) {
			List<String> linesWithoutFirstElement = removeFirstElement(text.split(REG_EX_SPLIT_BY_PARAGRAPH));
			paragraphs = linesWithoutFirstElement.stream().map(paragraph -> {
				try {
					return new ParseParagraph().parse(paragraph.trim());
				} catch (CustomException e) {
					LOGGER.log(Level.ERROR, e.getMessage());
					e.printStackTrace();
					return null;
				}
			}).toList();
		} else {
			throw new CustomException("Link text - " + text);
		}
		return new Text.TextBuilder().setParagraphs(paragraphs).build();
	}

	private List<String> removeFirstElement(String[] lines) {
		List<String> linesWithoutFirstElement = new ArrayList<>();
		for (int i = 1; i < lines.length; i++) {
			linesWithoutFirstElement.add(lines[i]);
		}
		return linesWithoutFirstElement;
	}
}