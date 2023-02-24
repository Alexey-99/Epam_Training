package by.koroza.handling.interpreter.expression;

public abstract class AbstractExpression {

	public abstract int interpret(AbstractExpression context);

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!this.getClass().equals(object.getClass())) {
			return false;
		}
		return true;
	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		return build.toString();
	}
}