
package csc212_project;
// Importing Scanner class for reading input data from the user
import java.util.Scanner;

// This class represents a Phonebook application
public class Phonebook {

    // Creating a Scanner object to read input data from the user
    public static Scanner input = new Scanner(System.in);

    // Creating a linked list to store contacts
    public static LinkedList<Contact> contacts = new LinkedList<Contact>();

    // Creating a linked list to store events
    public static LinkedList<Event> events = new LinkedList<Event>();

    // This method displays the main menu and returns user's choice
    public static int option() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");
        System.out.print("\nEnter your choice: ");
        
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        return choice;
    }

    // This method displays the menu for searching contacts and returns user's choice
    public static int criteria1() {
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.print("\nEnter your choice: ");
        
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        return choice;
    }

    // This method displays the menu for searching events and returns user's choice
    public static int criteria2() {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline
        return choice;
    }

    // 1. Add a contact
    // This method allows the user to add a new Contact to the phonebook
    public static void AddContact() {
        Contact objContact = new Contact();
        System.out.print("Enter the contact's name: ");
        objContact.name = input.nextLine();

        if (!contacts.empty() && contacts.search(objContact)) { // Where the name must be unique.
            System.out.println("Contact found!");
            return;
        }
        
        System.out.print("Enter the contact's phone number: ");
        objContact.phoneNumber = input.nextLine();

        if (!contacts.empty()) {
            contacts.findFirst();
            for (int i = 0; i < contacts.size; i++) {
                if (contacts.retrieve().phoneNumber.compareTo(objContact.phoneNumber) == 0) { // Where the phonenumber must be unique.
                    System.out.println("Contact found!");
                    return;
                }
                contacts.findNext();
            }
        }
        System.out.print("Enter the contact's email address: ");
        objContact.emailAddress = input.nextLine();
        System.out.print("Enter the contact's address: ");
        objContact.address = input.nextLine();
        System.out.print("Enter the contact's birthday: ");
        objContact.birthday = input.nextLine();
        System.out.print("Enter any notes for the contact: ");
        objContact.notes = input.nextLine();

        if (contacts.Add(objContact))
            System.out.println("\nContact added successfully!");

    }//End method AddContact()

    // 2. Search for a contact
    // This method allows the user to search for a contact based on various criteria
    public static void SearchContact() {
    	boolean found = false;  //this boolean works like a switch. on(true) --> Contact found/ off(false) --> Contact not found.
    	int choice = criteria1();
        if (contacts.empty())
        	System.out.println("Contact not found!");
        else {
            contacts.findFirst();
            switch (choice) {
                case 1: {
                    // Search for contact by name
                    System.out.print("Enter the contact's name: ");
                    String name = input.nextLine();
                    
                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().name.compareTo(name) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                            break;
                        }
                        contacts.findNext();
                    }
                    if(!found)
                    	System.out.println("Contact Not found!");
                  
                }
                    break;

                case 2: {
                    // Search for contact by phone number
                    System.out.print("Enter the contact's phone number:");
                    String phoneNumber = input.nextLine();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().phoneNumber.compareTo(phoneNumber) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                            break;
                        }
                        contacts.findNext();
                    }
                    if(!found)
                    	System.out.println("Contact Not found!");
                }
                    break;

                case 3: {
                    // Search for contact by email address
                    System.out.print("Enter the contact's email address: ");
                    String emailAddress = input.nextLine();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().emailAddress.compareTo(emailAddress) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                        }
                        contacts.findNext();
                    }
                    if(!found)
                    	System.out.println("Contact not found!");
                    
                }
                    break;

                case 4: {
                    // Search for contact by address
                    System.out.print("Enter the contact's address: ");
                    String address = input.nextLine();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().address.compareTo(address) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                        }
                        contacts.findNext();
                    }
                    if(!found)
                    	System.out.println("Contact not found!");
                }
                    break;

                case 5: {
                    // Search for contact by birthday
                    System.out.print("Enter the contact's Birthday: ");
                    String birthday = input.next();

                    for (int i = 0; i < contacts.size; i++) {
                        if (contacts.retrieve().birthday.compareTo(birthday) == 0) {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            found = true;
                        }
                        contacts.findNext();
                    }
                    if(!found)
                    	System.out.println("Contact not found!");
                }
            }// End switch (choice)
        }
    }// End method SearchContact.

    // 3. Delete a contact
    // This method allows the user to delete a contact from the phonebook
    public static void DeleteContact() {
        Contact objContact = new Contact();

        System.out.print("Enter the contact's name: ");
        objContact.name = input.nextLine();

        if (contacts.empty())
            System.out.println("Contact not found!");
        else {
            objContact = contacts.remove(objContact);
            if (objContact == null)
                System.out.println("Contact not found!");
            else {
                if (!objContact.events.empty()) {
                    objContact.events.findFirst();
                    for (int i = 0; i < objContact.events.size; i++) {
                        Event e = objContact.events.retrieve();
                        if (events.search(e)) {
                            Event Update_Event = events.retrieve();
                            Update_Event.removeContact(objContact.name);
                            if (Update_Event.contact_name.equals(objContact.name)) {
                                events.remove(e);
                                System.out.println("Delete event, No cantact particapate"); }
                             else
                                events.update(Update_Event);

                        }
                        objContact.events.findNext();
                    }
                }
                System.out.println("Contact Deleted Successfully !");
                System.out.println(objContact);
            }
        }
    } //End method DeleteContact.

    // 4. Schedule an event
    // This method allows the user to schedule an event and associate it with a contact
    public static void ScheduleEvent() {
        Contact objContact = new Contact();
        Event objEvent = new Event();
    
        System.out.print("Enter event title: ");
        objEvent.title = input.nextLine();
        System.out.print("Enter contact name: ");
        objContact.name = input.nextLine();
        System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
        objEvent.date = input.next();
        objEvent.time = input.next();
        
        input.nextLine(); // Consume newline
    
        System.out.print("Enter event location: ");
        objEvent.location = input.nextLine();
    
        boolean conflictFound = false;
        if (!events.empty()) {
            events.findFirst();
            for (int i = 0; i < events.size; i++) {
                if ((events.retrieve().date.compareTo(objEvent.date) == 0)
                        && (events.retrieve().time.compareTo(objEvent.time) == 0)) {
                    conflictFound = true;
                    break;
                }
                events.findNext();
            }
        }
    
        if (conflictFound) {
            System.out.println("\nThere's a scheduling conflict. The event could not be added.");
        }
        else {
            if (!contacts.empty() && contacts.search(objContact) == true) {
                objContact = contacts.retrieve();
                objContact.addEvent(objEvent); // Directly adding the event as we've already checked for conflicts
                contacts.update(objContact);
                
                if (!events.empty() && events.search(objEvent)) {
                    Event eventFound = events.retrieve();
                    eventFound.contact_name = objContact.name;
                    events.update(eventFound);
                } 
                else {
                    events.Add(objEvent);
                    System.out.println("\nEvent scheduled Successfully !"); }
            } 
            else {
                System.out.println("\nContact not found.");
            }
        }
    }// End method ScheduleEvent.
    
    // 5. Print event details
    // This method allows the user to print event details either by contact name or event title
    public static void PrintEvent() {
        int choice =  criteria2();
        switch (choice) {
            case 1: {
                // Print event details by contact name
                Contact objContact = new Contact();
                System.out.print("Enter the contact name :  ");
                objContact.name = input.nextLine();

                if (!contacts.empty()) {
                    if (contacts.search(objContact) == true) {
                        System.out.println("Contact found !");
                        objContact = contacts.retrieve();

                        objContact.events.findFirst();

                        for (int i = 0; i < objContact.events.size; i++) {
                            Event e = objContact.events.retrieve();
                            if (!events.empty()&& events.search(e))
                                System.out.println(events.retrieve());
                            objContact.events.findNext();
                        }
                        if (objContact.events.empty())
                            System.out.println("No events found for this contact !");
                    } else
                        System.out.println("Contact not found !");
                } else
                    System.out.println("Contact not found !");
            }
                break;

            case 2: {
                // Print event details by event title
                Event objEvent = new Event();
                System.out.print("Enter the event title:  ");
                objEvent.title = input.nextLine();

                if (!events.empty() && events.search(objEvent)) {
                    System.out.println("Event found!");
                    System.out.println(events.retrieve());
                } else
                    System.out.println("Event not found !");
            }
                break;
        }// End switch (choice).
    }// End method PrintEvent.

    // 6. Print contacts by first name
    // This method allows the user to print contacts that have a specific first name
    public static void PrintContactsFirstName() {

        System.out.print("Enter the first name:");
        String fname = input.nextLine();

        if (contacts.empty())
            System.out.println("No Contacts found !");

        contacts.findFirst();
        System.out.println("Contacts found!");
        for (int i = 0; i < contacts.size; i++) {
            String name = contacts.retrieve().name;
            String[] Allf = name.split(" ");

            
            if (Allf[0].compareToIgnoreCase(fname) == 0)
                System.out.println(contacts.retrieve() + "\n");
            contacts.findNext();
        }
    }// End method PrintContactsFirstName.

    // 7. Print all events alphabetically // O(n)
    // This method allows the user to print all events in the phonebook in alphabetical order
    public static void PrintAllEvents() {
        if (!events.empty()) {
            events.findFirst();
            for (int i = 0; i < events.size; i++) {
                System.out.println((i + 1) + ". Event : " + events.retrieve().title);
                events.findNext();
            }
        } else
            System.out.println("No events found !");
    }// End method PrintAllEvents.

    // Main method to run the Phonebook application
    public static void main(String[] args) {
        System.out.println("Welcome to the Linked Tree Phonebook!");
        int choice;
        do {
            choice = option();
            switch (choice) {
                case 1:
                    // Option to add a new contact to the phonebook
                    AddContact();
                    break;

                case 2:
                    // Option to search for a contact based on various criteria
                    SearchContact();
                    break;

                case 3:
                    // Option to delete a contact from the phonebook
                    DeleteContact();
                    break;

                case 4:
                    // Option to schedule an event and associate it with a contact
                    ScheduleEvent();
                    break;

                case 5:
                    // Option to print event details either by contact name or event title
                    PrintEvent();
                    break;

                case 6:
                    // Option to print contacts that have a specific first name
                    PrintContactsFirstName();
                    break;

                case 7:
                    // Option to print all events in the phonebook in alphabetical order
                    PrintAllEvents();
                    break;

                case 8:
                    // Option to exit the application
                    System.out.println("Goodbye!");
                    break;
                default:
                    // In case the user enters an invalid choice
                    System.out.println("Try again!");
            }// End switch (choice).
            
            System.out.println("\n");
        } while (choice != 8); // Exit when user chooses option 8
    }// End main.

}// End class Phonebook