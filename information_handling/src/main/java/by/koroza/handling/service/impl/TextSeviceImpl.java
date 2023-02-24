package by.koroza.handling.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.koroza.handling.entity.Lexeme;
import by.koroza.handling.entity.Paragraph;
import by.koroza.handling.entity.Sentence;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.service.TextSevice;

public class TextSeviceImpl implements TextSevice {
	private static final String REG_EX_VOWEL_LETTERS_UPPER_CASE_ENG = "[AEIOUY]";
	private static final String REG_EX_VOWEL_LETTERS_LOWER_CASE_ENG = "[aeiouy]";
	private static final String REG_EX_VOWEL_LETTERS_ENG = REG_EX_VOWEL_LETTERS_UPPER_CASE_ENG + "|"
			+ REG_EX_VOWEL_LETTERS_LOWER_CASE_ENG;
	private static final String REG_EX_VOWEL_LETTERS_UPPER_CASE_RUS = "[АЕЁИОУЫЭЮЯ]";
	private static final String REG_EX_VOWEL_LETTERS_LOWER_CASE_RUS = "[аеёиоуыэюя]";
	private static final String REG_EX_VOWEL_LETTERS_RUS = REG_EX_VOWEL_LETTERS_UPPER_CASE_RUS + "|"
			+ REG_EX_VOWEL_LETTERS_LOWER_CASE_RUS;
	private static final String REG_EX_VOWEL_LETTERS = REG_EX_VOWEL_LETTERS_ENG + "|" + REG_EX_VOWEL_LETTERS_RUS;

	private static final String REG_EX_CONSONANT_LETTERS_UPPER_CASE_ENG = "[BCDFGHJKLMNPQRSTVWXZ]";
	private static final String REG_EX_CONSONANT_LETTERS_LOWER_CASE_ENG = "[bcdfghjklmnpqrstvwxz]";
	private static final String REG_EX_CONSONANT_LETTERS_ENG = REG_EX_CONSONANT_LETTERS_UPPER_CASE_ENG + "|"
			+ REG_EX_CONSONANT_LETTERS_LOWER_CASE_ENG;
	private static final String REG_EX_CONSONANT_LETTERS_UPPER_CASE_RUS = "[БВГДЖЗЙКЛМНПРСТФХЦЧШЩЪЬ]";
	private static final String REG_EX_CONSONANT_LETTERS_LOWER_CASE_RUS = "[бвгджзйклмнпрстфхцчшщъь]";
	private static final String REG_EX_CONSONANT_LETTERS_RUS = REG_EX_CONSONANT_LETTERS_UPPER_CASE_RUS + "|"
			+ REG_EX_CONSONANT_LETTERS_LOWER_CASE_RUS;
	private static final String REG_EX_CONSONANT_LETTERS = REG_EX_CONSONANT_LETTERS_ENG + "|"
			+ REG_EX_CONSONANT_LETTERS_RUS;

	@Override
	public Text sortParagraphsByNumberSentence(Text text) throws CustomException {
		Text textClone = createTextClone(text);
		List<Paragraph> paragraphs = textClone.getParagraphs();
		for (int i = 0; i < paragraphs.size(); i++) {
			for (int j = i; j < paragraphs.size(); j++) {
				if (paragraphs.get(i).getSentences().size() > paragraphs.get(j).getSentences().size()) {
					Paragraph paragraphBuffer = paragraphs.get(i);
					paragraphs.set(i, paragraphs.get(j));
					paragraphs.set(j, paragraphBuffer);
				}
			}
		}
		return textClone;
	}

	@Override
	public List<Sentence> findSentencesWithTheMostLongLexeme(Text text) throws CustomException {
		List<Sentence> sentencesWithLexemesMaxLength = new ArrayList<>();
		int maxLengthLexeme = findMaxLengthLexeme(text);
		Text textClone = createTextClone(text);
		for (Paragraph paragraph : textClone.getParagraphs()) {
			for (Sentence sentence : paragraph.getSentences()) {
				boolean flag = false;
				for (Lexeme lexeme : sentence.getLexemes()) {
					if (maxLengthLexeme == lexeme.getSymbols().size()) {
						flag = true;
					}
				}
				if (flag == true) {
					sentencesWithLexemesMaxLength.add(sentence);
					flag = false;
				}
			}
		}
		return sentencesWithLexemesMaxLength;
	}

	@Override
	public int findMaxLengthLexeme(Text text) throws CustomException {
		int maxLengthLexeme = 0;
		Text textClone = createTextClone(text);
		for (Paragraph paragraph : textClone.getParagraphs()) {
			for (Sentence sentence : paragraph.getSentences()) {
				for (Lexeme lexeme : sentence.getLexemes()) {
					if (maxLengthLexeme < lexeme.getSymbols().size()) {
						maxLengthLexeme = lexeme.getSymbols().size();
					}
				}
			}
		}
		return maxLengthLexeme;
	}

