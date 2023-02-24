package by.koroza.handling.entity;

import java.util.ArrayList;
import java.util.List;

import by.koroza.handling.entity.abstraction.AbstractText;

public class Sentence extends AbstractText implements Cloneable {
	private List<Lexeme> lexemes;

	public Sentence() {
		this.lexemes = new ArrayList<>();
	}

	public Sentence(List<Lexeme> lexemes) {
		this.lexemes = lexemes;
	}

	public List<Lexeme> getLexemes() {
		return lexemes;
	}

	public void setLexemes(List<Lexeme> lexemes) {
		this.lexemes = lexemes;
	}

	@Override
	public Sentence clone() throws CloneNotSupportedException {
		Sentence sentence = new Sentence();
		this.lexemes.forEach(lexemeEl -> {
			try {
				sentence.lexemes.add(lexemeEl.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		return sentence;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.lexemes != null ? this.lexemes.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Sentence otherSentence = (Sentence) object;
		if (this.lexemes == null) {
			if (otherSentence.lexemes != null) {
				return false;
			}
		} else if (!this.lexemes.equals(otherSentence.lexemes)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.lexemes.size(); i++) {
			builder.append(this.lexemes.get(i));
			if (i < this.lexemes.size() - 1) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}

	public static class SentenceBuilder {
		private Sentence sentence;

		public SentenceBuilder() {
			this.sentence = new Sentence();
		}

		public SentenceBuilder setLexemes(List<Lexeme> lexemes) {
			sentence.setLexemes(lexemes);
			return this;
		}

		public Sentence build() {
			return this.sentence;
		}
	}
}