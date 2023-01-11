package by.koroza.xml_parsing.parsing.dom.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.koroza.xml_parsing.entity.AveragePlantSize;
import by.koroza.xml_parsing.entity.Flower;
import by.koroza.xml_parsing.entity.GrowingTips;
import by.koroza.xml_parsing.entity.Temperature;
import by.koroza.xml_parsing.entity.Watering;
import by.koroza.xml_parsing.exception.CustomFlowerException;

import static by.koroza.xml_parsing.enums.Tag.AVERAGE_PLANT_SIZE;
import static by.koroza.xml_parsing.enums.Tag.CENTURY;
import static by.koroza.xml_parsing.enums.Tag.GROWING_TIPS;
import static by.koroza.xml_parsing.enums.Tag.LEAF_COLOR;
import static by.koroza.xml_parsing.enums.Tag.LIGHTING;
import static by.koroza.xml_parsing.enums.Tag.MULTIPLYING;
import static by.koroza.xml_parsing.enums.Tag.NAME;
import static by.koroza.xml_parsing.enums.Tag.ORIGIN;
import static by.koroza.xml_parsing.enums.Tag.PLANTING_DATE;
import static by.koroza.xml_parsing.enums.Tag.REGION;
import static by.koroza.xml_parsing.enums.Tag.SOILS;
import static by.koroza.xml_parsing.enums.Tag.STEM_COLOR;
import static by.koroza.xml_parsing.enums.Tag.TEMPREATURE;
import static by.koroza.xml_parsing.enums.Tag.VISUAL_PARAAMETERS;
import static by.koroza.xml_parsing.enums.Tag.WETERING;
import static by.koroza.xml_parsing.enums.Attribute.ID;
import static by.koroza.xml_parsing.enums.Attribute.MEASURE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParserDOM {

	public Set<Flower> parseXML(Document document) throws CustomFlowerException {
		Set<Flower> flowers = null;
		if (document != null) {
			flowers = new HashSet<>();
			Element root = document.getDocumentElement();
			if (root != null) {
				NodeList flowersList = root.getChildNodes();
				for (int i = 0; i < flowersList.getLength(); i++) {
					Flower flower = new Flower();
					flower.setId(flowersList.item(i).getAttributes().getNamedItem(ID.getName()).getTextContent());
					NodeList nodesFlowerList = flowersList.item(i).getChildNodes();
					for (int j = 0; j < nodesFlowerList.getLength(); j++) {
						Node tag = nodesFlowerList.item(j);
						String nameTag = tag.getNodeName();
						String contentTag = tag.getTextContent();
						if (nameTag.equals(NAME.getName())) {
							flower.setName(contentTag);
						} else if (nameTag.equals(SOILS.getName())) {
							flower.setSoils(parseSoils(tag.getChildNodes()));
						} else if (nameTag.equals(ORIGIN.getName())) {
							parseOrigin(tag.getChildNodes(), flower);
						} else if (nameTag.equals(VISUAL_PARAAMETERS.getName())) {
							parseVisualParameters(tag.getChildNodes(), flower);
						} else if (nameTag.equals(GROWING_TIPS.getName())) {
							flower.setGrowingTips(parseGrowingTips(tag.getChildNodes()));
						} else if (nameTag.equals(MULTIPLYING.getName())) {
							flower.setMultiplying(parseMultiplying(tag.getChildNodes()));
						} else if (nameTag.equals(PLANTING_DATE.getName())) {
							flower.setPlantingDate(contentTag);
						}
					}
					flowers.add(flower);
				}
			}
		}
		return flowers;
	}

	private List<String> parseSoils(NodeList soils) {
		List<String> soilsList = new ArrayList<>();
		for (int i = 0; i < soils.getLength(); i++) {
			soilsList.add(soils.item(i).getTextContent());
		}
		return soilsList;
	}

	private void parseOrigin(NodeList tagsOriginList, Flower flower) {
		for (int i = 0; i < tagsOriginList.getLength(); i++) {
			Node tagOrigin = tagsOriginList.item(i);
			String tagOriginName = tagOrigin.getNodeName();
			String tagOriginContent = tagOrigin.getTextContent();
			if (tagOriginName.equals(REGION.getName())) {
				flower.setRegionOrigin(tagOriginContent);
			} else if (tagOriginName.equals(CENTURY.getName())) {
				flower.setCenturyOrigin(Integer.parseInt(tagOriginContent));
			}
		}
	}

	private void parseVisualParameters(NodeList visualParametersList, Flower flower) {
		for (int i = 0; i < visualParametersList.getLength(); i++) {
			Node tagVisualParameter = visualParametersList.item(i);
			String tagVisualParameterName = tagVisualParameter.getNodeName();
			String tagVisualParameterContent = tagVisualParameter.getTextContent();
			if (tagVisualParameterName.equals(STEM_COLOR.getName())) {
				flower.setStemСolor(tagVisualParameterContent);
			} else if (tagVisualParameterName.equals(LEAF_COLOR.getName())) {
				flower.setLeafColor(tagVisualParameterContent);
			} else if (tagVisualParameterName.equals(AVERAGE_PLANT_SIZE.getName())) {
				flower.setAveragePlantSize(parseAveragePlantSize(tagVisualParameter));
			}
		}
	}

	private AveragePlantSize parseAveragePlantSize(Node tagVisualParameter) {
		String measure = tagVisualParameter.getAttributes().getNamedItem(MEASURE.getName()).getTextContent();
		int value = Integer.parseInt(tagVisualParameter.getTextContent());
		return new AveragePlantSize(measure, value);
	}

	private GrowingTips parseGrowingTips(NodeList growingTipsList) {
		Temperature temperature = null;
		boolean lighting = true;
		Watering watering = null;
		for (int i = 0; i < growingTipsList.getLength(); i++) {
			Node tagGrowingTip = growingTipsList.item(i);
			String tagGrowingTipName = tagGrowingTip.getNodeName();
			String tagGrowingTipContent = tagGrowingTip.getTextContent();
			if (tagGrowingTipName.equals(TEMPREATURE.getName())) {
				temperature = parseTemperature(tagGrowingTip);
			} else if (tagGrowingTipName.equals(LIGHTING.getName())) {
				lighting = Boolean.parseBoolean(tagGrowingTipContent);
			} else if (tagGrowingTipName.equals(WETERING.getName())) {
				watering = parseWatering(tagGrowingTip);
			}
		}
		return new GrowingTips(temperature, lighting, watering);
	}

	private Temperature parseTemperature(Node tagGrowingTip) {
		String measure = tagGrowingTip.getAttributes().getNamedItem(MEASURE.getName()).getTextContent();
		int value = Integer.parseInt(tagGrowingTip.getTextContent());
		return new Temperature(measure, value);
	}

	private Watering parseWatering(Node tagGrowingTip) {
		String measure = tagGrowingTip.getAttributes().getNamedItem(MEASURE.getName()).getTextContent();
		int value = Integer.parseInt(tagGrowingTip.getTextContent());
		return new Watering(measure, value);
	}

	private List<String> parseMultiplying(NodeList multiplyingMethodsList) {
		List<String> multiplying = new ArrayList<>();
		for (int i = 0; i < multiplyingMethodsList.getLength(); i++) {
			multiplying.add(multiplyingMethodsList.item(i).getTextContent());
		}
		return multiplying;
	}
}