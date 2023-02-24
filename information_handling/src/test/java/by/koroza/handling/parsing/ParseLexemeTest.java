package by.koroza.handling.parsing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.handling.create.CreaterTextClass;
import by.koroza.handling.entity.Lexeme;
import by.koroza.handling.entity.Symbol;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.impl.ParseLexeme;

public class ParseLexemeTest {
	private String lexeme;
	private ParseLexeme parseLexeme;
	private Text textObjectExpexted;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.textObjectExpexted = new CreaterTextClass().createText();
		this.lexeme = "It";
		this.parseLexeme = new ParseLexeme();
	}

	@DataProvider(name = "providerLexeme")
	private Object[][] providerLexeme() {
		return new Object[][] {
				{ this.lexeme, textObjectExpexted.getParagraphs().get(0).getSentences().get(0).getLexemes().get(0) },
				{ "3>>5", new Lexeme.LexemeBuilder().setSymbol(new Symbol('0')).build() },
				{ "13<<2", new Lexeme.LexemeBuilder().setSymbol(new Symbol('5')).setSymbol(new Symbol('2')).build() },
				{ "~6&9|(3&4)", new Lexeme.LexemeBuilder().setSymbol(new Symbol('9')).build() },
				{ "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)",
						new Lexeme.LexemeBuilder().setSymbol(new Symbol('5')).build() },
				{ "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78",
						new Lexeme.LexemeBuilder().setSymbol(new Symbol('7')).setSymbol(new Symbol('8')).build() },
				{ "(7^5|1&2<<(2|5>>2&71))|1200", new Lexeme.LexemeBuilder().setSymbol(new Symbol('1'))
						.setSymbol(new Symbol('2')).setSymbol(new Symbol('0')).setSymbol(new Symbol('2')).build() } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseLexeme#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerLexeme", description = "This method get lexeme of String.class, if this lexeme is bit expression - calculation it, after parse lexeme after return lexeme of Lexeme.class, if he getting null - CuctomException.class")
	public void testParse(String lexeme, Lexeme expected) throws CustomException {
		Lexeme actual = this.parseLexeme.parse(lexeme);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseLexeme#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This method get lexeme of String.class and parse lexeme after return lexeme of Lexeme.class, if he getting null - CuctomException.class")
	public void testParseInputNull() throws CustomException {
		this.parseLexeme.parse(null);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		this.lexeme = null;
		this.parseLexeme = null;
		this.textObjectExpexted = null;
	}
}