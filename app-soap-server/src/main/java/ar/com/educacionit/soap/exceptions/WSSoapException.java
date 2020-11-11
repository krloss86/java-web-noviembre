package ar.com.educacionit.soap.exceptions;

public class WSSoapException extends Exception {

	private static final long serialVersionUID = -5719271055285077969L;

	public WSSoapException(String message, Throwable cause) {
		super(message, cause);
	}

	public WSSoapException(String message) {
		super(message);
	}
	
}
