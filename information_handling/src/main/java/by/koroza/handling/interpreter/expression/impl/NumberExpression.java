package by.koroza.handling.interpreter.expression.impl;

import by.koroza.handling.interpreter.expression.AbstractExpression;

public class NumberExpression extends AbstractExpression {
	private int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	@Override
	public int interpret(AbstractExpression context) {
		return this.number;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + this.number;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		NumberExpression otherNumberExpression = (NumberExpression) object;
		if (this.number != otherNumberExpression.number) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NumberExpression [number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}
}