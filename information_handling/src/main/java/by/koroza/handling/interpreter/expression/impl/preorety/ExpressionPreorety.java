package by.koroza.handling.interpreter.expression.impl.preorety;

import java.util.Map;
import java.util.TreeMap;

public class ExpressionPreorety {
	private final Map<Integer, String> PREORETIES = new TreeMap<>();

	public ExpressionPreorety() {
		addPreoreties();
	}

	public Map<Integer, String> getPREORETIES() {
		return PREORETIES;
	}

	private void addPreoreties() {
		PREORETIES.put(1, "\\(.+\\)");
		PREORETIES.put(2, "\\~");
		PREORETIES.put(4, "(\\>{2})|(\\<{2})");
		PREORETIES.put(7, "\\&");
		PREORETIES.put(8, "\\^");
		PREORETIES.put(9, "(\\|)");
	}
}