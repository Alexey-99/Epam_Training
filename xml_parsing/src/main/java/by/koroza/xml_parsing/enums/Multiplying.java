package by.koroza.xml_parsing.enums;

public enum Multiplying {
	SEEDS("SEEDS"), LAYERING("LAYERING"), GRAFTING_FROM_BUDS_BUDDING("GRAFTING FROM BUDS (BUDDING)"),
	CUTTINGS("CUTTINGS"), DIVISION_THE_BUSH("DIVISION THE BUSH"), DIVISION_TUBERS("DIVISION TUBERS");

	private String name;

	private Multiplying(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}