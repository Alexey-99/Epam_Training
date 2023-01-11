package by.koroza.xml_parsing.parsing.stax.parser;

import static by.koroza.xml_parsing.enums.Tag.AVERAGE_PLANT_SIZE;
import static by.koroza.xml_parsing.enums.Tag.CENTURY;
import static by.koroza.xml_parsing.enums.Tag.FLOWER;
import static by.koroza.xml_parsing.enums.Tag.GROWING_TIPS;
import static by.koroza.xml_parsing.enums.Tag.LEAF_COLOR;
import static by.koroza.xml_parsing.enums.Tag.LIGHTING;
import static by.koroza.xml_parsing.enums.Tag.METHOD;
import static by.koroza.xml_parsing.enums.Tag.NAME;
import static by.koroza.xml_parsing.enums.Tag.PLANTING_DATE;
import static by.koroza.xml_parsing.enums.Tag.REGION;
import static by.koroza.xml_parsing.enums.Tag.SOIL;
import static by.koroza.xml_parsing.enums.Tag.STEM_COLOR;
import static by.koroza.xml_parsing.enums.Tag.TEMPREATURE;
import static by.koroza.xml_parsing.enums.Tag.WETERING;
import static by.koroza.xml_parsing.enums.Attribute.ID;
import static by.koroza.xml_parsing.enums.Attribute.MEASURE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.xml_parsing.entity.AveragePlantSize;
import by.koroza.xml_parsing.entity.Flower;
import by.koroza.xml_parsing.entity.Greenhouse;
import by.koroza.xml_parsing.entity.GrowingTips;
import by.koroza.xml_parsing.entity.Temperature;
import by.koroza.xml_parsing.entity.Watering;
import by.koroza.xml_parsing.exception.CustomFlowerException;
import by.koroza.xml_parsing.exception.CustomParseException;
import by.koroza.xml_parsing.exception.CustomXMLFileException;

public class ParserXMLFileSTAX {
	private static final Logger LOGGER = LogManager.getLogger();
	private final Greenhouse flowers = new Greenhouse();
	private String id = null;
	private String name = null;
	private List<String> soils = new ArrayList<>();
	private String region = null;
	private int century = 0;
	private String stemСolor = null;
	private String leafColor = null;
	private AveragePlantSize averagePlantSize = null;
	private String measure = null;
	private int value = 0;
	private GrowingTips growingTips = null;
	private Temperature temperature = null;
	private boolean lighting = true;
	private Watering watering = null;
	private List<String> multiplying = new ArrayList<>();
	private String plantingDate = null;
	private String tagName = null;
	private static final String ERROR_FILE_EXCEPTION = "File exception: ";
	private static final String ERROR_PARSE_EXCEPTION = "Parse exception: ";

	public Greenhouse parseXMLFile(String filePath)
			throws CustomFlowerException, CustomXMLFileException, CustomParseException {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLStreamReader reader;
		try {
			reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(filePath));
			while (reader.hasNext()) {
				reader.next();
				if (reader.isStartElement()) {
					startElement(reader);
				} else if (reader.isCharacters() && reader.getText().trim().length() != 0) {
					characters(reader);
				} else if (reader.isEndElement()) {
					endElement(reader);
				}
			}
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.ERROR, ERROR_FILE_EXCEPTION + e.getMessage());
			throw new CustomXMLFileException(ERROR_FILE_EXCEPTION + e.getMessage());
		} catch (XMLStreamException e) {
			LOGGER.log(Level.ERROR, ERROR_PARSE_EXCEPTION + e.getMessage());
			throw new CustomParseException(ERROR_PARSE_EXCEPTION + e.getMessage());
		}
		return flowers;
	}

	private void startElement(XMLStreamReader reader) {
		tagName = reader.getLocalName();
		if (tagName.equals(FLOWER.getName())) {
			id = reader.getAttributeValue(null, ID.getName());
		} else if (tagName.equals(AVERAGE_PLANT_SIZE.getName()) || tagName.equals(TEMPREATURE.getName())
				|| tagName.equals(WETERING.getName())) {
			measure = reader.getAttributeValue(null, MEASURE.getName());
		}
	}

	private void characters(XMLStreamReader reader) {
		if (tagName.equals(NAME.getName())) {
			name = reader.getText();
		} else if (tagName.equals(SOIL.getName())) {
			soils.add(reader.getText());
		} else if (tagName.equals(REGION.getName())) {
			region = reader.getText();
		} else if (tagName.equals(CENTURY.getName())) {
			century = Integer.parseInt(reader.getText());
		} else if (tagName.equals(STEM_COLOR.getName())) {
			stemСolor = reader.getText();
		} else if (tagName.equals(LEAF_COLOR.getName())) {
			leafColor = reader.getText();
		} else if (tagName.equals(AVERAGE_PLANT_SIZE.getName()) || tagName.equals(TEMPREATURE.getName())
				|| tagName.equals(WETERING.getName())) {
			value = Integer.parseInt(reader.getText());
		} else if (tagName.equals(LIGHTING.getName())) {
			lighting = Boolean.parseBoolean(reader.getText());
		} else if (tagName.equals(METHOD.getName())) {
			multiplying.add(reader.getText());
		} else if (tagName.equals(PLANTING_DATE.getName())) {
			plantingDate = reader.getText();
		}
	}

	private void endElement(XMLStreamReader reader) throws CustomFlowerException {
		tagName = reader.getLocalName();
		if (tagName.equals(AVERAGE_PLANT_SIZE.getName())) {
			averagePlantSize = new AveragePlantSize(measure, value);
			measure = null;
			value = 0;
		} else if (tagName.equals(TEMPREATURE.getName())) {
			temperature = new Temperature(measure, value);
			measure = null;
			value = 0;
		} else if (tagName.equals(WETERING.getName())) {
			watering = new Watering(measure, value);
			measure = null;
			value = 0;
		} else if (tagName.equals(GROWING_TIPS.getName())) {
			growingTips = new GrowingTips(temperature, lighting, watering);
		} else if (tagName.equals(FLOWER.getName())) {
			flowers.getFlowers()
					.add(new Flower.FlowerBuilder().setId(id).setName(name).setSoils(soils).setRegionOrigin(region)
							.setCenturyOrigin(century).setStemСolor(stemСolor).setLeafColor(leafColor)
							.setAveragePlantSize(averagePlantSize).setGrowingTips(growingTips)
							.setMultiplying(multiplying).setPlantingDate(plantingDate).build());
			id = null;
			name = null;
			soils = new ArrayList<>();
			region = null;
			century = 0;
			stemСolor = null;
			leafColor = null;
			averagePlantSize = null;
			measure = null;
			value = 0;
			growingTips = null;
			temperature = null;
			lighting = true;
			watering = null;
			multiplying = new ArrayList<>();
			plantingDate = null;
			tagName = null;
		}
	}
}