	@Override
	public Text deleteAllSentencesWithNumberLexeme(Text text, int numberLexemesInSentence) throws CustomException {
		Text textClone = createTextClone(text);
		for (Paragraph paragraph : textClone.getParagraphs()) {
			for (int i = 0; i < paragraph.getSentences().size(); i++) {
				Sentence sentence = paragraph.getSentences().get(i);
				if (sentence.getLexemes().size() <= numberLexemesInSentence) {
					paragraph.getSentences().remove(sentence);
					i--;
				}
			}
		}
		return textClone;
	}

	@Override
	public List<Sentence> findIdenticalLexeme(Text text, String lexeme) throws CustomException {
		List<Sentence> sentences = null;
		if (lexeme != null) {
			sentences = new ArrayList<>();
			String lexemeLowerCase = lexeme.toLowerCase();
			Text textClone = createTextClone(text);
			for (Paragraph paragraph : textClone.getParagraphs()) {
				for (Sentence sentence : paragraph.getSentences()) {
					List<Lexeme> lexemes = sentence.getLexemes();
					boolean flag = true;
					int indexLexeme = 0;
					while (indexLexeme < lexemes.size() && flag) {
						if (lexemes.get(indexLexeme).toString().toLowerCase().equals(lexemeLowerCase)) {
							sentences.add(sentence);
							flag = false;
						}
						indexLexeme++;
					}
				}
			}
		} else {
			throw new CustomException("Link String lexeme is " + lexeme);
		}
		return sentences;
	}

	@Override
	public List<Sentence> findIdenticalLexeme(Text text, Lexeme lexeme) throws CustomException {
		List<Sentence> sentences = null;
		if (lexeme != null) {
			sentences = new ArrayList<>();
			String lexemeLowerCase = lexeme.toString().toLowerCase();
			Text textClone = createTextClone(text);
			for (Paragraph paragraph : textClone.getParagraphs()) {
				for (Sentence sentence : paragraph.getSentences()) {
					List<Lexeme> lexemes = sentence.getLexemes();
					boolean flag = true;
					int indexLexeme = 0;
					while (indexLexeme < lexemes.size() && flag) {
						if (lexemes.get(indexLexeme).toString().toLowerCase().equals(lexemeLowerCase)) {
							sentences.add(sentence);
							flag = false;
						}
						indexLexeme++;
					}
				}
			}
		} else {
			throw new CustomException("Link Lexeme lexeme is " + lexeme);
		}
		return sentences;
	}

	@Override
	public int countIdenticalLexeme(Text text, String lexeme) throws CustomException {
		int counter = 0;
		if (text != null && lexeme != null) {
			String lexemeLowerCase = lexeme.toLowerCase();
			Text textClone = createTextClone(text);
			for (Paragraph paragraph : textClone.getParagraphs()) {
				for (Sentence sentence : paragraph.getSentences()) {
					for (Lexeme lexemeEl : sentence.getLexemes()) {
						if (lexemeEl.toString().toLowerCase().equals(lexemeLowerCase)) {
							counter++;
						}
					}
				}
			}
		} else {
			throw new CustomException("Link String lexeme is " + lexeme);
		}
		return counter;
	}

	@Override
	public int countIdenticalLexeme(Text text, Lexeme lexeme) throws CustomException {
		int counter = 0;
		if (text != null && lexeme != null) {
			String lexemeLowerCase = lexeme.toString().toLowerCase();
			Text textClone = createTextClone(text);
			for (Paragraph paragraph : textClone.getParagraphs()) {
				for (Sentence sentence : paragraph.getSentences()) {
					for (Lexeme lexemeEl : sentence.getLexemes()) {
						if (lexemeEl.toString().toLowerCase().equals(lexemeLowerCase)) {
							counter++;
						}
					}
				}
			}
		} else {
			throw new CustomException("Link Lexeme lexeme is " + lexeme);
		}
		return counter;
	}

	@Override
	public int countVowelLetters(Text text) throws CustomException {
		int counter = 0;
		Text textClone = createTextClone(text);
		Pattern p = Pattern.compile(REG_EX_VOWEL_LETTERS);
		Matcher m = p.matcher(textClone.toString());
		while (m.find() | m.lookingAt() | m.matches()) {
			counter++;
		}
		return counter;
	}

	@Override
	public int countConsonantLetters(Text text) throws CustomException {
		int counter = 0;
		Text textClone = createTextClone(text);
		Pattern p = Pattern.compile(REG_EX_CONSONANT_LETTERS);
		Matcher m = p.matcher(textClone.toString());
		while (m.find() | m.lookingAt() | m.matches()) {
			counter++;
		}
		return counter;
	}

	private Text createTextClone(Text text) throws CustomException {
		Text textClone = null;
		if (text != null) {
			try {
				textClone = text.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		} else {
			throw new CustomException("Link text is " + text);
		}
		return textClone;
	}
}