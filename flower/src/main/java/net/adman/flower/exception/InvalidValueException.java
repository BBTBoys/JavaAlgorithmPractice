package net.adman.flower.exception;

public class InvalidValueException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidValueException(int value) {
		System.out.println("invalid value : " + value);
	}

}
