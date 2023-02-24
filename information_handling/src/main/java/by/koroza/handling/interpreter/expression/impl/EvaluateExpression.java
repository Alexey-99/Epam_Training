package by.koroza.handling.interpreter.expression.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.koroza.handling.exception.CustomException;
import by.koroza.handling.interpreter.expression.AbstractExpression;
import by.koroza.handling.interpreter.expression.impl.preorety.ExpressionPreorety;

public class EvaluateExpression extends AbstractExpression {
	private AbstractExpression avaluate;
	private static final String REG_EX_BIT_EXPRESSIONS = "((\\W+)?(\\d+)(\\W+)?)+";

	private static final String REG_EX_SYMBOL_SHIFTS_LEFT_OR_RIGHT_EXPRESSION = "(\\>{2})|(\\<{2})";
	private static final String REG_EX_SYMBOL_NOT_EXPRESSION = "\\~";
	private static final String REG_EX_SYMBOL_NOT_EXPRESSION__POSITIV_OR_NEGATIVE_DIGIT = REG_EX_SYMBOL_NOT_EXPRESSION
			+ "(\\d+|\\-\\d+)";
	private static final String REG_EX_SYMBOL_AND_EXPRESSION = "\\&";
	private static final String REG_EX_SYMBOL_HOR_EXPRESSION = "\\^";
	private static final String REG_EX_SYMBOL_OR_EXPRESSION = "(\\|)";
	private static final String REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_LEFT = "(\\-\\d+|\\d+)(";
	private static final String REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_RIGHT = ")(\\-\\d+|\\d+)";

	public AbstractExpression evaluateExpression(String expression) throws CustomException {
		if (expression != null && expression.matches(REG_EX_BIT_EXPRESSIONS)) {
			while (!checkPreoreties(expression)) {
				for (Entry<Integer, String> entry : new ExpressionPreorety().getPREORETIES().entrySet()) {
					Integer key = entry.getKey();
					String val = entry.getValue();

					Pattern p = Pattern.compile(val);
					Matcher m = p.matcher(expression);
					while (m.find() || m.lookingAt() || m.matches()) {
						switch (key) {
						case 1 -> {
							switch (val) {
							case REG_EX_PARENTHESE__ANY_SIMBOLS__PARENTHESE -> {
								String expressionInParentheses = getExpressionInParentheses(expression);
								String expressionWithoutParentheses = new String(expressionInParentheses.toCharArray(),
										1, expressionInParentheses.length() - 2);
								AbstractExpression ex = evaluateExpression(expressionWithoutParentheses);

								expression = expression.replaceFirst(createPatternForReplace(expressionInParentheses),
										Integer.toString(ex.interpret(ex)));
								m = p.matcher(expression);
							}
							}
						}
						case 2 -> {
							switch (val) {
							case REG_EX_SYMBOL_NOT_EXPRESSION -> {
								p = Pattern.compile(REG_EX_SYMBOL_NOT_EXPRESSION__POSITIV_OR_NEGATIVE_DIGIT);
								m = p.matcher(expression);
								if (m.lookingAt() || m.find() || m.matches()) {
									String foundResult = m.group();
									AbstractExpression ex = this.calcFinalExpresion(foundResult);
									expression = expression.replaceFirst(
											REG_EX_SYMBOL_NOT_EXPRESSION__POSITIV_OR_NEGATIVE_DIGIT,
											Integer.toString(ex.interpret(ex)));
									m = p.matcher(expression);
								}
							}
							}
						}
						case 4 -> {
							switch (val) {
							case REG_EX_SYMBOL_SHIFTS_LEFT_OR_RIGHT_EXPRESSION -> {
								String pattern = REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_LEFT + val
										+ REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_RIGHT;
								p = Pattern.compile(pattern);
								m = p.matcher(expression);
								if (m.lookingAt() || m.find() || m.matches()) {
									String foundResult = m.group();
									AbstractExpression ex = this.calcFinalExpresion(foundResult);
									expression = expression.replaceFirst(pattern, Integer.toString(ex.interpret(ex)));
									m = p.matcher(expression);
								}
							}
							}
						}
						case 7 -> {
							switch (val) {
							case REG_EX_SYMBOL_AND_EXPRESSION -> {
								String pattern = REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_LEFT + val
										+ REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_RIGHT;
								p = Pattern.compile(pattern);
								m = p.matcher(expression);
								if (m.lookingAt() || m.find() || m.matches()) {
									String foundResult = m.group();
									AbstractExpression ex = this.calcFinalExpresion(foundResult);
									expression = expression.replaceFirst(pattern, Integer.toString(ex.interpret(ex)));
									m = p.matcher(expression);
								}
							}
							}
						}
						case 8 -> {
							switch (val) {
							case REG_EX_SYMBOL_HOR_EXPRESSION -> {
								String pattern = REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_LEFT + val
										+ REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_RIGHT;
								p = Pattern.compile(pattern);
								m = p.matcher(expression);
								if (m.lookingAt() || m.find() || m.matches()) {
									String foundResult = m.group();
									AbstractExpression ex = this.calcFinalExpresion(foundResult);
									expression = expression.replaceFirst(pattern, Integer.toString(ex.interpret(ex)));
									m = p.matcher(expression);
								}
							}
							}
						}
						case 9 -> {
							switch (val) {
							case REG_EX_SYMBOL_OR_EXPRESSION -> {
								String pattern = REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_LEFT + val
										+ REG_EX_POSITIVE_OR_NEGATIVE_DIGITS_IN_PARENTHESES__PARENTHES_RIGHT;
								p = Pattern.compile(pattern);
								m = p.matcher(expression);
								if (m.lookingAt() || m.find() || m.matches()) {
									String foundResult = m.group();
									AbstractExpression ex = this.calcFinalExpresion(foundResult);
									expression = expression.replaceFirst(pattern, Integer.toString(ex.interpret(ex)));
									m = p.matcher(expression);
								}
							}
							}
						}
						}
					}
					if (checkPreoreties(expression)) {
						this.avaluate = this.calcFinalExpresion(expression);
						expression = Integer.toString(this.avaluate.interpret(this.avaluate));
						break;
					}
				}
			}
			if (!expression.matches(REG_EX_DIGITS) && checkPreoreties(expression)) {
				this.avaluate = this.calcFinalExpresion(expression);
			}
		} else {
			throw new CustomException("You entered expression: " + expression);
		}
		return this.avaluate;
	}

