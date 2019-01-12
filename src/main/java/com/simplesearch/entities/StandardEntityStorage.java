package com.simplesearch.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * In-memory storage of User, Ticket and Organization objects
 */
public class StandardEntityStorage {
    Map<String, List<StandardEntity>> typeToEntities;

    public StandardEntityStorage() {
	typeToEntities = new HashMap<>();
    }

    public void addToStorage(List<? extends StandardEntity> entities) {
	if (entities == null || entities.size() == 0) {
	    return;
	}

	String type = entities.get(0).getClass().getSimpleName().toLowerCase();
	typeToEntities.putIfAbsent(type, new ArrayList<>());
	typeToEntities.get(type).addAll(entities);
    }

    public List<StandardEntity> getByType(String type) {
	if (type == null) {
	    return null;
	}

	return typeToEntities.get(type.toLowerCase());
    }

    public List<String> getTypes() {
	return new ArrayList<>(typeToEntities.keySet());
    }
}
