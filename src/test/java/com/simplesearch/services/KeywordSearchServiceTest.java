package com.simplesearch.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simplesearch.entities.Organization;
import com.simplesearch.entities.StandardEntity;
import com.simplesearch.entities.StandardEntityStorage;
import com.simplesearch.entities.Ticket;
import com.simplesearch.entities.User;
import com.simplesearch.exceptions.InvalidFieldException;
import com.simplesearch.exceptions.InvalidTypeException;

public class KeywordSearchServiceTest {
    private StandardEntityStorage storage = new StandardEntityStorage();
    private List<StandardEntity> users = new ArrayList<>();
    private List<StandardEntity> tickets = new ArrayList<>();
    private List<StandardEntity> organizations = new ArrayList<>();
    private KeywordSearchService keywordSearchService = new KeywordSearchService();

    @BeforeTest
    public void setup() {	
	users.add(new User(1, "url1", "externalId1", "name1", "alias1", "2016-04-15T05:19:46 -10:00", true, true, false,
		"en-AU", "Sri Lanka", "2013-08-04T01:03:27 -10:00", "coffeyrasmussen@flotonic.com", "8335-422-718",
		"signature1", 119L, Arrays.asList("tag1", "tag2", "tag3", "tag4"), true, "admin"));

	users.add(new User(2, "url2", "externalId2", "name2", null, "2016-04-15T05:19:46 -10:00", true, true, false,
		"en-AU", "US", "2013-08-04T01:03:27 -10:00", "xyz@abc.com", "123-456-789", "signature2", 120L,
		Arrays.asList("tag3", "tag4", "tag5"), true, "agent"));

	tickets.add(new Ticket("id", "url", "externalId", "2016-04-28T11:19:34 -10:00", "incident", "subject",
		"description", "high", "pending", 38L, 24L, 116L, Arrays.asList("Ohio", "Pennsylvania"), false,
		"2016-07-31T02:37:50 -10:00", "web"));
	
	organizations.add(new Organization(10, "url",
		"externalId", "Enthaze",
		Arrays.asList("kage.com", "ecratic.com"),
		"2016-05-21T11:10:28 -10:00", "MegaCorp", false,
		Arrays.asList("Fulton", "West")));

	storage.addToStorage(users);
	storage.addToStorage(tickets);
	storage.addToStorage(organizations);
    }
    
    @DataProvider(name = "positiveSearchParams")
    public Object[][] createPositiveParams() {
	return new Object[][] {
	    {"user", null, "name1", users.subList(0, 1)},
	    {"user", null, "tag3", users},
	    {"user", null, "1", users.subList(0, 1)},
	    {"user", "alias", "", users.subList(1, 2)},
	    {"user", "role", "admin", users.subList(0, 1)},
	    {"ticket", null, "false", tickets},
	    {"ticket", "type", "incident", tickets},
	    {"organization", null, "", new ArrayList<>()}
	};
    }
    
    @Test(dataProvider = "positiveSearchParams")
    public void positiveSearchTest(String type, String field, String keyword, List<StandardEntity> expectedSearchResult) {
	List<StandardEntity> searchResult = searchByExactMatch(type, field, keyword);
	Assert.assertEquals(searchResult, expectedSearchResult);
    }
    
    @DataProvider(name = "negativeSearchParams")
    public Object[][] createNegativeParams() {
	return new Object[][] {
	    {"random", null, "name1", new InvalidTypeException()},
	    {"random", "alias", "", new InvalidTypeException()},
	    {"ticket", "random", "incident", new InvalidFieldException()},
	    {"xyz", "random", "incident", new InvalidTypeException()},
	};
    }
    
    @Test(dataProvider = "negativeSearchParams")
    public void negativeSearchTest(String type, String field, String keyword, Exception expectedException) {
	try {
	List<StandardEntity> searchResult = searchByExactMatch(type, field, keyword);
	Assert.fail();
	} catch(Exception e) {
	    Assert.assertEquals(e.getClass(), expectedException.getClass());
	}
    }
    
    
    private List<StandardEntity> searchByExactMatch(String type, String field, String keyword) {
	List<StandardEntity> searchResult = null;
	if(field == null) {
	    searchResult = keywordSearchService.exactMatchByType(type, keyword, storage);
	} else {
	    searchResult = keywordSearchService.exactMatchByTypeAndField(type, field, keyword, storage);
	}
	
	return searchResult;
    }

}
