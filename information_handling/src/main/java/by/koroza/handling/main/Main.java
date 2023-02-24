package by.koroza.handling.main;

import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.interpreter.expression.AbstractExpression;
import by.koroza.handling.interpreter.expression.impl.EvaluateExpression;
import by.koroza.handling.parsing.ParseFactory;
import by.koroza.handling.reader.Reader;
import by.koroza.handling.service.impl.TextSeviceImpl;

public class Main {
	private static final String FILE_PATH = "src/main/resources/text.txt";
	private static final String FILE_PATH_OPTIONAL = "src/main/resources/text_optional.txt";

	public static void main(String[] args) throws CustomException {

		String expression1 = "13<<2";
		AbstractExpression avaluate1 = new EvaluateExpression().evaluateExpression(expression1);
		System.out.println("13<<2 = " + (13 << 2));
		System.out.println(avaluate1.interpret(avaluate1));

		String expression2 = "3>>5";
		AbstractExpression avaluate2 = new EvaluateExpression().evaluateExpression(expression2);
		System.out.println("3>>5 = " + (3 >> 5));
		System.out.println(avaluate2.interpret(avaluate2));

		String expression3 = "~6&9|(3&4)";
		AbstractExpression avaluate3 = new EvaluateExpression().evaluateExpression(expression3);
		System.out.println("~6&9|(3&4) = " + (~6 & 9 | (3 & 4)));
		System.out.println(avaluate3.interpret(avaluate3));

		String expression4 = "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78"; // ~6&9| (3&4) -- () -> ~ -> & -> |
		AbstractExpression avaluate4 = new EvaluateExpression().evaluateExpression(expression4);
		System.out.println("(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78  = "
				+ ((~71 & (2 & 3 | (3 | (2 & 1 >> 2 | 2) & 2) | 10 & 2)) | 78));
		System.out.println(avaluate4.interpret(avaluate4));

		String expression5 = "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)";
		AbstractExpression avaluate5 = new EvaluateExpression().evaluateExpression(expression5);
		System.out.println("5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)  = "
				+ (5 | (1 & 2 & (3 | (4 & (1 ^ 5 | 6 & 47) | 3) | (~89 & 4 | (42 & 7))) | 1)));
		System.out.println(avaluate5.interpret(avaluate5));

		String expression6 = "(7^5|1&2<<(2|5>>2&71))|1200";
		AbstractExpression avaluate6 = new EvaluateExpression().evaluateExpression(expression6);
		System.out.println("(7^5|1&2<<(2|5>>2&71))|1200 = " + ((7 ^ 5 | 1 & 2 << (2 | 5 >> 2 & 71)) | 1200));
		System.out.println(avaluate6.interpret(avaluate6));

		xxx();
	}

	public static void xxx() throws CustomException {
		String text = new Reader().readTextFromFile(FILE_PATH);
		System.out.println(ParseFactory.newParseText().parse(text));

		System.out.println();

		Text textObject = ParseFactory.newParseText().parse(text);

		new TextSeviceImpl().sortParagraphsByNumberSentence(textObject);

		System.out.println(new TextSeviceImpl().countConsonantLetters(textObject));

		System.out.println();

		System.out.println(textObject);
	}
}