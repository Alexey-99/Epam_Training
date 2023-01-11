package by.koroza.xml_parsing.parsing.sax.creater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.xml_parsing.exception.CustomParseException;
import by.koroza.xml_parsing.exception.CustomXMLFileException;
import by.koroza.xml_parsing.validation.ValidationFilePath;

public class CreaterXMLFileSAX {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ERROR_FILE_PATH_INCORRECT = "You entered file path incorrectly: ";
	private static final String REG_EX_FOLDERS_FROM_PATH = "(\\w+\\/)+";
	private static final String ERROR_FILE_EXCEPTION = "File exception: ";
	private static final String ERROR_PARSE_EXCEPTION = "Parse exception: ";

	public XMLStreamWriter createrXMLFile(String filePath) throws CustomXMLFileException, CustomParseException {
		XMLStreamWriter writer = null;
		if (ValidationFilePath.validFilePathXML(filePath)) {
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			createDerictories(filePath);
			try {
				writer = factory.createXMLStreamWriter(new FileWriter(filePath));
			} catch (XMLStreamException e) {
				LOGGER.log(Level.ERROR, ERROR_PARSE_EXCEPTION + e.getMessage());
				throw new CustomParseException(ERROR_PARSE_EXCEPTION + e.getMessage());
			} catch (IOException e) {
				LOGGER.log(Level.ERROR, ERROR_FILE_EXCEPTION + e.getMessage());
				throw new CustomXMLFileException(ERROR_FILE_EXCEPTION + e.getMessage());
			}
		} else {
			LOGGER.log(Level.ERROR, ERROR_FILE_PATH_INCORRECT + filePath);
			throw new CustomXMLFileException(ERROR_FILE_PATH_INCORRECT + filePath);
		}
		return writer;
	}

	private void createDerictories(String path) throws CustomXMLFileException {
		new File(getFoldersFromPath(path)).mkdirs();
	}

	private String getFoldersFromPath(String path) {
		Pattern p = Pattern.compile(REG_EX_FOLDERS_FROM_PATH);
		Matcher m = p.matcher(path);
		String folders = "";
		if (m.lookingAt()) {
			folders = m.group();
		}
		folders = new String(folders.toCharArray(), 0, folders.toCharArray().length - 1);
		return folders;
	}
}