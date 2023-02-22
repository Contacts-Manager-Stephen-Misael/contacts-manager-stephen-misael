package contactsManagerMisael;

import java.util.Scanner;

public class ContactsMenu {
    private final Scanner scanner;

    public ContactsMenu(ContactsManager contactsManager) {
        this.scanner = new Scanner(System.in);
    }





//
//    public int showMainMenu() {
//        System.out.println("1. View contacts.");
//        System.out.println("2. Add a new contact.");
//        System.out.println("3. Search a contact by name.");
//        System.out.println("4. Delete an existing contact.");
//        System.out.println("5. Exit.");
//        System.out.print("Enter an option (1, 2, 3, 4 or 5): ");
//        return scanner.nextInt();
//    }






    public int showMainMenu() {
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.print("Enter an option (1, 2, 3, 4 or 5): ");
        String input = scanner.nextLine();
        while (!input.matches("[1-5]")) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            System.out.print("Enter an option (1, 2, 3, 4 or 5): ");
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }



    public Contact getNewContactInfo() {
//        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        return new Contact(name, phoneNumber);
    }

    public String getSearchQuery() {
//        scanner.nextLine();
        System.out.print("Enter search query: ");
        return scanner.nextLine();
    }

    public Contact getContactToDelete() {
//        scanner.nextLine();
        System.out.print("Enter name of contact to delete: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number of contact to delete: ");
        String phoneNumber = scanner.nextLine();
        return new Contact(name, phoneNumber);
    }
}






//ContactsMenu class provides a simple console-based user interface for interacting with the ContactsManager class.
// It contains methods for displaying a menu of options, getting user input, and returning data entered by the user. Here's an explanation of each method:
//
//public ContactsMenu(ContactsManager contactsManager): This is the constructor for the ContactsMenu class.
// It takes a ContactsManager object as a parameter, but doesn't actually use it in the current implementation.
//
//public int showMainMenu(): This method displays a menu of options and returns the user's selected option as an integer.
// It prompts the user to enter an option number (1, 2, 3, 4 or 5) and returns the value entered by the user as an integer.
//
//public Contact getNewContactInfo(): This method prompts the user to enter a name and phone number for a new contact,
// and returns a Contact object containing this information.
//
//public String getSearchQuery(): This method prompts the user to enter a search query (a name to search for),
// and returns the value entered by the user as a string.
//
//public Contact getContactToDelete(): This method prompts the user to enter the name and phone number of a contact to delete,
// and returns a Contact object containing this information.
//
//The Scanner object is used to get user input from the console.
// The nextLine() method is called to consume the end-of-line character after the user enters a value,
// which allows subsequent nextLine() calls to function properly.






