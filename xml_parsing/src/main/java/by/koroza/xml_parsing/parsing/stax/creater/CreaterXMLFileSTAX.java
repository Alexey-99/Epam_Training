package by.koroza.xml_parsing.parsing.stax.creater;

import javax.xml.stream.XMLStreamWriter;

import by.koroza.xml_parsing.exception.CustomParseException;
import by.koroza.xml_parsing.exception.CustomXMLFileException;
import by.koroza.xml_parsing.parsing.sax.creater.CreaterXMLFileSAX;

public class CreaterXMLFileSTAX {

	public XMLStreamWriter createXMLFile(String filePath) throws CustomXMLFileException, CustomParseException {
		return new CreaterXMLFileSAX().createrXMLFile(filePath);
	}
}