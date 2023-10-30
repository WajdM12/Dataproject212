
package csc212_project;

// The Contact class implements the Comparable interface, meaning it can be compared to other Contacts.
public class Contact implements Comparable<Contact> {

    // These are the private fields that store the properties of a contact.
     String name;
     String phoneNumber;
     String emailAddress;
     String address;
     String birthday;
     String notes;
     LinkedList<Event> events;

    // Constructor to initialize the contact with an empty state.
    public Contact() {
        this.name = "";
        this.phoneNumber = "";
        this.emailAddress = "";
        this.address = "";
        this.birthday = "";
        this.notes = "";
        events = new LinkedList<Event>();
    }

    // Constructor to initialize the contact with the provided values.
    public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
            String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events = new LinkedList<Event>();
    }
 
    
    // Override of the toString method to provide a string representation of the Contact object.
    @Override
    public String toString() {
        return "\nName: " + name +
                "\nPhone Number: " + phoneNumber +
                "\nEmail Address: " + emailAddress +
                "\nAddress: " + address +
                "\nBirthday: " + birthday +
                "\nNotes: " + notes + "\n";
    }

    // Method to add an event to the list of events associated with this contact.
    public boolean addEvent(Event e) {
        events.Add(e);
        return true;
    }    

    // Method to remove an event with a specific title from the list of events.
    public boolean removeEvent(String eTitle) {
        if (events.empty())
            return false;
        Event val = new Event();
        val.title = eTitle;
        if (events.search(val)) {
            events.remove(val);
            return true;
        }
        return false;
    }

    // Implementation of the compareTo method from the Comparable interface to compare contacts based on their names.
    @Override
    public int compareTo(Contact o) {
        try {
            return (this.name.compareTo(o.name)); // + or 0 or - 
        } catch (Exception e) {
            // To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}// End class Contact