package ar.com.educacionit.services.exceptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 5306393000101902932L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}
}
