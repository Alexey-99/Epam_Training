package by.koroza.handling.interpreter;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.handling.exception.CustomException;
import by.koroza.handling.interpreter.expression.AbstractExpression;
import by.koroza.handling.interpreter.expression.impl.AndExpression;
import by.koroza.handling.interpreter.expression.impl.EvaluateExpression;
import by.koroza.handling.interpreter.expression.impl.NotExpression;
import by.koroza.handling.interpreter.expression.impl.NumberExpression;
import by.koroza.handling.interpreter.expression.impl.OrExpression;
import by.koroza.handling.interpreter.expression.impl.ShiftLeftExpression;
import by.koroza.handling.interpreter.expression.impl.ShiftRightExpression;

public class EvaluateExpressionTest {
	private EvaluateExpression evaluateExpression;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.evaluateExpression = new EvaluateExpression();
	}

	/**
	 * */
	@DataProvider(name = "providerIncorectBitExpressions")
	private String[] providerIncorectBitExpressions() {
		return new String[] { "3>>5L", "3svfd>>5L", "sdfgvd>>sbv.3", null };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.interpreter.expression.impl.EvaluateExpression#evaluateExpression(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerIncorectBitExpressions", expectedExceptions = CustomException.class, description = "This test-method testing meethod if input null or incorect string with bit expression in parameters of method. Expected result - CustomException.class")
	public void testEvaluateExpression(String expression) throws CustomException {
		this.evaluateExpression.evaluateExpression(expression);
	}

	/**
	 * */
	@DataProvider(name = "providerBitExpressions")
	private Object[][] providerBitExpressions() {
		return new Object[][] { { "3>>5", new ShiftRightExpression(new NumberExpression(3), new NumberExpression(5)) },
				{ "13<<2", new ShiftLeftExpression(new NumberExpression(13), new NumberExpression(2)) },
				{ "~6&9|(3&4)",
						new OrExpression(
								new AndExpression(new NotExpression(new NumberExpression(6)), new NumberExpression(9)),
								new NumberExpression(0)) },
				{ "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)",
						new OrExpression(new NumberExpression(5), new NumberExpression(1)) },
				{ "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78",
						new OrExpression(new NumberExpression(0), new NumberExpression(78)) },
				{ "(7^5|1&2<<(2|5>>2&71))|1200",
						new OrExpression(new NumberExpression(2), new NumberExpression(1200)) } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.interpreter.expression.impl.EvaluateExpression#evaluateExpression(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerBitExpressions", description = "This test-method testing meethod if input String with bit expression. Expected result - object of AbstractExpression.class")
	public void testEvaluateExpression(String bitExpression, AbstractExpression expected) throws CustomException {
		AbstractExpression actual = this.evaluateExpression.evaluateExpression(bitExpression);
		assertEquals(actual, expected);
	}

	/**
	 * */
	@DataProvider(name = "providerExpressions")
	private Object[][] providerExpressions() {
		return new Object[][] { { "3>>5", 0 }, { "13<<2", 52 }, { "~6&9|(3&4)", 9 },
				{ "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)", 5 }, { "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", 78 },
				{ "(7^5|1&2<<(2|5>>2&71))|1200", 1202 } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.interpreter.expression.impl.EvaluateExpression#interpret(by.koroza.handling.interpreter.expression.AbstractExpression)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerExpressions", description = "This test-method testing meethod if input String with bit expression. Expected result - answer on bit Expression in int.types ")
	public void testInterpret(String expression, int answerBitExpressionExpected) throws CustomException {
		AbstractExpression evaluate = this.evaluateExpression.evaluateExpression(expression);
		int answerBitExpressionActual = evaluate.interpret(evaluate);
		assertEquals(answerBitExpressionActual, answerBitExpressionExpected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		this.evaluateExpression = null;
	}
}