package br.com.teste.exception;

public class  AssociadoException extends Exception{
	
	private static final long serialVersionUID = 1L;


	public AssociadoException() {
		super();
	}
	
	public AssociadoException(String message) {
		super(message);
	}

	public AssociadoException(String message, Exception cause) {
		super(message, cause);
	}

	
	public AssociadoException(Exception e) {
		super(e);
	}

}
