package com.simplesearch.services;

import java.util.List;
import com.simplesearch.entities.Organization;
import com.simplesearch.entities.StandardEntityStorage;
import com.simplesearch.entities.Ticket;
import com.simplesearch.entities.User;

/**
 * Initialize in-memory storage with content from json files
 *
 */
public class StandardEntityStorageInitializer {
    
    /**
     * @return
     */
    public StandardEntityStorage initialize() {
	JsonReaderService readerService = new JsonReaderService();
	List<User> users = readerService.readValues("users.json", User.class);
	List<Ticket> tickets = readerService.readValues("tickets.json", Ticket.class);
	List<Organization> organizations = readerService.readValues("organizations.json",
		Organization.class);

	StandardEntityStorage storage = new StandardEntityStorage();
	storage.addToStorage(users);
	storage.addToStorage(tickets);
	storage.addToStorage(organizations);

	return storage;
    }
}
