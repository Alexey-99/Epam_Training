package by.koroza.handling.interpreter.expression.impl;

import by.koroza.handling.interpreter.expression.AbstractExpression;

public class NotExpression extends AbstractExpression {
	private AbstractExpression right;

	public NotExpression(AbstractExpression right) {
		this.right = right;
	}

	@Override
	public int interpret(AbstractExpression context) {
		return ~this.right.interpret(context);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.right != null ? this.right.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		NotExpression otherNotExpression = (NotExpression) object;
		if (this.right == null) {
			if (otherNotExpression.right != null) {
				return false;
			}
		} else if (!this.right.equals(otherNotExpression.right)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotExpression [right=");
		builder.append(right);
		builder.append("]");
		return builder.toString();
	}
}