package by.koroza.xml_parsing.parsing.stax.writer;

import javax.xml.stream.XMLStreamWriter;

import by.koroza.xml_parsing.exception.CustomParseException;
import by.koroza.xml_parsing.parsing.sax.writer.WriterTagsToXMLFileSAX;

public class WriterTagsToFIleSTAX {

	public void writeTags(XMLStreamWriter writer) throws CustomParseException {
		new WriterTagsToXMLFileSAX().writeTagsToFile(writer);
	}
}