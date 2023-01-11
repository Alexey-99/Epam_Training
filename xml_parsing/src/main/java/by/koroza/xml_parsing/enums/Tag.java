package by.koroza.xml_parsing.enums;

public enum Tag {
	FLOWERS("Flowers"), NAME("Name"), FLOWER("Flower"), SOILS("Soils"), SOIL("Soil"), ORIGIN("Origin"),
	REGION("Region"), CENTURY("Century"), VISUAL_PARAAMETERS("VisualParameters"), STEM_COLOR("StemColor"),
	LEAF_COLOR("LeafColor"), AVERAGE_PLANT_SIZE("AveragePlantSize"), GROWING_TIPS("GrowingTips"),
	TEMPREATURE("Temperature"), LIGHTING("Lighting"), WETERING("Watering"), MULTIPLYING("Multiplying"),
	METHOD("Method"), PLANTING_DATE("PlantingDate");

	private String name;

	private Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}