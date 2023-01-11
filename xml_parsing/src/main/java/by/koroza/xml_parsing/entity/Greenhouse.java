package by.koroza.xml_parsing.entity;

import java.util.HashSet;
import java.util.Set;

public class Greenhouse {
	private Set<Flower> flowers;
	private static final String STRING_FLOWERS = "Flowers of greenhouse: ";
	private static final String STRING_NEXT_LINE = "\\n";

	public Greenhouse() {
		this.flowers = new HashSet<>();
	}

	public Greenhouse(Set<Flower> flowers) {
		this.flowers = flowers;
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(Set<Flower> flowers) {
		this.flowers = flowers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + (this.flowers == null ? this.flowers.hashCode() : 1);
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
		Greenhouse greenhouse = (Greenhouse) object;
		if (this.flowers == null) {
			if (greenhouse.flowers != null) {
				return false;
			}
		} else if (!this.flowers.equals(greenhouse.flowers)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(STRING_FLOWERS).append(this.flowers).append(STRING_NEXT_LINE);
		return builder.toString();
	}
}