package by.koroza.xml_parsing.parsing.sax.parser;

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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.koroza.xml_parsing.entity.AveragePlantSize;
import by.koroza.xml_parsing.entity.Flower;
import by.koroza.xml_parsing.entity.Greenhouse;
import by.koroza.xml_parsing.entity.GrowingTips;
import by.koroza.xml_parsing.entity.Temperature;
import by.koroza.xml_parsing.entity.Watering;
import by.koroza.xml_parsing.exception.CustomFlowerException;

public class Handler extends DefaultHandler {
	private final Greenhouse flowers = new Greenhouse();
	private String id;
	private String name;
	private List<String> soils;
	private String region;
	private int century;
	private String stemСolor;
	private String leafColor;
	private AveragePlantSize averagePlantSize;
	private String measure;
	private int value;
	private GrowingTips growingTips;
	private Temperature temperature;
	private boolean lighting;
	private Watering watering;
	private List<String> multiplying;
	private String plantingDate;
	private String tagName;
	private static final String ERROR_ENTER_DATE_TIME_INCORRECT = "You entered incorrectly date or time: ";

	@Override
	public void startDocument() throws SAXException {
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

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tagName = qName;
		if (qName.equals(FLOWER.getName())) {
			id = attributes.getValue(ID.getName());
		} else if (qName.equals(AVERAGE_PLANT_SIZE.getName()) || qName.equals(TEMPREATURE.getName())
				|| qName.equals(WETERING.getName())) {
			measure = attributes.getValue(MEASURE.getName());
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (!new String(ch, start, length).trim().equals("")) {
			if (tagName.equals(NAME.getName())) {
				name = new String(ch, start, length);
			} else if (tagName.equals(SOIL.getName())) {
				soils.add(new String(ch, start, length));
			} else if (tagName.equals(REGION.getName())) {
				region = new String(ch, start, length);
			} else if (tagName.equals(CENTURY.getName())) {
				century = Integer.parseInt(new String(ch, start, length));
			} else if (tagName.equals(STEM_COLOR.getName())) {
				stemСolor = new String(ch, start, length);
			} else if (tagName.equals(LEAF_COLOR.getName())) {
				leafColor = new String(ch, start, length);
			} else if (tagName.equals(AVERAGE_PLANT_SIZE.getName()) || tagName.equals(TEMPREATURE.getName())
					|| tagName.equals(WETERING.getName())) {
				value = Integer.parseInt(new String(ch, start, length));
			} else if (tagName.equals(LIGHTING.getName())) {
				lighting = Boolean.parseBoolean(new String(ch, start, length));
			} else if (tagName.equals(METHOD.getName())) {
				multiplying.add(new String(ch, start, length));
			} else if (tagName.equals(PLANTING_DATE.getName())) {
				plantingDate = new String(ch, start, length);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(AVERAGE_PLANT_SIZE.getName())) {
			averagePlantSize = new AveragePlantSize(measure, value);
			measure = null;
			value = 0;
		} else if (qName.equals(TEMPREATURE.getName())) {
			temperature = new Temperature(measure, value);
			measure = null;
			value = 0;
		} else if (qName.equals(WETERING.getName())) {
			watering = new Watering(measure, value);
			measure = null;
			value = 0;
		} else if (qName.equals(GROWING_TIPS.getName())) {
			growingTips = new GrowingTips(temperature, lighting, watering);
		} else if (qName.equals(FLOWER.getName())) {
			try {
				flowers.getFlowers()
						.add(new Flower.FlowerBuilder().setId(id).setName(name).setSoils(soils).setRegionOrigin(region)
								.setCenturyOrigin(century).setStemСolor(stemСolor).setLeafColor(leafColor)
								.setAveragePlantSize(averagePlantSize).setGrowingTips(growingTips)
								.setMultiplying(multiplying).setPlantingDate(plantingDate).build());
			} catch (CustomFlowerException e) {
				LogManager.getLogger().log(Level.ERROR, ERROR_ENTER_DATE_TIME_INCORRECT + plantingDate);
			}
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

	public Greenhouse getFlowers() {
		return flowers;
	}
}