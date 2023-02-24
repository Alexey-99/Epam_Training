/**
 * 
 */
package by.koroza.handling.parsing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.handling.create.CreaterTextClass;
import by.koroza.handling.entity.Paragraph;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.impl.ParseParagraph;

public class ParseParagraphTest {
	private String firstParagraph;
	private String secondParagraph;
	private String thirdParagraph;
	private String fourthParagraph;
	private ParseParagraph parseParagraph;
	private Text textObjectExpexted;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.textObjectExpexted = new CreaterTextClass().createText();
		this.firstParagraph = """
					It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in
				the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software
				like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!
				""";
		this.secondParagraph = """
					It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using
				Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like
				readable English?
				""";
		this.thirdParagraph = """
					It is a established fact that a reader will be of a page when looking at its layout...
				""";
		this.fourthParagraph = """
					Bye бандерлоги.
				""";
		this.parseParagraph = new ParseParagraph();
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseParagraph#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This method get paragraph of String.class and parse paragraph after return paragraph of Paragraph.class, if he getting null - CuctomException.class")
	public void testParseInputNull() throws CustomException {
		this.parseParagraph.parse(null);
	}

	@DataProvider(name = "providerParagraphs")
	public Object[][] providerParagraphs() {
		return new Object[][] { { this.firstParagraph, this.textObjectExpexted.getParagraphs().get(0) },
				{ this.secondParagraph, this.textObjectExpexted.getParagraphs().get(1) },
				{ this.thirdParagraph, this.textObjectExpexted.getParagraphs().get(2) },
				{ this.fourthParagraph, this.textObjectExpexted.getParagraphs().get(3) } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseParagraph#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerParagraphs", description = "This method get paragraph of String.class and parse paragraph after return paragraph of Paragraph.class, if he getting null - CuctomException.class")
	public void testParse(String paragraph, Paragraph paragraphExpected) throws CustomException {
		Paragraph actual = this.parseParagraph.parse(paragraph);
		assertEquals(actual, paragraphExpected);
	}

	/**
	*/
	@AfterClass
	public void tearDownAfterClass() {
		this.parseParagraph = null;
		this.textObjectExpexted = null;
		this.firstParagraph = null;
		this.secondParagraph = null;
		this.thirdParagraph = null;
		this.fourthParagraph = null;
	}
}