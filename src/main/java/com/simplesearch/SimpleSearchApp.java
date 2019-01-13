package com.simplesearch;

import java.util.List;
import java.util.Scanner;

import com.simplesearch.entities.Organization;
import com.simplesearch.entities.StandardEntity;
import com.simplesearch.entities.StandardEntityStorage;
import com.simplesearch.entities.Ticket;
import com.simplesearch.entities.User;
import com.simplesearch.services.InputSearchService;
import com.simplesearch.services.StandardEntityStorageInitializer;


/**
 * The entry point for the search application
 */
public class SimpleSearchApp {
    
    public static void main(String[] args) {
	System.out.println("Start reading json files...");
	StandardEntityStorageInitializer storageInitializer = new StandardEntityStorageInitializer();
	StandardEntityStorage storage = storageInitializer.initialize();
	System.out.println("Finished reading json files. You can start your search now");
	System.out.println(simpleHelpMessage());
	try (Scanner scanner = new Scanner(System.in)) {
	    InputSearchService searchService = new InputSearchService();

	    while (true) {
		System.out.print(">");
		String input = scanner.nextLine().trim();

		if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
		    break;
		}

		if (input.equalsIgnoreCase("help")) {
		    System.out.println(detailedUsageMessage());
		    continue;
		}

		try {		    
		    List<StandardEntity> searchResult = searchService.searchByInput(input, storage);
		    
		    if (searchResult != null) {
			System.out.println(String.format("Found %d record(s)", searchResult.size()));
			for(int i = 0; i < searchResult.size(); i++) {
			    System.out.println(String.format("Record %d: ", i + 1));
			    System.out.println(searchResult.get(i));
			}
		    }
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		    System.out.println(simpleHelpMessage());
		}

	    }
	}
    }

    

    private static String simpleHelpMessage() {
	return "Type \"help\" for detailed usage of the app. Type \"quit\" or \"exit\" to exit the app.";
    }

    private static String detailedUsageMessage() {
	return "Usage: \n" + "(user|ticket|organization) [lowerCamelCase field name] <keyword for search>\n\n"
		+ "Example: \n"
		+ "user admin					# find all users with field of value \"admin\"\n"
		+ "organization id 119				# find all organization with the \"id\" field of value 119\n"
		+ "ticket organizationId \"\"			# find all tickets with empty organizationId field\n\n"
		+ "Searchable fields in user: \n" + new User().getFieldNames() + "\n\n"
		+ "Searchable fields in ticket: \n"+ new Ticket().getFieldNames() + "\n\n"
		+ "Searchable fields in organization: \n"+ new Organization().getFieldNames() + "\n\n";
    }

}
