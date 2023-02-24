package by.koroza.handling.interpreter.expression.impl;

import by.koroza.handling.interpreter.expression.AbstractExpression;

public class OrExpression extends AbstractExpression {
	private AbstractExpression left;
	private AbstractExpression right;

	public OrExpression(AbstractExpression left, AbstractExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpret(AbstractExpression context) {
		return this.left.interpret(context) | this.right.interpret(context);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.left != null ? this.left.hashCode() : 1);
		result = result * PRIME + (this.right != null ? this.right.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		OrExpression otherOrExpression = (OrExpression) object;
		if (this.left == null) {
			if (otherOrExpression.left != null) {
				return false;
			}
		} else if (!this.left.equals(otherOrExpression.left)) {
			return false;
		}
		if (this.right == null) {
			if (otherOrExpression.right != null) {
				return false;
			}
		} else if (!this.right.equals(otherOrExpression.right)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrExpression [left=");
		builder.append(left);
		builder.append(", right=");
		builder.append(right);
		builder.append("]");
		return builder.toString();
	}
}