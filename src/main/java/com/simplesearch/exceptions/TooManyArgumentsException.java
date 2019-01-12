package com.simplesearch.exceptions;

public class TooManyArgumentsException extends RuntimeException{
	public TooManyArgumentsException() {
		super("Unable to search with more than 1 keywords");
	}

}
