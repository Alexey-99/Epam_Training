package by.koroza.handling.entity;

import by.koroza.handling.entity.abstraction.AbstractText;

public class Symbol extends AbstractText implements Cloneable {
	private char symbol;

	public Symbol() {

	}

	public Symbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public Symbol clone() throws CloneNotSupportedException {
		Symbol symbol = new Symbol(this.symbol);
		return symbol;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + Character.hashCode(this.symbol);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Symbol otherSymbol = (Symbol) object;
		if (this.symbol != otherSymbol.symbol) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.symbol);
		return builder.toString();
	}
}