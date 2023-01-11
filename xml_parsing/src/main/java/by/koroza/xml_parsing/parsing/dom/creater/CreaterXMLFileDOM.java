package by.koroza.xml_parsing.parsing.dom.creater;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import by.koroza.xml_parsing.exception.CustomParseException;
import by.koroza.xml_parsing.exception.CustomXMLFileException;
import by.koroza.xml_parsing.validation.ValidationFilePath;

public class CreaterXMLFileDOM {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ERROR_FILE_PATH_INCORRECT = "You entered file path incorrectly: ";
	private static final String REG_EX_FOLDERS_FROM_PATH = "(\\w+\\/)+";
	private static final String ERROR_PARSE_EXCEPTION = "Parse exception: ";
	private static final String ERROR_FILE_NOT_FOUND_EXCEPTION = "File not found exception: ";

	public Document createXMLFIle(Document document, String path) throws CustomXMLFileException, CustomParseException {
		if (ValidationFilePath.validFilePathXML(path)) {
			createDerictories(path);
			createFile(document, path);
			return document;
		} else {
			LOGGER.log(Level.ERROR, ERROR_FILE_PATH_INCORRECT + path);
			throw new CustomXMLFileException(ERROR_FILE_PATH_INCORRECT + path);
		}
	}

	private void createFile(Document document, String path) throws CustomXMLFileException, CustomParseException {
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(path)));
		} catch (TransformerException | TransformerFactoryConfigurationError e) {
			LOGGER.log(Level.ERROR, ERROR_PARSE_EXCEPTION + e.getMessage());
			throw new CustomParseException(ERROR_PARSE_EXCEPTION + e.getMessage());
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.ERROR, ERROR_FILE_NOT_FOUND_EXCEPTION + e.getMessage());
			throw new CustomXMLFileException(ERROR_FILE_NOT_FOUND_EXCEPTION + e.getMessage());
		}
	}

	private void createDerictories(String path) {
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