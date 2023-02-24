package by.koroza.handling.entity;

import java.util.ArrayList;
import java.util.List;

import by.koroza.handling.entity.abstraction.AbstractText;

public class Paragraph extends AbstractText implements Cloneable {
	private List<Sentence> sentences;

	public Paragraph() {
		this.sentences = new ArrayList<>();
	}

	public Paragraph(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	public Paragraph(Sentence sentence) {
		this.sentences = new ArrayList<>();
		this.sentences.add(sentence);
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	public void setSentence(Sentence sentence) {
		this.sentences.add(sentence);
	}

	@Override
	public Paragraph clone() throws CloneNotSupportedException {
		Paragraph paragraph = new Paragraph();
		this.sentences.forEach(sentenceEl -> {
			try {
				paragraph.sentences.add(sentenceEl.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		return paragraph;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.sentences != null ? this.sentences.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Paragraph otherParagraph = (Paragraph) object;
		if (this.sentences == null) {
			if (otherParagraph.sentences != null) {
				return false;
			}
		} else if (!this.sentences.equals(otherParagraph.sentences)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.sentences.size(); i++) {
			builder.append(this.sentences.get(i));
			if (i < this.sentences.size() - 1) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}

	public static class ParagraphBuilder {
		private Paragraph paragraph;

		public ParagraphBuilder() {
			this.paragraph = new Paragraph();
		}

		public ParagraphBuilder setSentences(List<Sentence> sentences) {
			this.paragraph.setSentences(sentences);
			return this;
		}

		public ParagraphBuilder setSentence(Sentence sentence) {
			this.paragraph.setSentence(sentence);
			return this;
		}

		public Paragraph build() {
			return this.paragraph;
		}
	}
}