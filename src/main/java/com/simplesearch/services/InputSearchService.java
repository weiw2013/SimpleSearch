package com.simplesearch.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.simplesearch.entities.StandardEntity;
import com.simplesearch.entities.StandardEntityStorage;
import com.simplesearch.exceptions.TooFewArgumentsException;
import com.simplesearch.exceptions.TooManyArgumentsException;

/**
 * Take input from keyboard and search in-memory storage
 */
public class InputSearchService {
    private static final Pattern inputPattern = Pattern.compile("([^\"]\\S*|\".*?\")\\s*");
    private KeywordSearchService searchService;

    public InputSearchService() {
	searchService = new KeywordSearchService();
    }
    
    public InputSearchService(KeywordSearchService searchService) {
	this.searchService = searchService;
    }
    
    
    /**
     * @param input command-line input
     * @param storage in-memory storage of users, organizations and tickets records
     * @return List of entities satisfy input
     */
    public List<StandardEntity> searchByInput(String input, StandardEntityStorage storage) {
	List<String> arguments = getArguments(input);
	return searchByArguments(arguments, storage);
    }
    
    
    /**
     * @param arguments list of search terms
     * @param storage in-memory storage of users, organizations and tickets records
     * @return List of entities satisfy input
     */
    public List<StandardEntity> searchByArguments(List<String> arguments, StandardEntityStorage storage) {
	if (arguments.size() <= 1) {
	    throw new TooFewArgumentsException();
	} else if (arguments.size() == 2) {
	    return searchService.exactMatchByType(arguments.get(0), arguments.get(1), storage);
	} else if (arguments.size() == 3) {
	    return searchService.exactMatchByTypeAndField(arguments.get(0), arguments.get(1), arguments.get(2),
		    storage);
	} else {
	    throw new TooManyArgumentsException();
	}
    }
    
    

    /**
     * @param input command-line input
     * @return list of arguments split by whitespace
     */
    public static List<String> getArguments(String input) {
	List<String> arguments = new ArrayList<>();
	if(input == null) {
	    return arguments;
	}
	
	Matcher matcher = inputPattern.matcher(input);
	while (matcher.find()) {
	    arguments.add(matcher.group().trim().replace("\"", ""));
	}

	return arguments;
    }

}
