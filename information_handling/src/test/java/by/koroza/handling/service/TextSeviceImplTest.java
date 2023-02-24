package by.koroza.handling.service;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.handling.create.CreaterTextClass;
import by.koroza.handling.entity.Lexeme;
import by.koroza.handling.entity.Sentence;
import by.koroza.handling.entity.Symbol;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.service.impl.TextSeviceImpl;

public class TextSeviceImplTest {
	private TextSevice textSevice;
	private Text textObject;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.textSevice = new TextSeviceImpl();
		this.textObject = new CreaterTextClass().createText();
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#sortParagraphsByNumberSentence(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testSortParagraphsByNumberSentenceInputNull() throws CustomException {
		this.textSevice.sortParagraphsByNumberSentence(null);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#sortParagraphsByNumberSentence(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 * @throws InterruptedException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class. Expected result - sorting text.clone cbject of Text.class")
	public void testSortParagraphsByNumberSentence() throws CustomException, InterruptedException {
		Text actual = this.textSevice.sortParagraphsByNumberSentence(textObject);
		Text expected = new Text.TextBuilder().setParagraph(this.textObject.getParagraphs().get(2))
				.setParagraph(this.textObject.getParagraphs().get(3))
				.setParagraph(this.textObject.getParagraphs().get(0))
				.setParagraph(this.textObject.getParagraphs().get(1)).build();
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findSentencesWithTheMostLongLexeme(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testFindSentencesWithTheMostLongLexemeInputNull() throws CustomException {
		this.textSevice.findSentencesWithTheMostLongLexeme(null);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findSentencesWithTheMostLongLexeme(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class. Expected result - List with Sentence.class with sentences with the most long lenemes from text.clone cbject of Text.class")
	public void testFindSentencesWithTheMostLongLexeme() throws CustomException {
		List<Sentence> actual = this.textSevice.findSentencesWithTheMostLongLexeme(textObject);
		List<Sentence> expected = new ArrayList<>();
		expected.add(this.textObject.getParagraphs().get(1).getSentences().get(1));
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findMaxLengthLexeme(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testFindMaxLengthLexemeInoutNull() throws CustomException {
		this.textSevice.findMaxLengthLexeme(null);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findMaxLengthLexeme(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class. Expected result - length the most long lexeme int type from text.clone cbject of Text.class")
	public void testFindMaxLengthLexeme() throws CustomException {
		int actual = this.textSevice.findMaxLengthLexeme(textObject);
		int expected = 19;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#deleteAllSentencesWithNumberLexeme(by.koroza.handling.entity.Text, int)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testDeleteAllSentencesWithNumberLexemeInputNull() throws CustomException {
		this.textSevice.deleteAllSentencesWithNumberLexeme(null, 2);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#deleteAllSentencesWithNumberLexeme(by.koroza.handling.entity.Text, int)}.
	 * 
	 * @throws CustomException
	 * @throws CloneNotSupportedException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class. Expected result - text of Text.class with sentences of Sentence.class if he has > entered number lexemes from text.clone cbject of Text.class")
	public void testDeleteAllSentencesWithNumberLexeme() throws CustomException, CloneNotSupportedException {
		Text actual = this.textSevice.deleteAllSentencesWithNumberLexeme(textObject, 2);
		Text textClone = this.textObject.clone();
		Text expected = new Text.TextBuilder().setParagraph(textClone.getParagraphs().get(0))
				.setParagraph(textClone.getParagraphs().get(1)).setParagraph(textClone.getParagraphs().get(2))
				.setParagraph(textClone.getParagraphs().get(3)).build();
		expected.getParagraphs().get(3).getSentences().remove(0);
		assertEquals(actual, expected);
	}

	@DataProvider(name = "providerParametersString")
	public Object[][] providerParametersString() {
		return new Object[][] { { null, "Lorem" }, { this.textObject, null }, { null, null } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findIdenticalLexeme(by.koroza.handling.entity.Text, java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerParametersString", expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testFindIdenticalLexemeTextString(Text text, String lexeme) throws CustomException {
		this.textSevice.findIdenticalLexeme(text, lexeme);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findIdenticalLexeme(by.koroza.handling.entity.Text, java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class and lexeme of String.class. Expected result - text of Text.class with sentences of Sentence.class having inputed lexeme String.class from text.clone cbject of Text.class")
	public void testFindIdenticalLexemeTextString() throws CustomException {
		List<Sentence> actual = this.textSevice.findIdenticalLexeme(textObject, "Lorem");
		List<Sentence> expected = new ArrayList<>();
		expected.add(this.textObject.getParagraphs().get(0).getSentences().get(1));
		assertEquals(actual, expected);
	}

	@DataProvider(name = "providerParametersLexeme")
	public Object[][] providerParametersLexeme() {
		List<Symbol> symbols = new ArrayList<>();
		symbols.add(new Symbol('L'));
		symbols.add(new Symbol('o'));
		symbols.add(new Symbol('r'));
		symbols.add(new Symbol('e'));
		symbols.add(new Symbol('m'));
		return new Object[][] { { null, new Lexeme(symbols) }, { this.textObject, null }, { null, null } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findIdenticalLexeme(by.koroza.handling.entity.Text, by.koroza.handling.entity.Lexeme)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerParametersLexeme", expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testFindIdenticalLexemeTextLexeme(Text text, Lexeme lexeme) throws CustomException {
		this.textSevice.findIdenticalLexeme(text, lexeme);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#findIdenticalLexeme(by.koroza.handling.entity.Text, by.koroza.handling.entity.Lexeme)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class and lexeme of Lexeme.class. Expected result - text of Text.class with sentences of Sentence.class having inputed lexeme Lexeme.class from text.clone cbject of Text.class")
	public void testFindIdenticalLexemeTextLexeme() throws CustomException {
		List<Symbol> symbols = new ArrayList<>();
		symbols.add(new Symbol('L'));
		symbols.add(new Symbol('o'));
		symbols.add(new Symbol('r'));
		symbols.add(new Symbol('e'));
		symbols.add(new Symbol('m'));
		List<Sentence> actual = this.textSevice.findIdenticalLexeme(textObject, new Lexeme(symbols));
		List<Sentence> expected = new ArrayList<>();
		expected.add(this.textObject.getParagraphs().get(0).getSentences().get(1));
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countIdenticalLexeme(by.koroza.handling.entity.Text, java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerParametersString", expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testCountIdenticalLexemeTextString(Text text, String lexeme) throws CustomException {
		this.textSevice.countIdenticalLexeme(text, lexeme);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countIdenticalLexeme(by.koroza.handling.entity.Text, java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class and lexeme of String.class. Expected result - number of repetitions inputed lexeme String.class from text.clone cbject of Text.class")
	public void testCountIdenticalLexemeTextString() throws CustomException {
		int actual = this.textSevice.countIdenticalLexeme(this.textObject, "Lorem");
		int expected = 2;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countIdenticalLexeme(by.koroza.handling.entity.Text, by.koroza.handling.entity.Lexeme)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerParametersLexeme", expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testCountIdenticalLexemeTextLexeme(Text text, Lexeme lexeme) throws CustomException {
		this.textSevice.countIdenticalLexeme(text, lexeme);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countIdenticalLexeme(by.koroza.handling.entity.Text, by.koroza.handling.entity.Lexeme)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - text object of Text.class and lexeme of Lexeme.class. Expected result - number of repetitions inputed lexeme Lexeme.class from text.clone cbject of Text.class")
	public void testCountIdenticalLexemeTextLexeme() throws CustomException {
		List<Symbol> symbols = new ArrayList<>();
		symbols.add(new Symbol('L'));
		symbols.add(new Symbol('o'));
		symbols.add(new Symbol('r'));
		symbols.add(new Symbol('e'));
		symbols.add(new Symbol('m'));
		int actual = this.textSevice.countIdenticalLexeme(this.textObject, new Lexeme(symbols));
		int expected = 2;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countVowelLetters(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testCountVowelLettersInputNull() throws CustomException {
		this.textSevice.countVowelLetters(null);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countVowelLetters(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - Text of Text.class. Expected result - number of repetitions vowel letters.")
	public void testCountVowelLetters() throws CustomException {
		int actual = this.textSevice.countVowelLetters(textObject);
		int expected = 250;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countConsonantLetters(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This test-method testing method if input parameter - null. Expected result - CustomExeption.class")
	public void testCountConsonantLettersInputNull() throws CustomException {
		this.textSevice.countConsonantLetters(null);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.service.impl.TextSeviceImpl#countConsonantLetters(by.koroza.handling.entity.Text)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This test-method testing method if input parameter - text of Text.class. Expected result - number of repetitions consonant letters.")
	public void testCountConsonantLetters() throws CustomException {
		int actual = this.textSevice.countConsonantLetters(textObject);
		int expected = 369;
		assertEquals(actual, expected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		this.textSevice = null;
		this.textObject = null;
	}
}