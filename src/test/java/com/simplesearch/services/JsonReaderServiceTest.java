package com.simplesearch.services;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simplesearch.entities.Organization;
import com.simplesearch.entities.StandardEntity;
import com.simplesearch.entities.Ticket;
import com.simplesearch.entities.User;

public class JsonReaderServiceTest {
    @DataProvider(name = "readerParams")
    public Object[][] createReaderParams() {
	return new Object[][] { { "users-test.json", User.class,
		new User(1, "http://initech.zendesk.com/api/v2/users/1.json", "74341f74-9c79-49d5-9611-87ef9b6eb75f",
			"Francisca Rasmussen", null, "2016-04-15T05:19:46 -10:00", true, true, false, "en-AU",
			"Sri Lanka", "2013-08-04T01:03:27 -10:00", "coffeyrasmussen@flotonic.com", "8335-422-718",
			"Don't Worry Be Happy!", 119L,
			Arrays.asList("Springville", "Sutton", "Hartsville/Hartley", "Diaperville"), true, "admin") },
		{ "tickets-test.json", Ticket.class,
			new Ticket("436bf9b0-1147-4c0a-8439-6f79833bff5b",
				"http://initech.zendesk.com/api/v2/tickets/436bf9b0-1147-4c0a-8439-6f79833bff5b.json",
				"9210cdc9-4bee-485f-a078-35396cd74063", "2016-04-28T11:19:34 -10:00", "incident",
				"A Catastrophe in Korea (North)",
				"Nostrud ad sit velit cupidatat laboris ipsum nisi amet laboris ex exercitation amet et proident. Ipsum fugiat aute dolore tempor nostrud velit ipsum.",
				"high", "pending", 38L, 24L, 116L,
				Arrays.asList("Ohio", "Pennsylvania", "American Samoa", "Northern Mariana Islands"),
				false, "2016-07-31T02:37:50 -10:00", "web") },

		{ "organizations-test.json", Organization.class,
			new Organization(101, "http://initech.zendesk.com/api/v2/organizations/101.json",
				"9270ed79-35eb-4a38-a46f-35725197ea8d", "Enthaze",
				Arrays.asList("kage.com", "ecratic.com", "endipin.com", "zentix.com"),
				"2016-05-21T11:10:28 -10:00", "MegaCorp", false,
				Arrays.asList("Fulton", "West", "Rodriguez", "Farley")) } };
    }

    @Test(dataProvider = "readerParams")
    public void testReadEntities(String path, Class someClass, StandardEntity entity) {	
	JsonReaderService service = new JsonReaderService();
	List<? extends StandardEntity> entities = service.readValues(path, someClass);
	Assert.assertEquals(entities.size(), 1);
	Assert.assertEquals(entities.get(0), entity);
    }
}
