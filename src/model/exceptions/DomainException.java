package model.exceptions;

public class DomainException extends RuntimeException {
	//Cria um ID serializeble  
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}	
}