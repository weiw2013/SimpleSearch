package com.simplesearch.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simplesearch.entities.StandardEntityStorage;
import com.simplesearch.exceptions.TooFewArgumentsException;
import com.simplesearch.exceptions.TooManyArgumentsException;

public class InputSearchServiceTest {

    @DataProvider(name = "positiveSearchInputs")
    public Object[][] createPositiveInputs() {
	return new Object[][] { { "user admin", Arrays.asList("user", "admin") },
		{ "user \"\"", Arrays.asList("user", "") },
		{ "user role admin", Arrays.asList("user", "role", "admin") },
		{ "user		role admin", Arrays.asList("user", "role", "admin") },
		{ "ticket description \"\"", Arrays.asList("ticket", "description", "") },

	};
    }

    @Test(dataProvider = "positiveSearchInputs")
    public void testPositiveInput(String input, List<String> expectedArguments) {
	KeywordSearchService mockSearchService = EasyMock.mock(KeywordSearchService.class);
	InputSearchService inputSearchService = new InputSearchService(mockSearchService);
	StandardEntityStorage storage = new StandardEntityStorage();

	List<String> arguments = InputSearchService.getArguments(input);
	Assert.assertEquals(arguments, expectedArguments);

	if (arguments.size() == 2) {
	    EasyMock.expect(mockSearchService.exactMatchByType(arguments.get(0), arguments.get(1), storage))
	    .andReturn(new ArrayList<>());
	} else if (arguments.size() == 3) {
	    EasyMock.expect(mockSearchService.exactMatchByTypeAndField(arguments.get(0), arguments.get(1),
		    arguments.get(2), storage)).andReturn(new ArrayList<>());
	} else {
	    Assert.fail();
	    
	}
	EasyMock.replay(mockSearchService);
	inputSearchService.searchByArguments(arguments, storage);
	EasyMock.verify(mockSearchService);
    }
    
    @DataProvider(name = "negativeSearchInputs")
    public Object[][] createNegativeInputs() {
	return new Object[][] {
	    	{ null, new TooFewArgumentsException() },
	    	{ "", new TooFewArgumentsException() },
		{ "userroleadmin", new TooFewArgumentsException() },
		{ "user	role alias admin", new TooManyArgumentsException() },

	};
    }

    @Test(dataProvider = "negativeSearchInputs")
    public void testNegativeInput(String input, Exception expectedException) {
	InputSearchService inputSearchService = new InputSearchService();
	StandardEntityStorage storage = new StandardEntityStorage();
	
	try {
	    inputSearchService.searchByInput(input, storage);
	    Assert.fail();
	} catch(Exception e) {
	    Assert.assertEquals(e.getClass(), expectedException.getClass());
	}
    }

}