	@Override
	public int interpret(AbstractExpression context) {
		return this.avaluate != null ? this.avaluate.interpret(context) : null;
	}

	private String createPatternForReplace(String expressionInParentheses) {
		StringBuilder build = new StringBuilder();
		for (char ch : expressionInParentheses.toCharArray()) {
			if (!Character.isDigit(ch)) {
				build.append("\\").append(ch);
			} else {
				build.append(ch);
			}
		}
		return build.toString();
	}

	private String getExpressionInParentheses(String expression) {
		StringBuilder builder = new StringBuilder();
		String[] expressionSymbols = expression.trim().split("");
		int countParentheses = 0;
		boolean isWentInParenthese = false;
		int countParenthese = 0;
		for (int i = 0; i < expressionSymbols.length; i++) {
			if (expressionSymbols[i].equals("(") && isWentInParenthese == false && countParentheses == 0
					&& countParenthese == 0) {
				countParentheses++;
				isWentInParenthese = true;
				builder.append(expressionSymbols[i]);
				countParenthese++;
			} else if (isWentInParenthese && countParentheses > 0) {
				builder.append(expressionSymbols[i]);
				if (expressionSymbols[i].equals("(")) {
					countParentheses++;
				}
				if (expressionSymbols[i].equals(")")) {
					countParentheses--;
				}
				if (countParentheses == 0) {
					isWentInParenthese = false;
				}
			}
		}
		return builder.toString();
	}

	private static final String REG_EX_NON_DIGIT_SYMBOL = "\\D";
	private static final String REG_EX_PARENTHESES_LEFT_OR_RIGHT = "\\(|\\)";
	private static final String REG_EX_PARENTHESE__ANY_SIMBOLS__PARENTHESE = "\\(.+\\)";
	private static final String REG_EX_ONE_SHIFT_LEFT_OR_RIGHT = "\\<|\\>";
	private static final String REG_EX_TWO_SHIFTS_LEFT_OR_RIGHT = "(\\>{2})|(\\<{2})";

