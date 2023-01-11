package by.koroza.xml_parsing.enums;

public enum Measure {
	CENTIMETERS("sm"),
	DEGREES_CELSIUS("°C"),
	MILILITERS_PER_WEEK("ml/week");

	private String name;

	private Measure(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}