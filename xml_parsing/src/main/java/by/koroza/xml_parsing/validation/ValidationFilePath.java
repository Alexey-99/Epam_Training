package by.koroza.xml_parsing.validation;

public class ValidationFilePath {
	private static final String REG_EX_VALID_FILE_PATH_XML = "(\\w+\\/)*\\w*\\.xml";
	private static final String REG_EX_VALID_FILE_PATH_XSD = "(\\w+\\/)*\\w*\\.xsd";

	public static boolean validFilePathXML(String path) {
		return path != null && !path.isBlank() && path.matches(REG_EX_VALID_FILE_PATH_XML);
	}

	public static boolean validFilePathXSD(String path) {
		return path != null && !path.isBlank() && path.matches(REG_EX_VALID_FILE_PATH_XSD);
	}
}