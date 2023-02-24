package by.koroza.handling.parsing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.handling.create.CreaterTextClass;
import by.koroza.handling.entity.Sentence;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.impl.ParseSentence;

public class ParseSentenceTest {
	private String firstParagraphFirstSentence;
	private String firstParagraphSecondSentence;
	private String secondParagraphFirstSentence;
	private String secondParagraphSecondSentence;
	private String thirdParagraphFirstSentence;
	private String fourthParagraphFirstSentence;
	private ParseSentence parseSentence;
	private Text textObjectExpexted;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.textObjectExpexted = new CreaterTextClass().createText();

		this.firstParagraphFirstSentence = "	It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.";
		this.firstParagraphSecondSentence = "It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!";

		this.secondParagraphFirstSentence = "	It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout.";
		this.secondParagraphSecondSentence = "The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?";

		this.thirdParagraphFirstSentence = "	It is a established fact that a reader will be of a page when looking at its layout...";

		this.fourthParagraphFirstSentence = "	Bye бандерлоги.";
		this.parseSentence = new ParseSentence();
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseSentence#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This method get sentence of String.class and parse sentence after return sentence of Sentence.class, if he getting null - CuctomException.class")
	public void testParse() throws CustomException {
		this.parseSentence.parse(null);
	}

	@DataProvider(name = "providerSentences")
	public Object[][] providerSentences() {
		return new Object[][] {
				{ this.firstParagraphFirstSentence,
						this.textObjectExpexted.getParagraphs().get(0).getSentences().get(0) },
				{ this.firstParagraphSecondSentence,
						this.textObjectExpexted.getParagraphs().get(0).getSentences().get(1) },
				{ this.secondParagraphFirstSentence,
						this.textObjectExpexted.getParagraphs().get(1).getSentences().get(0) },
				{ this.secondParagraphSecondSentence,
						this.textObjectExpexted.getParagraphs().get(1).getSentences().get(1) },
				{ this.thirdParagraphFirstSentence,
						this.textObjectExpexted.getParagraphs().get(2).getSentences().get(0) },
				{ this.fourthParagraphFirstSentence,
						this.textObjectExpexted.getParagraphs().get(3).getSentences().get(0) } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseSentence#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerSentences", description = "This method get sentence of String.class and parse sentence after return sentence of Sentence.class, if he getting null - CuctomException.class")
	public void testParse(String sentence, Sentence expected) throws CustomException {
		Sentence actual = this.parseSentence.parse(sentence);
		assertEquals(actual, expected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		firstParagraphFirstSentence = null;
		firstParagraphSecondSentence = null;
		secondParagraphFirstSentence = null;
		secondParagraphSecondSentence = null;
		thirdParagraphFirstSentence = null;
		fourthParagraphFirstSentence = null;
		parseSentence = null;
		textObjectExpexted = null;
	}
}