package by.koroza.xml_parsing.entity;

public class GrowingTips {
	private static final String STRING_TEMPERATURE = "Temperature: ";
	private static final String STRING_LIGHTING = ", Lighting: ";
	private static final String STRING_WATERING = ", Watering: ";
	private Temperature temperature;
	private boolean lighting;
	private Watering watering;

	public GrowingTips(Temperature temperature, boolean lighting, Watering watering) {
		this.temperature = temperature;
		this.lighting = lighting;
		this.watering = watering;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public boolean isLighting() {
		return lighting;
	}

	public void setLighting(boolean lighting) {
		this.lighting = lighting;
	}

	public Watering getWatering() {
		return watering;
	}

	public void setWatering(Watering watering) {
		this.watering = watering;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 31;
		result = result * prime + (this.temperature != null ? this.temperature.hashCode() : 1);
		result = result * prime + Boolean.hashCode(this.lighting);
		result = result * prime + (this.watering != null ? this.watering.hashCode() : 1);
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
		GrowingTips growingTips = (GrowingTips) object;
		if (this.temperature == null) {
			if (growingTips.temperature != null) {
				return false;
			}
		} else if (!this.temperature.equals(growingTips.temperature)) {
			return false;
		}
		if (this.lighting != growingTips.lighting) {
			return false;
		}
		if (this.watering == null) {
			if (growingTips.watering != null) {
				return false;
			}
		} else if (!this.watering.equals(growingTips.watering)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(STRING_TEMPERATURE).append(this.temperature.toString());
		builder.append(STRING_LIGHTING).append(this.lighting);
		builder.append(STRING_WATERING).append(this.watering);
		return builder.toString();
	}
}