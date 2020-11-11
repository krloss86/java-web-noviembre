package ar.com.educacionit.soap.exceptions;

public class DuplicatesSoapException extends Exception {

	private static final long serialVersionUID = 6943569742622728404L;

	public DuplicatesSoapException(String message, Throwable cause) {
		super(message, cause);
	}
}
