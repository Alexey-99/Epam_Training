package by.koroza.xml_parsing.parsing.dom.writer;

import static by.koroza.xml_parsing.enums.Tag.AVERAGE_PLANT_SIZE;
import static by.koroza.xml_parsing.enums.Tag.CENTURY;
import static by.koroza.xml_parsing.enums.Tag.FLOWER;
import static by.koroza.xml_parsing.enums.Tag.FLOWERS;
import static by.koroza.xml_parsing.enums.Tag.GROWING_TIPS;
import static by.koroza.xml_parsing.enums.Tag.LEAF_COLOR;
import static by.koroza.xml_parsing.enums.Tag.LIGHTING;
import static by.koroza.xml_parsing.enums.Tag.METHOD;
import static by.koroza.xml_parsing.enums.Tag.MULTIPLYING;
import static by.koroza.xml_parsing.enums.Tag.NAME;
import static by.koroza.xml_parsing.enums.Tag.ORIGIN;
import static by.koroza.xml_parsing.enums.Tag.PLANTING_DATE;
import static by.koroza.xml_parsing.enums.Tag.REGION;
import static by.koroza.xml_parsing.enums.Tag.SOIL;
import static by.koroza.xml_parsing.enums.Tag.SOILS;
import static by.koroza.xml_parsing.enums.Tag.STEM_COLOR;
import static by.koroza.xml_parsing.enums.Tag.TEMPREATURE;
import static by.koroza.xml_parsing.enums.Tag.VISUAL_PARAAMETERS;
import static by.koroza.xml_parsing.enums.Tag.WETERING;
import static by.koroza.xml_parsing.enums.Attribute.ID;
import static by.koroza.xml_parsing.enums.Attribute.MEASURE;
import static by.koroza.xml_parsing.enums.ID.F1;
import static by.koroza.xml_parsing.enums.ID.F2;
import static by.koroza.xml_parsing.enums.ID.F3;
import static by.koroza.xml_parsing.enums.ID.F4;
import static by.koroza.xml_parsing.enums.ID.F5;
import static by.koroza.xml_parsing.enums.Measure.CENTIMETERS;
import static by.koroza.xml_parsing.enums.Measure.DEGREES_CELSIUS;
import static by.koroza.xml_parsing.enums.Measure.MILILITERS_PER_WEEK;
import static by.koroza.xml_parsing.enums.FlowerName.AFRICAN_DAISIES;
import static by.koroza.xml_parsing.enums.FlowerName.ALSTROEMERIA;
import static by.koroza.xml_parsing.enums.FlowerName.AMORPHOPHALLUS_TITANIC;
import static by.koroza.xml_parsing.enums.FlowerName.AQUILEGIA_COLOMBIAN;
import static by.koroza.xml_parsing.enums.FlowerName.ROSE;
import static by.koroza.xml_parsing.enums.Soil.CLAY;
import static by.koroza.xml_parsing.enums.Soil.FERTILE_LOOSE;
import static by.koroza.xml_parsing.enums.Soil.GARDEN_SOIL_AND_SAND;
import static by.koroza.xml_parsing.enums.Soil.LIGHT;
import static by.koroza.xml_parsing.enums.Soil.LOAMY;
import static by.koroza.xml_parsing.enums.Soil.LOOSE_MOIST;
import static by.koroza.xml_parsing.enums.Soil.MEDIUM_LOAMY;
import static by.koroza.xml_parsing.enums.Soil.SANDY;
import static by.koroza.xml_parsing.enums.Region.COLOMBIA;
import static by.koroza.xml_parsing.enums.Region.PERSIA;
import static by.koroza.xml_parsing.enums.Region.PERU;
import static by.koroza.xml_parsing.enums.Region.SOUTH_AFRICA;
import static by.koroza.xml_parsing.enums.Region.SUMATRA_ISLAND;
import static by.koroza.xml_parsing.enums.Multiplying.CUTTINGS;
import static by.koroza.xml_parsing.enums.Multiplying.DIVISION_THE_BUSH;
import static by.koroza.xml_parsing.enums.Multiplying.DIVISION_TUBERS;
import static by.koroza.xml_parsing.enums.Multiplying.GRAFTING_FROM_BUDS_BUDDING;
import static by.koroza.xml_parsing.enums.Multiplying.LAYERING;
import static by.koroza.xml_parsing.enums.Multiplying.SEEDS;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriterTagsToXMLFileDOM {

	public void writeTagsToFile(Document document) {
		Element flowers = document.createElement(FLOWERS.getName());
		document.appendChild(flowers);
		flowers.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		flowers.setAttribute("xmlns", "http://www.flowers.com/Flowers");
		flowers.setAttribute("xsi:schemaLocation", "http://www.flowers.com/Flowers flowers.xsd");
		createRoze(document, flowers);
		createAlstroemeria(document, flowers);
		createAquilegiaColombian(document, flowers);
		createAmorphophallusTitanic(document, flowers);
		createAfricanDaisies(document, flowers);
	}

	private void createRoze(Document document, Element flowers) {
		Element flower = document.createElement(FLOWER.getName());
		Element name = document.createElement(NAME.getName());
		Element soils = document.createElement(SOILS.getName());
		Element soilOne = document.createElement(SOIL.getName());
		Element soilTwo = document.createElement(SOIL.getName());
		Element soilThree = document.createElement(SOIL.getName());
		Element origin = document.createElement(ORIGIN.getName());
		Element country = document.createElement(REGION.getName());
		Element century = document.createElement(CENTURY.getName());
		Element visualParameters = document.createElement(VISUAL_PARAAMETERS.getName());
		Element stemСolor = document.createElement(STEM_COLOR.getName());
		Element leafColor = document.createElement(LEAF_COLOR.getName());
		Element averagePlantSize = document.createElement(AVERAGE_PLANT_SIZE.getName());
		Element growingTips = document.createElement(GROWING_TIPS.getName());
		Element temperature = document.createElement(TEMPREATURE.getName());
		Element lighting = document.createElement(LIGHTING.getName());
		Element watering = document.createElement(WETERING.getName());
		Element multiplying = document.createElement(MULTIPLYING.getName());
		Element methodOne = document.createElement(METHOD.getName());
		Element methodTwo = document.createElement(METHOD.getName());
		Element methodThree = document.createElement(METHOD.getName());
		Element methodFour = document.createElement(METHOD.getName());
		Element plantingDate = document.createElement(PLANTING_DATE.getName());

		flowers.appendChild(flower).appendChild(name);
		flower.appendChild(soils).appendChild(soilOne);
		flower.appendChild(soils).appendChild(soilTwo);
		flower.appendChild(soils).appendChild(soilThree);
		flower.appendChild(origin).appendChild(country);
		origin.appendChild(century);
		flower.appendChild(visualParameters).appendChild(stemСolor);
		visualParameters.appendChild(leafColor);
		visualParameters.appendChild(averagePlantSize);
		flower.appendChild(growingTips).appendChild(temperature);
		growingTips.appendChild(lighting);
		growingTips.appendChild(watering);
		flower.appendChild(multiplying);
		multiplying.appendChild(methodOne);
		multiplying.appendChild(methodTwo);
		multiplying.appendChild(methodThree);
		multiplying.appendChild(methodFour);
		flower.appendChild(plantingDate);

		flower.setAttribute(ID.getName(), F1.getId());
		averagePlantSize.setAttribute(MEASURE.getName(), CENTIMETERS.getName());
		temperature.setAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		watering.setAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());

		name.appendChild(document.createTextNode(ROSE.getName()));
		soilOne.appendChild(document.createTextNode(LIGHT.getName()));
		soilTwo.appendChild(document.createTextNode(LOAMY.getName()));
		soilThree.appendChild(document.createTextNode(MEDIUM_LOAMY.getName()));
		country.appendChild(document.createTextNode(PERSIA.getName()));
		century.appendChild(document.createTextNode("19"));
		stemСolor.appendChild(document.createTextNode("green"));
		leafColor.appendChild(document.createTextNode("green"));
		averagePlantSize.appendChild(document.createTextNode("70"));
		temperature.appendChild(document.createTextNode("-5"));
		lighting.appendChild(document.createTextNode("true"));
		watering.appendChild(document.createTextNode("10"));
		methodOne.appendChild(document.createTextNode(SEEDS.getName()));
		methodTwo.appendChild(document.createTextNode(LAYERING.getName()));
		methodThree.appendChild(document.createTextNode(GRAFTING_FROM_BUDS_BUDDING.getName()));
		methodFour.appendChild(document.createTextNode(CUTTINGS.getName()));
		plantingDate.appendChild(document.createTextNode("2015-03-06T10:23:05"));
	}

	private void createAlstroemeria(Document document, Element flowers) {
		Element flower = document.createElement(FLOWER.getName());
		Element name = document.createElement(NAME.getName());
		Element soils = document.createElement(SOILS.getName());
		Element soilOne = document.createElement(SOIL.getName());
		Element soilTwo = document.createElement(SOIL.getName());
		Element origin = document.createElement(ORIGIN.getName());
		Element country = document.createElement(REGION.getName());
		Element century = document.createElement(CENTURY.getName());
		Element visualParameters = document.createElement(VISUAL_PARAAMETERS.getName());
		Element stemСolor = document.createElement(STEM_COLOR.getName());
		Element leafColor = document.createElement(LEAF_COLOR.getName());
		Element averagePlantSize = document.createElement(AVERAGE_PLANT_SIZE.getName());
		Element growingTips = document.createElement(GROWING_TIPS.getName());
		Element temperature = document.createElement(TEMPREATURE.getName());
		Element lighting = document.createElement(LIGHTING.getName());
		Element watering = document.createElement(WETERING.getName());
		Element multiplying = document.createElement(MULTIPLYING.getName());
		Element methodOne = document.createElement(METHOD.getName());
		Element methodTwo = document.createElement(METHOD.getName());
		Element plantingDate = document.createElement(PLANTING_DATE.getName());

		flowers.appendChild(flower).appendChild(name);
		flower.appendChild(soils).appendChild(soilOne);
		flower.appendChild(soils).appendChild(soilTwo);
		flower.appendChild(origin).appendChild(country);
		origin.appendChild(century);
		flower.appendChild(visualParameters).appendChild(stemСolor);
		visualParameters.appendChild(leafColor);
		visualParameters.appendChild(averagePlantSize);
		flower.appendChild(growingTips).appendChild(temperature);
		growingTips.appendChild(lighting);
		growingTips.appendChild(watering);
		flower.appendChild(multiplying);
		multiplying.appendChild(methodOne);
		multiplying.appendChild(methodTwo);
		flower.appendChild(plantingDate);

		flower.setAttribute(ID.getName(), F2.getId());
		averagePlantSize.setAttribute(MEASURE.getName(), CENTIMETERS.getName());
		temperature.setAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		watering.setAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());

		name.appendChild(document.createTextNode(ALSTROEMERIA.getName()));
		soilOne.appendChild(document.createTextNode(CLAY.getName()));
		soilTwo.appendChild(document.createTextNode(SANDY.getName()));
		country.appendChild(document.createTextNode(PERU.getName()));
		century.appendChild(document.createTextNode("17"));
		stemСolor.appendChild(document.createTextNode("green"));
		leafColor.appendChild(document.createTextNode("green"));
		averagePlantSize.appendChild(document.createTextNode("150"));
		temperature.appendChild(document.createTextNode("+19"));
		lighting.appendChild(document.createTextNode("true"));
		watering.appendChild(document.createTextNode("5"));
		methodOne.appendChild(document.createTextNode(SEEDS.getName()));
		methodTwo.appendChild(document.createTextNode(GRAFTING_FROM_BUDS_BUDDING.getName()));
		plantingDate.appendChild(document.createTextNode("2018-08-20T12:08:10"));
	}

	private void createAquilegiaColombian(Document document, Element flowers) {
		Element flower = document.createElement(FLOWER.getName());
		Element name = document.createElement(NAME.getName());
		Element soils = document.createElement(SOILS.getName());
		Element soil = document.createElement(SOIL.getName());
		Element origin = document.createElement(ORIGIN.getName());
		Element country = document.createElement(REGION.getName());
		Element century = document.createElement(CENTURY.getName());
		Element visualParameters = document.createElement(VISUAL_PARAAMETERS.getName());
		Element stemСolor = document.createElement(STEM_COLOR.getName());
		Element leafColor = document.createElement(LEAF_COLOR.getName());
		Element averagePlantSize = document.createElement(AVERAGE_PLANT_SIZE.getName());
		Element growingTips = document.createElement(GROWING_TIPS.getName());
		Element temperature = document.createElement(TEMPREATURE.getName());
		Element lighting = document.createElement(LIGHTING.getName());
		Element watering = document.createElement(WETERING.getName());
		Element multiplying = document.createElement(MULTIPLYING.getName());
		Element methodOne = document.createElement(METHOD.getName());
		Element methodTwo = document.createElement(METHOD.getName());
		Element plantingDate = document.createElement(PLANTING_DATE.getName());

		flowers.appendChild(flower).appendChild(name);
		flower.appendChild(soils).appendChild(soil);
		flower.appendChild(origin).appendChild(country);
		origin.appendChild(century);
		flower.appendChild(visualParameters).appendChild(stemСolor);
		visualParameters.appendChild(leafColor);
		visualParameters.appendChild(averagePlantSize);
		flower.appendChild(growingTips).appendChild(temperature);
		growingTips.appendChild(lighting);
		growingTips.appendChild(watering);
		flower.appendChild(multiplying);
		multiplying.appendChild(methodOne);
		multiplying.appendChild(methodTwo);
		flower.appendChild(plantingDate);

		flower.setAttribute(ID.getName(), F3.getId());
		averagePlantSize.setAttribute(MEASURE.getName(), CENTIMETERS.getName());
		temperature.setAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		watering.setAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());

		name.appendChild(document.createTextNode(AQUILEGIA_COLOMBIAN.getName()));
		soil.appendChild(document.createTextNode(LOOSE_MOIST.getName()));
		country.appendChild(document.createTextNode(COLOMBIA.getName()));
		century.appendChild(document.createTextNode("15"));
		stemСolor.appendChild(document.createTextNode("green"));
		leafColor.appendChild(document.createTextNode("green"));
		averagePlantSize.appendChild(document.createTextNode("100"));
		temperature.appendChild(document.createTextNode("+18"));
		lighting.appendChild(document.createTextNode("true"));
		watering.appendChild(document.createTextNode("6"));
		methodOne.appendChild(document.createTextNode(SEEDS.getName()));
		methodTwo.appendChild(document.createTextNode(DIVISION_THE_BUSH.getName()));
		plantingDate.appendChild(document.createTextNode("2008-02-01T08:11:05"));
	}

	private void createAmorphophallusTitanic(Document document, Element flowers) {
		Element flower = document.createElement(FLOWER.getName());
		Element name = document.createElement(NAME.getName());
		Element soils = document.createElement(SOILS.getName());
		Element soil = document.createElement(SOIL.getName());
		Element origin = document.createElement(ORIGIN.getName());
		Element country = document.createElement(REGION.getName());
		Element century = document.createElement(CENTURY.getName());
		Element visualParameters = document.createElement(VISUAL_PARAAMETERS.getName());
		Element stemСolor = document.createElement(STEM_COLOR.getName());
		Element leafColor = document.createElement(LEAF_COLOR.getName());
		Element averagePlantSize = document.createElement(AVERAGE_PLANT_SIZE.getName());
		Element growingTips = document.createElement(GROWING_TIPS.getName());
		Element temperature = document.createElement(TEMPREATURE.getName());
		Element lighting = document.createElement(LIGHTING.getName());
		Element watering = document.createElement(WETERING.getName());
		Element multiplying = document.createElement(MULTIPLYING.getName());
		Element methodOne = document.createElement(METHOD.getName());
		Element plantingDate = document.createElement(PLANTING_DATE.getName());

		flowers.appendChild(flower).appendChild(name);
		flower.appendChild(soils).appendChild(soil);
		flower.appendChild(origin).appendChild(country);
		origin.appendChild(century);
		flower.appendChild(visualParameters).appendChild(stemСolor);
		visualParameters.appendChild(leafColor);
		visualParameters.appendChild(averagePlantSize);
		flower.appendChild(growingTips).appendChild(temperature);
		growingTips.appendChild(lighting);
		growingTips.appendChild(watering);
		flower.appendChild(multiplying);
		multiplying.appendChild(methodOne);
		flower.appendChild(plantingDate);

		flower.setAttribute(ID.getName(), F4.getId());
		averagePlantSize.setAttribute(MEASURE.getName(), CENTIMETERS.getName());
		temperature.setAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		watering.setAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());

		name.appendChild(document.createTextNode(AMORPHOPHALLUS_TITANIC.getName()));
		soil.appendChild(document.createTextNode(GARDEN_SOIL_AND_SAND.getName()));
		country.appendChild(document.createTextNode(SUMATRA_ISLAND.getName()));
		century.appendChild(document.createTextNode("18"));
		stemСolor.appendChild(document.createTextNode("green"));
		leafColor.appendChild(document.createTextNode("green"));
		averagePlantSize.appendChild(document.createTextNode("300"));
		temperature.appendChild(document.createTextNode("+25"));
		lighting.appendChild(document.createTextNode("true"));
		watering.appendChild(document.createTextNode("20"));
		methodOne.appendChild(document.createTextNode(DIVISION_TUBERS.getName()));
		plantingDate.appendChild(document.createTextNode("2021-11-04T09:11:05"));
	}

	private void createAfricanDaisies(Document document, Element flowers) {
		Element flower = document.createElement(FLOWER.getName());
		Element name = document.createElement(NAME.getName());
		Element soils = document.createElement(SOILS.getName());
		Element soil = document.createElement(SOIL.getName());
		Element origin = document.createElement(ORIGIN.getName());
		Element country = document.createElement(REGION.getName());
		Element century = document.createElement(CENTURY.getName());
		Element visualParameters = document.createElement(VISUAL_PARAAMETERS.getName());
		Element stemСolor = document.createElement(STEM_COLOR.getName());
		Element leafColor = document.createElement(LEAF_COLOR.getName());
		Element averagePlantSize = document.createElement(AVERAGE_PLANT_SIZE.getName());
		Element growingTips = document.createElement(GROWING_TIPS.getName());
		Element temperature = document.createElement(TEMPREATURE.getName());
		Element lighting = document.createElement(LIGHTING.getName());
		Element watering = document.createElement(WETERING.getName());
		Element multiplying = document.createElement(MULTIPLYING.getName());
		Element methodOne = document.createElement(METHOD.getName());
		Element plantingDate = document.createElement(PLANTING_DATE.getName());

		flowers.appendChild(flower).appendChild(name);
		flower.appendChild(soils).appendChild(soil);
		flower.appendChild(origin).appendChild(country);
		origin.appendChild(century);
		flower.appendChild(visualParameters).appendChild(stemСolor);
		visualParameters.appendChild(leafColor);
		visualParameters.appendChild(averagePlantSize);
		flower.appendChild(growingTips).appendChild(temperature);
		growingTips.appendChild(lighting);
		growingTips.appendChild(watering);
		flower.appendChild(multiplying);
		multiplying.appendChild(methodOne);
		flower.appendChild(plantingDate);

		flower.setAttribute(ID.getName(), F5.getId());
		averagePlantSize.setAttribute(MEASURE.getName(), CENTIMETERS.getName());
		temperature.setAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		watering.setAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());

		name.appendChild(document.createTextNode(AFRICAN_DAISIES.getName()));
		soil.appendChild(document.createTextNode(FERTILE_LOOSE.getName()));
		country.appendChild(document.createTextNode(SOUTH_AFRICA.getName()));
		century.appendChild(document.createTextNode("13"));
		stemСolor.appendChild(document.createTextNode("green"));
		leafColor.appendChild(document.createTextNode("green"));
		averagePlantSize.appendChild(document.createTextNode("23"));
		temperature.appendChild(document.createTextNode("+15"));
		lighting.appendChild(document.createTextNode("true"));
		watering.appendChild(document.createTextNode("15"));
		methodOne.appendChild(document.createTextNode(SEEDS.getName()));
		plantingDate.appendChild(document.createTextNode("2003-04-05T08:09:10"));
	}
}