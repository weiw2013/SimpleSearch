package com.simplesearch.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import com.simplesearch.entities.StandardEntity;
import com.simplesearch.entities.StandardEntityStorage;
import com.simplesearch.exceptions.InvalidFieldException;
import com.simplesearch.exceptions.InvalidTypeException;


/**
 * Search in-memory storage using type, field name(optional) and keyword by exact match
 */
public class KeywordSearchService {

    /**
     * @param type user/ticket/organization
     * @param keyword any word/term used for search
     * @param storage in-memory storage of users, organizations and tickets records
     * @return List of entities for the specified type and keyword by exact match
     */
    public List<StandardEntity> exactMatchByType(String type, String keyword, StandardEntityStorage storage) {
	List<StandardEntity> entities = storage.getByType(type);

	if (entities == null || entities.isEmpty()) {
	    throw new InvalidTypeException(type, storage.getTypes());
	}

	Field[] fields = entities.get(0).getClass().getDeclaredFields();

	return entities.stream().filter(entity -> {
	    for (Field field : fields) {
		if (exactMatch(entity, field, keyword)) {
		    return true;
		}
	    }
	    return false;
	}).collect(Collectors.toList());
    }

    /**
     * @param type user/ticket/organization
     * @param fieldName the field names within the specified type
     * @param keyword keyword any word/term used for search
     * @param storage List of entities for the specified type, field name and keyword by exact match
     * @return
     */
    public List<StandardEntity> exactMatchByTypeAndField(String type, String fieldName, String keyword,
	    StandardEntityStorage storage) {
	List<StandardEntity> entities = storage.getByType(type);

	if (entities == null || entities.isEmpty()) {
	    throw new InvalidTypeException(type, storage.getTypes());
	}

	try {
	    Field field = entities.get(0).getClass().getDeclaredField(fieldName);
	    return entities.stream().filter(entity -> {
		if (exactMatch(entity, field, keyword)) {
		    return true;
		}
		return false;
	    }).collect(Collectors.toList());

	} catch (Exception e) {
	    throw new InvalidFieldException(fieldName, entities.get(0).getClass().getDeclaredFields());
	}
    }

    private boolean exactMatch(StandardEntity entity, Field field, String keyword) {
	try {
	    Object value = entity.callGetter(field.getName());
	    if (value == null) {
		return keyword == null || keyword.isEmpty();
	    } else if (value instanceof List) {
		return ((List) value).contains(keyword);
	    } else {
		return String.valueOf(value).equals(keyword);
	    }

	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
}
