package by.koroza.xml_parsing.parsing.dom.creater;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import by.koroza.xml_parsing.exception.CustomParseException;

public class CreaterXMLDocumentDOM {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ERROR_PARSER_CONFIGURATION_EXCEPTION = "Parser configuration exception: ";

	public Document createrXMLDocument() throws CustomParseException {
		Document document = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			LOGGER.log(Level.ERROR, ERROR_PARSER_CONFIGURATION_EXCEPTION + e.getMessage());
			throw new CustomParseException(ERROR_PARSER_CONFIGURATION_EXCEPTION + e.getMessage());
		}
		return document;
	}
}