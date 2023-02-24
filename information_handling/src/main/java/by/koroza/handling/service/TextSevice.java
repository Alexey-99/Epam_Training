package by.koroza.handling.service;

import java.util.List;

import by.koroza.handling.entity.Lexeme;
import by.koroza.handling.entity.Sentence;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;

public interface TextSevice {

	public Text sortParagraphsByNumberSentence(Text text) throws CustomException;

	public List<Sentence> findSentencesWithTheMostLongLexeme(Text text) throws CustomException;

	public int findMaxLengthLexeme(Text text) throws CustomException;

	public Text deleteAllSentencesWithNumberLexeme(Text text, int numberLexemesInSentence) throws CustomException;

	public List<Sentence> findIdenticalLexeme(Text text, String lexeme) throws CustomException;

	public List<Sentence> findIdenticalLexeme(Text text, Lexeme lexeme) throws CustomException;

	public int countIdenticalLexeme(Text text, String lexeme) throws CustomException;

	public int countIdenticalLexeme(Text text, Lexeme lexeme) throws CustomException;

	public int countVowelLetters(Text text) throws CustomException;

	public int countConsonantLetters(Text text) throws CustomException;
}