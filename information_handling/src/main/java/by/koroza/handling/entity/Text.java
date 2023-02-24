package by.koroza.handling.entity;

import java.util.ArrayList;
import java.util.List;

import by.koroza.handling.entity.abstraction.AbstractText;

public class Text extends AbstractText implements Cloneable {
	private static final String DEFAULT_TITLE = "";

	private String title;
	private List<Paragraph> paragraphs;

	public Text() {
		this.title = DEFAULT_TITLE;
		this.paragraphs = new ArrayList<>();
	}

	public Text(List<Paragraph> paragraphs) {
		this.title = DEFAULT_TITLE;
		this.paragraphs = paragraphs;
	}

	public Text(String title, List<Paragraph> paragraphs) {
		this(paragraphs);
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Paragraph> getParagraphs() {
		return this.paragraphs;
	}

	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public void setParagraph(Paragraph paragraph) {
		this.paragraphs.add(paragraph);
	}

	@Override
	public Text clone() throws CloneNotSupportedException {
		Text text = new Text();
		text.title = new String(this.title);
		this.paragraphs.forEach(paragraphEl -> {
			try {
				text.paragraphs.add(paragraphEl.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		});
		return text;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + (this.title != null ? this.title.hashCode() : 1);
		result = result * PRIME + (this.paragraphs != null ? this.paragraphs.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Text otherText = (Text) object;
		if (this.title == null) {
			if (otherText.title != null) {
				return false;
			}
		} else if (!this.title.equals(otherText.title)) {
			return false;
		}
		if (this.paragraphs == null) {
			if (otherText.paragraphs != null) {
				return false;
			}
		} else if (!this.paragraphs.equals(otherText.paragraphs)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.title != null && !this.title.equals(DEFAULT_TITLE) ? this.title.toUpperCase() + "\n"
				: DEFAULT_TITLE);
		for (int i = 0; i < this.paragraphs.size(); i++) {
			builder.append("\t").append(this.paragraphs.get(i));
			if (i < this.paragraphs.size() - 1) {
				builder.append("\n");
			}
		}
		return builder.toString();
	}

	public static class TextBuilder {
		private Text text;

		public TextBuilder() {
			this.text = new Text();
		}

		public TextBuilder setTitle(String title) {
			text.setTitle(title);
			return this;
		}

		public TextBuilder setParagraphs(List<Paragraph> paragraphs) {
			text.setParagraphs(paragraphs);
			return this;
		}

		public TextBuilder setParagraph(Paragraph paragraph) {
			this.text.setParagraph(paragraph);
			return this;
		}

		public Text build() {
			return this.text;
		}
	}
}