	private boolean checkPreoreties(String expression) {
		boolean isEqualPreoreties = true;
		ExpressionPreorety preoreties = new ExpressionPreorety();
		int preorety = 0;

		String[] expressions = expression.trim().split("");

		for (int i = 0; i < expressions.length && isEqualPreoreties; i++) {
			if (!expressions[i].isBlank() && expressions[i].matches(REG_EX_NON_DIGIT_SYMBOL)) {
				for (Entry<Integer, String> entry : preoreties.getPREORETIES().entrySet()) {
					if (isEqualPreoreties) {
						Integer key = entry.getKey();
						String val = entry.getValue();

						if (preorety == 0 && (expressions[i].matches(val)
								|| (expressions[i].matches(REG_EX_PARENTHESES_LEFT_OR_RIGHT)
										&& val.equals(REG_EX_PARENTHESE__ANY_SIMBOLS__PARENTHESE))
								|| (expressions[i].matches(REG_EX_ONE_SHIFT_LEFT_OR_RIGHT)
										&& val.equals(REG_EX_TWO_SHIFTS_LEFT_OR_RIGHT)))) {
							if (expressions[i].matches(REG_EX_PARENTHESES_LEFT_OR_RIGHT)
									&& val.equals(REG_EX_PARENTHESE__ANY_SIMBOLS__PARENTHESE)) {
								isEqualPreoreties = false;
							}
							preorety = key;
						} else if (preorety > 0 && ((expressions[i].matches(val)
								|| (expressions[i].matches(REG_EX_PARENTHESES_LEFT_OR_RIGHT)
										&& val.equals(REG_EX_PARENTHESE__ANY_SIMBOLS__PARENTHESE))
								|| (expressions[i].matches(REG_EX_ONE_SHIFT_LEFT_OR_RIGHT)
										&& val.equals(REG_EX_TWO_SHIFTS_LEFT_OR_RIGHT))))) {
							if (preorety > key || (expressions[i].matches(REG_EX_PARENTHESES_LEFT_OR_RIGHT)
									&& val.equals(REG_EX_PARENTHESE__ANY_SIMBOLS__PARENTHESE))) {
								isEqualPreoreties = false;
							} else {
								preorety = key;
							}
						}
					}
				}
			}
		}
		return isEqualPreoreties;
	}

	private static final String SYMBOL_SHIFT_LEFT_EXPRESSION = "<<";
	private static final String SYMBOL_SHIFT_RIGHT_EXPRESSION = ">>";
	private static final String SYMBOL_NOT_EXPRESSION = "~";
	private static final String SYMBOL_AND_EXPRESSION = "&";
	private static final String SYMBOL_HOR_EXPRESSION = "^";
	private static final String SYMBOL_OR_EXPRESSION = "|";

	private AbstractExpression calcFinalExpresion(String expression) {
		Stack<AbstractExpression> expressions = new Stack<>();
		List<String> numbersExpression = parseNumberExpressions(expression);
		for (int i = numbersExpression.size() - 1; i >= 0; i--) {
			if (!numbersExpression.get(i).isBlank()) {
				expressions.push(new NumberExpression(Integer.parseInt(numbersExpression.get(i))));
			}
		}
		List<String> expressionsList = parseExpressions(expression);
		for (String s : expressionsList) {
			switch (s.trim()) {
			case SYMBOL_SHIFT_LEFT_EXPRESSION ->
				expressions.push(new ShiftLeftExpression(expressions.pop(), expressions.pop()));
			case SYMBOL_SHIFT_RIGHT_EXPRESSION ->
				expressions.push(new ShiftRightExpression(expressions.pop(), expressions.pop()));
			case SYMBOL_NOT_EXPRESSION -> expressions.push(new NotExpression(expressions.pop()));
			case SYMBOL_AND_EXPRESSION -> expressions.push(new AndExpression(expressions.pop(), expressions.pop()));
			case SYMBOL_HOR_EXPRESSION -> expressions.push(new XORExpression(expressions.pop(), expressions.pop()));
			case SYMBOL_OR_EXPRESSION -> expressions.push(new OrExpression(expressions.pop(), expressions.pop()));
			}
		}
		return expressions.pop();
	}

