package br.com.teste.exception;

public class PautaException extends Exception{
	
	private static final long serialVersionUID = 1L;


	public PautaException() {
		super();
	}
	
	public PautaException(String message) {
		super(message);
	}

	public PautaException(String message, Exception cause) {
		super(message, cause);
	}

	
	public PautaException(Exception e) {
		super(e);
	}

}
