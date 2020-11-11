package ar.com.educacionit.exceptions;

public class DuplicateException extends Exception {

	private static final long serialVersionUID = -6818721669787938490L;

	public DuplicateException(String message) {
		super(message);
	}
	public DuplicateException(String message, Exception e) {
		super(message,e);
	}
}
