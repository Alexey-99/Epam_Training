package by.koroza.xml_parsing.enums;

public enum ID {
	F1("f1"), F2("f2"), F3("f3"), F4("f4"), F5("f5");

	private String id;

	private ID(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}