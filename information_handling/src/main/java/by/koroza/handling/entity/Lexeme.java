package by.koroza.handling.entity;

import java.util.ArrayList;
import java.util.List;

import by.koroza.handling.entity.abstraction.AbstractText;

public class Lexeme extends AbstractText implements Cloneable {
	private List<Symbol> symbols;

	public Lexeme() {
		this.symbols = new ArrayList<>();
	}

	public Lexeme(List<Symbol> symbols) {
		this.symbols = symbols;
	}

	public List<Symbol> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<Symbol> symbols) {
		this.symbols = symbols;
	}

	public void setSymbol(Symbol symbol) {
		this.symbols.add(symbol);
	}

	@Override
	public Lexeme clone() throws CloneNotSupportedException {
		Lexeme lexeme = new Lexeme();
		this.symbols.forEach(symbolEl -> {
			try {
				lexeme.symbols.add(symbolEl.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		return lexeme;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.symbols != null ? this.symbols.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Lexeme otherLexeme = (Lexeme) object;
		if (this.symbols == null) {
			if (otherLexeme.symbols != null) {
				return false;
			}
		} else if (!this.symbols.equals(otherLexeme.symbols)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Symbol symbol : this.symbols) {
			builder.append(symbol);
		}
		return builder.toString();
	}

	public static class LexemeBuilder {
		private Lexeme lexeme;

		public LexemeBuilder() {
			this.lexeme = new Lexeme();
		}

		public LexemeBuilder setSymbols(List<Symbol> symbols) {
			lexeme.setSymbols(symbols);
			return this;
		}

		public LexemeBuilder setSymbol(Symbol symbol) {
			lexeme.setSymbol(symbol);
			return this;
		}

		public Lexeme build() {
			return this.lexeme;
		}
	}
}