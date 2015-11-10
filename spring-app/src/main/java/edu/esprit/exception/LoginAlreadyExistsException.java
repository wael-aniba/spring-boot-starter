package edu.esprit.exception;

public class LoginAlreadyExistsException extends RuntimeException{

	/** serialVersionUID */
	private static final long serialVersionUID = 2494931584876788651L;

	public LoginAlreadyExistsException(final String message) {
		
		super(message);
	}
}
