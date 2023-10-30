
package csc212_project;

// The Event class represents an event with attributes like title, date and time, location, and associated contact.
public class Event implements Comparable<Event> {
    String title;
    String date; // Format: 2023/12/31
    String time;
    String location;
    String contact_name;

    // Default constructor to initialize the event with empty values.
    public Event() {
        this.title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        this.contact_name ="";
    }

    // Constructor to initialize the event with provided values and an initial contact.
    public Event(String title, String date, String time, String location, String contact) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contact_name = contact;
    }

    // Method to remove a contact from the list of contacts associated with this event.
    public boolean removeContact(String contact) {
           if (contact_name.equals(contact)) {
        contact_name = "";  // Reset the contact name
        return true;
    }
    return false;
}

    // Override of the toString method to provide a string representation of the Event object.
    @Override
    public String toString() {
        String str = "\nEvent title: " + title +
                     "\nContacts names: " + contact_name +
                     "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + " " + time +
                     "\nEvent location: " + location;
          return str;
    }

    // Implementation of the compareTo method from the Comparable interface to compare events based on their titles.
    @Override
    public int compareTo(Event obj) {
        try {
            return (this.title.compareToIgnoreCase(obj.title));
        }
        catch (Exception e)
        {
             //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}// End class Event