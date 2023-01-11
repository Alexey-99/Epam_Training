package by.koroza.xml_parsing.enums;

public enum Soil {
	LIGHT("light"), LOAMY("loamy"), MEDIUM_LOAMY("medium loamy"), CLAY("clay"), SANDY("sandy"),
	LOOSE_MOIST("loose moist"), GARDEN_SOIL_AND_SAND("garden soil and sand"), FERTILE_LOOSE("fertile loose");

	private String nameSoil;

	private Soil(String nameSoil) {
		this.setName(nameSoil);
	}

	public String getName() {
		return nameSoil;
	}

	public void setName(String nameSoil) {
		this.nameSoil = nameSoil;
	}
}