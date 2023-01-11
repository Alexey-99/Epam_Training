package by.koroza.xml_parsing.parsing.sax.writer;

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

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.xml_parsing.enums.Measure;
import by.koroza.xml_parsing.exception.CustomParseException;

public class WriterTagsToXMLFileSAX {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ERROR_XML_EXCEPTION = "XML exception: ";

	public void writeTagsToFile(XMLStreamWriter writer) throws CustomParseException {
		try {
			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeStartElement(FLOWERS.getName());
			writer.writeAttribute("xmlns", "http://www.flowers.com/Flowers");
			writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			writer.writeAttribute("xsi:schemaLocation", "http://www.flowers.com/Flowers flowers.xsd");
			createRoze(writer);
			createAlstroemeria(writer);
			createAquilegiaColombian(writer);
			createAmorphophallusTitanic(writer);
			createAfricanDaisies(writer);
			writer.writeEndElement();
			writer.writeEndDocument();
			writer.flush();
		} catch (XMLStreamException e) {
			LOGGER.log(Level.ERROR, ERROR_XML_EXCEPTION + e.getMessage());
			throw new CustomParseException(ERROR_XML_EXCEPTION + e.getMessage());
		}
	}

	private void createRoze(XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartElement(FLOWER.getName());
		writer.writeAttribute(ID.getName(), F1.getId());

		writer.writeStartElement(NAME.getName());
		writer.writeCharacters(ROSE.getName());
		writer.writeEndElement();

		writer.writeStartElement(SOILS.getName());
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(LIGHT.getName());
		writer.writeEndElement();
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(LOAMY.getName());
		writer.writeEndElement();
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(MEDIUM_LOAMY.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(ORIGIN.getName());
		writer.writeStartElement(REGION.getName());
		writer.writeCharacters(PERSIA.getName());
		writer.writeEndElement();
		writer.writeStartElement(CENTURY.getName());
		writer.writeCharacters("19");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(VISUAL_PARAAMETERS.getName());
		writer.writeStartElement(STEM_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(LEAF_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(AVERAGE_PLANT_SIZE.getName());
		writer.writeAttribute(MEASURE.getName(), CENTIMETERS.getName());
		writer.writeCharacters("70");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(GROWING_TIPS.getName());
		writer.writeStartElement(TEMPREATURE.getName());
		writer.writeAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		writer.writeCharacters("-5");
		writer.writeEndElement();
		writer.writeStartElement(LIGHTING.getName());
		writer.writeCharacters("true");
		writer.writeEndElement();
		writer.writeStartElement(WETERING.getName());
		writer.writeAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());
		writer.writeCharacters("10");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(MULTIPLYING.getName());
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(SEEDS.getName());
		writer.writeEndElement();
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(LAYERING.getName());
		writer.writeEndElement();
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(GRAFTING_FROM_BUDS_BUDDING.getName());
		writer.writeEndElement();
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(CUTTINGS.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(PLANTING_DATE.getName());
		writer.writeCharacters("2015-03-06T10:23:05");
		writer.writeEndElement();

		writer.writeEndElement();
	}

	private void createAlstroemeria(XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartElement(FLOWER.getName());
		writer.writeAttribute(ID.getName(), F2.getId());

		writer.writeStartElement(NAME.getName());
		writer.writeCharacters(ALSTROEMERIA.getName());
		writer.writeEndElement();

		writer.writeStartElement(SOILS.getName());
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(CLAY.getName());
		writer.writeEndElement();
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(SANDY.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(ORIGIN.getName());
		writer.writeStartElement(REGION.getName());
		writer.writeCharacters(PERU.getName());
		writer.writeEndElement();
		writer.writeStartElement(CENTURY.getName());
		writer.writeCharacters("17");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(VISUAL_PARAAMETERS.getName());
		writer.writeStartElement(STEM_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(LEAF_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(AVERAGE_PLANT_SIZE.getName());
		writer.writeAttribute(MEASURE.getName(), Measure.CENTIMETERS.getName());
		writer.writeCharacters("150");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(GROWING_TIPS.getName());
		writer.writeStartElement(TEMPREATURE.getName());
		writer.writeAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		writer.writeCharacters("+19");
		writer.writeEndElement();
		writer.writeStartElement(LIGHTING.getName());
		writer.writeCharacters("true");
		writer.writeEndElement();
		writer.writeStartElement(WETERING.getName());
		writer.writeAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());
		writer.writeCharacters("5");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(MULTIPLYING.getName());
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(SEEDS.getName());
		writer.writeEndElement();
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(GRAFTING_FROM_BUDS_BUDDING.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(PLANTING_DATE.getName());
		writer.writeCharacters("2018-08-20T12:08:10");
		writer.writeEndElement();

		writer.writeEndElement();
	}

	private void createAquilegiaColombian(XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartElement(FLOWER.getName());
		writer.writeAttribute(ID.getName(), F3.getId());

		writer.writeStartElement(NAME.getName());
		writer.writeCharacters(AQUILEGIA_COLOMBIAN.getName());
		writer.writeEndElement();

		writer.writeStartElement(SOILS.getName());
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(LOOSE_MOIST.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(ORIGIN.getName());
		writer.writeStartElement(REGION.getName());
		writer.writeCharacters(COLOMBIA.getName());
		writer.writeEndElement();
		writer.writeStartElement(CENTURY.getName());
		writer.writeCharacters("15");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(VISUAL_PARAAMETERS.getName());
		writer.writeStartElement(STEM_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(LEAF_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(AVERAGE_PLANT_SIZE.getName());
		writer.writeAttribute(MEASURE.getName(), CENTIMETERS.getName());
		writer.writeCharacters("100");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(GROWING_TIPS.getName());
		writer.writeStartElement(TEMPREATURE.getName());
		writer.writeAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		writer.writeCharacters("+18");
		writer.writeEndElement();
		writer.writeStartElement(LIGHTING.getName());
		writer.writeCharacters("true");
		writer.writeEndElement();
		writer.writeStartElement(WETERING.getName());
		writer.writeAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());
		writer.writeCharacters("6");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(MULTIPLYING.getName());
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(SEEDS.getName());
		writer.writeEndElement();
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(DIVISION_THE_BUSH.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(PLANTING_DATE.getName());
		writer.writeCharacters("2008-02-01T08:11:05");
		writer.writeEndElement();

		writer.writeEndElement();
	}

	private void createAmorphophallusTitanic(XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartElement(FLOWER.getName());
		writer.writeAttribute(ID.getName(), F4.getId());

		writer.writeStartElement(NAME.getName());
		writer.writeCharacters(AMORPHOPHALLUS_TITANIC.getName());
		writer.writeEndElement();

		writer.writeStartElement(SOILS.getName());
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(GARDEN_SOIL_AND_SAND.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(ORIGIN.getName());
		writer.writeStartElement(REGION.getName());
		writer.writeCharacters(SUMATRA_ISLAND.getName());
		writer.writeEndElement();
		writer.writeStartElement(CENTURY.getName());
		writer.writeCharacters("18");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(VISUAL_PARAAMETERS.getName());
		writer.writeStartElement(STEM_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(LEAF_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(AVERAGE_PLANT_SIZE.getName());
		writer.writeAttribute(MEASURE.getName(), CENTIMETERS.getName());
		writer.writeCharacters("300");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(GROWING_TIPS.getName());
		writer.writeStartElement(TEMPREATURE.getName());
		writer.writeAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		writer.writeCharacters("+25");
		writer.writeEndElement();
		writer.writeStartElement(LIGHTING.getName());
		writer.writeCharacters("true");
		writer.writeEndElement();
		writer.writeStartElement(WETERING.getName());
		writer.writeAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());
		writer.writeCharacters("20");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(MULTIPLYING.getName());
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(DIVISION_TUBERS.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(PLANTING_DATE.getName());
		writer.writeCharacters("2021-11-04T09:11:05");
		writer.writeEndElement();

		writer.writeEndElement();
	}

	private void createAfricanDaisies(XMLStreamWriter writer) throws XMLStreamException {
		writer.writeStartElement(FLOWER.getName());
		writer.writeAttribute(ID.getName(), F5.getId());

		writer.writeStartElement(NAME.getName());
		writer.writeCharacters(AFRICAN_DAISIES.getName());
		writer.writeEndElement();

		writer.writeStartElement(SOILS.getName());
		writer.writeStartElement(SOIL.getName());
		writer.writeCharacters(FERTILE_LOOSE.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(ORIGIN.getName());
		writer.writeStartElement(REGION.getName());
		writer.writeCharacters(SOUTH_AFRICA.getName());
		writer.writeEndElement();
		writer.writeStartElement(CENTURY.getName());
		writer.writeCharacters("13");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(VISUAL_PARAAMETERS.getName());
		writer.writeStartElement(STEM_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(LEAF_COLOR.getName());
		writer.writeCharacters("green");
		writer.writeEndElement();
		writer.writeStartElement(AVERAGE_PLANT_SIZE.getName());
		writer.writeAttribute(MEASURE.getName(), CENTIMETERS.getName());
		writer.writeCharacters("23");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(GROWING_TIPS.getName());
		writer.writeStartElement(TEMPREATURE.getName());
		writer.writeAttribute(MEASURE.getName(), DEGREES_CELSIUS.getName());
		writer.writeCharacters("+15");
		writer.writeEndElement();
		writer.writeStartElement(LIGHTING.getName());
		writer.writeCharacters("true");
		writer.writeEndElement();
		writer.writeStartElement(WETERING.getName());
		writer.writeAttribute(MEASURE.getName(), MILILITERS_PER_WEEK.getName());
		writer.writeCharacters("15");
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(MULTIPLYING.getName());
		writer.writeStartElement(METHOD.getName());
		writer.writeCharacters(SEEDS.getName());
		writer.writeEndElement();
		writer.writeEndElement();

		writer.writeStartElement(PLANTING_DATE.getName());
		writer.writeCharacters("2003-04-05T08:09:10");
		writer.writeEndElement();

		writer.writeEndElement();
	}
}