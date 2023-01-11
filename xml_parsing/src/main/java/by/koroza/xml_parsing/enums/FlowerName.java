package by.koroza.xml_parsing.enums;

public enum FlowerName {
	ROSE("Rose"), ALSTROEMERIA("Alstroemeria"), AQUILEGIA_COLOMBIAN("Aquilegia Colombian"),
	AMORPHOPHALLUS_TITANIC("Amorphophallus titanic"), AFRICAN_DAISIES("African daisies");

	private String name;

	private FlowerName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}