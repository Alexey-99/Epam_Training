package by.koroza.xml_parsing.enums;

public enum Attribute {
	ID("id"), MEASURE("measure");

	private String name;

	private Attribute(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}