package ar.com.educacionit.exceptions;

public class GenericExeption extends Exception {
	
	private static final long serialVersionUID = 6168602393473015268L;

	public GenericExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericExeption(String message) {
		super(message);
	}
	
}
