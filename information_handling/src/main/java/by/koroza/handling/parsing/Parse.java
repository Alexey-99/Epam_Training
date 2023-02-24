package by.koroza.handling.parsing;

import by.koroza.handling.entity.abstraction.AbstractText;
import by.koroza.handling.exception.CustomException;

public interface Parse {

	public AbstractText parse(String string) throws CustomException;
}