
package prog212;

import java.util.*;
public class Phonebook {
   
public static void main(String[] args){
    
Scanner input = new Scanner (System.in);

boolean working = true;

//int ch = -1;

//do {

while (working) {
    //Display the main menu 
System.out.println("Welcome to the Linked Tree Phonebook!");
System.out.println("Please choose an option:");
System.out.println("1. Add a contact");
System.out.println("2. Search for a contact");
System.out.println("3. Delete a contact");
System.out.println("4. Schedule an event");
System.out.println("5. Print event details");
System.out.println("6. Print contacts by first name");
System.out.println("7. Print all events alphabetically");
System.out.println("8. Exit");

System.out.println("");
System.out.print("Enter your choice: ");
int choice = input.nextInt(); //Get the user's choice 
System.out.println("");

switch(choice){
     case 1:
         //Add a contact, then added to the phonebook
         System.out.println("Enter the contact's name: ");
         String name = input.nextLine();
         System.out.println("Enter the contact's phone number: ");
         String phoneNumber = input.nextLine();
         System.out.println("Enter the contact's email address: ");
         String email = input.nextLine();
         System.out.println("Enter the contact's address: ");
         String address = input.nextLine();
         System.out.println("Enter the contact's birthday: ");
         String birthday = input.nextLine();
         System.out.println("Enter any notes for the contact: ");
         String notes = input.nextLine();
 
         Contact contact = new Contact (name, phoneNumber, email, address, birthday, notes);
        // we need method addContact in this class ?        phonebook.addContact(contact);
         System.out.println("\nContact added successfully!");
         break;
         
     case 2:
         //Search for a contact 
          System.out.println("Enter search criteria:");
          System.out.println("1. Name");
          System.out.println("2. Phone Number");
          System.out.println("3. Email Address");
          System.out.println("4. Address");
          System.out.println("5. Birthday");
        //System.out.println("");
         System.out.println("Enter your choice: ");
         int searchChoice = input.nextInt();
         //input.nextLine();
         //System.out.println("");
         switch (searchChoice){
             case 1:
                 //Search for contact
                  System.out.println("Enter the contact's name: ");
                  name = input.nextLine();
                  //System.out.println("");
                  // we need method search contact by name in this class ?
                    
             
           
         }//end switch
         
         
break;
case 3:

break;
case 4 :

break;
case 5:

break;
case 6:

break;
case 7:

break;
case 8:
System.out.println("Goodbye!");
break;
}//switch

}//while(ch!=8);



}//end main






}//end class Phonebook


