package by.koroza.xml_parsing.validation;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidationXMLFile {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ERROR_PATH_INCORRECT = "Path is not correct or valid";

	public static boolean validXMLFile(String pathFileXML, String pathSchemaXSD) {
		boolean isCorrect = false;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		if (ValidationFilePath.validFilePathXML(pathFileXML) && ValidationFilePath.validFilePathXSD(pathSchemaXSD)) {
			File schemaLocation = new File(pathSchemaXSD);
			try {
				Schema schema = factory.newSchema(schemaLocation);
				Validator validator = schema.newValidator();
				Source source = new StreamSource(pathFileXML);
				validator.setErrorHandler(new ErrorHandler() {

					@Override
					public void warning(SAXParseException e) throws SAXException {
						LOGGER.warn(getLineColumnNumber(e) + "-" + e.getMessage());
					}

					@Override
					public void fatalError(SAXParseException e) throws SAXException {
						LOGGER.warn(getLineColumnNumber(e) + "-" + e.getMessage());
					}

					@Override
					public void error(SAXParseException e) throws SAXException {
						LOGGER.warn(getLineColumnNumber(e) + "-" + e.getMessage());
					}

					private String getLineColumnNumber(SAXParseException e) {
						return e.getLineNumber() + " : " + e.getColumnNumber();
					}
				});
				validator.validate(source);
				isCorrect = true;
			} catch (SAXException | IOException e) {
				LOGGER.log(Level.ERROR, ERROR_PATH_INCORRECT);
			}
		} else {
			LOGGER.log(Level.ERROR, ERROR_PATH_INCORRECT);
		}
		return isCorrect;
	}
}