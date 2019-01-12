package com.simplesearch.services;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

/**
 * Read json file content into list of objects in memory
 */
public class JsonReaderService {
    private ObjectMapper mapper;

    public JsonReaderService() {
	mapper = new ObjectMapper();
    }

    /**
     * @param filename source json file
     * @param elementClass can be User.class, Ticket.class or Organization.class
     * @return List of objects of type elementClass representing json file content
     */
    public <T> List<T> readValues(String filename, Class<T> elementClass) {
	try {
	    CollectionType typeReference = mapper.getTypeFactory().constructCollectionType(List.class, elementClass);
	    return mapper.readValue(this.getClass().getResourceAsStream(filename), typeReference);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}
    }

}
