package com.simplesearch.exceptions;

public class TooFewArgumentsException extends RuntimeException {

	public TooFewArgumentsException() {
		super("Unable to search without keyword");
	}
	

}