	private static final String REG_EX_FIND_NUMBER_WITH_BEFORE_SYMBOL = "\\D?(\\-\\d+|\\d+)";
	private static final String REG_EX_FIND_NUMBER = "\\-\\d+|\\d+";

	private List<String> parseNumberExpressions(String expression) {
		List<String> numbersExpressionList = new ArrayList<>();
		Pattern pNumberExpression = Pattern.compile(REG_EX_FIND_NUMBER_WITH_BEFORE_SYMBOL);
		Matcher mNumberExpression = pNumberExpression.matcher(expression);
		while (mNumberExpression.find()) {
			String foundResult = mNumberExpression.group();
			if (foundResult.matches(REG_EX_FIND_NUMBER)) {
				numbersExpressionList.add(foundResult);
			} else {
				Pattern pNumberExpressionInner = Pattern.compile(REG_EX_FIND_NUMBER);
				Matcher mNumberExpressionInner = pNumberExpressionInner.matcher(foundResult);
				if (mNumberExpressionInner.find() || mNumberExpressionInner.lookingAt()) {
					numbersExpressionList.add(mNumberExpressionInner.group());
				}
			}
		}
		return numbersExpressionList;
	}

	private static final String REG_EX_FIND_ANY_SYMBOL__MUNUS__DIGITS = ".?\\-.?|\\D+";
	private static final String REG_EX_NON_DEGIT_SIMBOLS = "\\D+";
	private static final String REG_EX_DIGITS__MINUS__POSITIVE_OR_NEGATIVE_DIGIT = "\\d+\\-(\\-\\d+|\\d+)";
	private static final String REG_EX_DIGITS__MINUS = "\\d+\\-";
	private static final String REG_EX_MINUS = "\\-";
	private static final String REG_EX_NON_DEGIT_SIMBOLS__MINUS__DIGITS = REG_EX_NON_DEGIT_SIMBOLS + "\\-\\d+";
	private static final String REG_EX_DIGITS = "\\d+";

	private List<String> parseExpressions(String expression) {
		List<String> expressionsList = new ArrayList<>();
		Pattern pExpression = Pattern.compile(REG_EX_FIND_ANY_SYMBOL__MUNUS__DIGITS);
		Matcher mExpression = pExpression.matcher(expression);
		while (mExpression.find()) {
			String foundResultPExpression = mExpression.group();
			if (foundResultPExpression.matches(REG_EX_NON_DEGIT_SIMBOLS)) {
				expressionsList.add(foundResultPExpression);
			} else if (foundResultPExpression.matches(REG_EX_DIGITS__MINUS__POSITIVE_OR_NEGATIVE_DIGIT)) {
				Pattern pExpressionInner = Pattern.compile(REG_EX_DIGITS__MINUS);
				Matcher mExpressionInner = pExpressionInner.matcher(foundResultPExpression);
				if (mExpressionInner.find() || mExpressionInner.lookingAt()) {
					String foundResultPExpressionInner = mExpressionInner.group();
					Pattern pExpressionInner2 = Pattern.compile(REG_EX_MINUS);
					Matcher mExpressionInner2 = pExpressionInner2.matcher(foundResultPExpressionInner);
					if (mExpressionInner2.find()) {
						expressionsList.add(mExpressionInner2.group());
					}
				}
			} else if (foundResultPExpression.matches(REG_EX_NON_DEGIT_SIMBOLS__MINUS__DIGITS)) {
				String foundResultPExpressionWithoutDigit = foundResultPExpression.replaceFirst(REG_EX_DIGITS, "");
				char[] foundResultPExpressionWithoutDigitChars = foundResultPExpressionWithoutDigit.toCharArray();
				int indexOfMinus = foundResultPExpressionWithoutDigitChars.length - 1;
				String foundResultPExpressionWithoutDigitWithoutMunus = new String(
						foundResultPExpressionWithoutDigitChars, 0, indexOfMinus);
				expressionsList.add(foundResultPExpressionWithoutDigitWithoutMunus);
			}
		}
		return expressionsList;
	}
}