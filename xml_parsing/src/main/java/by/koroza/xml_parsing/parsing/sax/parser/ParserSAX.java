package by.koroza.xml_parsing.parsing.sax.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import by.koroza.xml_parsing.entity.Greenhouse;
import by.koroza.xml_parsing.exception.CustomXMLFileException;
import by.koroza.xml_parsing.validation.ValidationFilePath;

public class ParserSAX {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ERROR_FILE_PATH_INCORRECT = "You entered file path incorrectly: ";
	private static final String ERROR_FILE_EXCEPTION = "File exception: ";
	private static final String ERROR_PARSE_EXCEPTION = "Parse exception: ";

	public Greenhouse parseXMLFIle(String path) throws CustomXMLFileException {
		if (ValidationFilePath.validFilePathXML(path)) {
			try {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser = factory.newSAXParser();
				Handler handler = new Handler();
				parser.parse(new File(path), handler);
				return handler.getFlowers();
			} catch (ParserConfigurationException | SAXException e) {
				LOGGER.log(Level.ERROR, ERROR_PARSE_EXCEPTION + e.getMessage());
				throw new CustomXMLFileException(ERROR_PARSE_EXCEPTION + e.getMessage());
			} catch (IOException e) {
				LOGGER.log(Level.ERROR, ERROR_FILE_EXCEPTION + e.getMessage());
				throw new CustomXMLFileException(ERROR_FILE_EXCEPTION + e.getMessage());
			}
		} else {
			LOGGER.log(Level.ERROR, ERROR_FILE_PATH_INCORRECT + path);
			throw new CustomXMLFileException(ERROR_FILE_PATH_INCORRECT + path);
		}
	}
}