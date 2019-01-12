package com.simplesearch.exceptions;

import java.util.List;

public class InvalidTypeException extends RuntimeException {
    
    public InvalidTypeException() {
	super();
    }

    public InvalidTypeException(String message) {
	super(message);
    }

    public InvalidTypeException(String type, List<String> acceptableTypes) {
	super("Unable to recognize type: '" + type + "'. Acceptable types: " + acceptableTypes);
    }
}
