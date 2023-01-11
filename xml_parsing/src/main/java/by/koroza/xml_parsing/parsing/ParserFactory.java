package by.koroza.xml_parsing.parsing;

import javax.xml.stream.XMLStreamWriter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import by.koroza.xml_parsing.entity.Greenhouse;
import by.koroza.xml_parsing.exception.CustomFlowerException;
import by.koroza.xml_parsing.exception.CustomParseException;
import by.koroza.xml_parsing.exception.CustomXMLFileException;
import by.koroza.xml_parsing.parsing.dom.creater.CreaterXMLDocumentDOM;
import by.koroza.xml_parsing.parsing.dom.creater.CreaterXMLFileDOM;
import by.koroza.xml_parsing.parsing.dom.parser.ParserDOM;
import by.koroza.xml_parsing.parsing.dom.writer.WriterTagsToXMLFileDOM;
import by.koroza.xml_parsing.parsing.sax.creater.CreaterXMLFileSAX;
import by.koroza.xml_parsing.parsing.sax.parser.ParserSAX;
import by.koroza.xml_parsing.parsing.sax.writer.WriterTagsToXMLFileSAX;
import by.koroza.xml_parsing.parsing.stax.creater.CreaterXMLFileSTAX;
import by.koroza.xml_parsing.parsing.stax.parser.ParserXMLFileSTAX;
import by.koroza.xml_parsing.parsing.stax.writer.WriterTagsToFIleSTAX;
import by.koroza.xml_parsing.validation.ValidationFilePath;
import by.koroza.xml_parsing.validation.ValidationXMLFile;

public class ParserFactory {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String WARN_ENTERED_INCORRECT_NUMBER = "You entered number incorrectly.";
	private static final String ERROR_FILE_PATH_INCORRECT = "You entered file path incorrectly: ";

	public Greenhouse parseXML(int numberOperation, String XMLfilePath, String XSDFilePath)
			throws CustomParseException, CustomXMLFileException, CustomFlowerException {
		Greenhouse greenhouse = null;
		switch (numberOperation) {
		case 0:
			greenhouse = dom(XMLfilePath, XSDFilePath);
			break;
		case 1:
			greenhouse = sax(XMLfilePath, XSDFilePath);
			break;
		case 2:
			greenhouse = stax(XMLfilePath, XSDFilePath);
			break;
		default:
			LOGGER.log(Level.WARN, WARN_ENTERED_INCORRECT_NUMBER);
			break;
		}
		return greenhouse;
	}

	private static Greenhouse dom(String XMLfilePath, String XSDFilePath)
			throws CustomParseException, CustomXMLFileException, CustomFlowerException {
		Greenhouse greenhouse = null;
		Document document = createDocument(XMLfilePath);
		if (ValidationFilePath.validFilePathXSD(XSDFilePath)) {
			ValidationXMLFile.validXMLFile(XMLfilePath, XSDFilePath);
			greenhouse = new Greenhouse(new ParserDOM().parseXML(document));
		} else {
			LOGGER.log(Level.ERROR, ERROR_FILE_PATH_INCORRECT + XSDFilePath);
			throw new CustomXMLFileException(ERROR_FILE_PATH_INCORRECT + XSDFilePath);
		}
		return greenhouse;
	}

	private static Document createDocument(String filePath) throws CustomParseException, CustomXMLFileException {
		Document document = new CreaterXMLDocumentDOM().createrXMLDocument();
		new WriterTagsToXMLFileDOM().writeTagsToFile(document);
		new CreaterXMLFileDOM().createXMLFIle(document, filePath);
		return document;
	}

	private static Greenhouse sax(String XMLfilePath, String XSDFilePath)
			throws CustomXMLFileException, CustomParseException {
		XMLStreamWriter writer = new CreaterXMLFileSAX().createrXMLFile(XMLfilePath);
		new WriterTagsToXMLFileSAX().writeTagsToFile(writer);
		ValidationXMLFile.validXMLFile(XMLfilePath, XSDFilePath);
		Greenhouse greenhouse = new ParserSAX().parseXMLFIle(XMLfilePath);
		return greenhouse;
	}

	private static Greenhouse stax(String XMLfilePath, String XSDFilePath)
			throws CustomXMLFileException, CustomFlowerException, CustomParseException {
		XMLStreamWriter writer = new CreaterXMLFileSTAX().createXMLFile(XMLfilePath);
		new WriterTagsToFIleSTAX().writeTags(writer);
		ValidationXMLFile.validXMLFile(XMLfilePath, XSDFilePath);
		Greenhouse greenhouse = new ParserXMLFileSTAX().parseXMLFile(XMLfilePath);
		return greenhouse;
	}
}