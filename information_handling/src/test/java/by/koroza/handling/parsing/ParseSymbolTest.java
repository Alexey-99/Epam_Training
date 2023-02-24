package by.koroza.handling.parsing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.koroza.handling.create.CreaterTextClass;
import by.koroza.handling.entity.Symbol;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.impl.ParseSymbol;

public class ParseSymbolTest {
	private String symbol;
	private ParseSymbol parseSymbol;
	private Text textObjectExpexted;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.parseSymbol = new ParseSymbol();
		this.symbol = "I";
		this.textObjectExpexted = new CreaterTextClass().createText();
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseSymbol#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This method get symbol of String.class and parse symbol after return symbol of Symbol.class, if he getting null - CuctomException.class")
	public void testParse() throws CustomException {
		Symbol actual = this.parseSymbol.parse(symbol);
		assertEquals(actual, textObjectExpexted.getParagraphs().get(0).getSentences().get(0).getLexemes().get(0)
				.getSymbols().get(0));
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseSymbol#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This method get symbol of String.class and parse symbol after return symbol of Symbol.class, if he getting null - CuctomException.class")
	public void testParseInputNull() throws CustomException {
		this.parseSymbol.parse(null);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		this.parseSymbol = null;
		this.symbol = null;
		this.textObjectExpexted = null;
	}
}