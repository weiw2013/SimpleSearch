package com.simplesearch.exceptions;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException() {
	super();
    }
    
    public InvalidFieldException(String message) {
	super(message);
    }

    public InvalidFieldException(String fieldName, Field[] fields) {
	super("Unable to recognize field: '" + fieldName + "'." + " Acceptable field names: "
		+ Arrays.stream(fields).map(field -> field.getName()).collect(Collectors.toList()));
    }

}
