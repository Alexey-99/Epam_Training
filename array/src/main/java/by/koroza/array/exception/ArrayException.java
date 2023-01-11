package by.koroza.array.exception;

@SuppressWarnings("serial")
public class ArrayException extends Exception {

	public ArrayException(String message) {
		super(message);
	}

	public ArrayException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArrayException(Throwable cause) {
		super(cause);
	}

	public ArrayException() {
		super();
	}
}