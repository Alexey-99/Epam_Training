package by.koroza.xml_parsing.enums;

public enum Region {
	PERSIA("Persia"), PERU("Peru"), COLOMBIA("Colombia"), SUMATRA_ISLAND("Sumatra island"),
	SOUTH_AFRICA("South Africa");

	private String name;

	private Region(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}