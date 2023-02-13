package by.koroza.handling.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean isStartParagraph(String line) {
		Pattern p = Pattern.compile("\\s{3}");
		Matcher m = p.matcher(line);
		return m.lookingAt();
	}

}
