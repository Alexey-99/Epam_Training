package by.koroza.xml_parsing.entity;

public class Watering {
	private static final String STRING_SPACE = " ";
	private String measure;
	private int value;

	public Watering(String measure, int value) {
		this.measure = measure;
		this.value = value;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + (this.measure != null ? this.measure.hashCode() : 1);
		result = result * prime + this.value;
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
		Watering watering = (Watering) object;
		if (this.measure == null) {
			if (watering.measure != null) {
				return false;
			}
		} else if (!this.measure.equals(watering.measure)) {
			return false;
		}
		if (this.value != watering.value) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.value).append(STRING_SPACE).append(this.measure);
		return builder.toString();
	}
}