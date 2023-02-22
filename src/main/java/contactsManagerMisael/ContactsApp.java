package contactsManagerMisael;
import java.util.Scanner;



import java.util.Scanner;

public class ContactsApp {
    private final ContactsManager contactsManager;
    private final ContactsMenu contactsMenu;

    public ContactsApp() {
        this.contactsManager = new ContactsManager();
        this.contactsMenu = new ContactsMenu(contactsManager);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option = contactsMenu.showMainMenu();

        while (option != 5) {
            switch (option) {
                case 1 -> {
                    clearConsole();
                    contactsManager.viewContacts();
                }
                case 2 -> {
                    Contact newContact = contactsMenu.getNewContactInfo();
                    contactsManager.addContact(newContact);
                    clearConsole();
//                    System.out.println("Contact added successfully!");
                }
                case 3 -> {
                    String searchQuery = contactsMenu.getSearchQuery();
                    contactsManager.searchContactsByName(searchQuery);
                }
                case 4 -> {
                    Contact contactToDelete = contactsMenu.getContactToDelete();
                    if (contactsManager.deleteContact(contactToDelete)) {
                        clearConsole();
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("The contact could not be found.");
                    }
                }
                default -> System.out.println("Invalid option.");
            }

            option = contactsMenu.showMainMenu();
        }

        contactsManager.saveContactsToFile();
        System.out.println("Exiting the application.");
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}







//         main application that manages contacts.
//
//        The class contains two private instance variables, contactsManager and contactsMenu, both of which are initialized in the constructor.
//        contactsManager is an instance of the ContactsManager class, which handles the underlying data storage and management for contacts.
//        contactsMenu is an instance of the ContactsMenu class, which provides a user interface for the application.
//
//        The class has a public method named run() which starts the application.
//        It begins by creating a new Scanner object to read input from the user.
//        Then, it displays the main menu using the showMainMenu() method of the  contactsMenu,
//        object and reads the user's choice using the nextInt() method of the Scanner object.
//
//        The method then enters a loop which continues until the user chooses to exit the application.
//        Inside the loop, the method uses a switch statement to perform different actions depending on the user's choice.
//        If the user chooses to view all contacts, the viewContacts() method of the contactsManager object is called to display all contacts.
//        If the user chooses to add a new contact, the getNewContactInfo() method of the contactsMenu object is called to get the contact information from the user,
//        and then the addContact() method of the contactsManager object is called to add the new contact. If the user chooses to search for contacts,
//        the getSearchQuery() method of the contactsMenu object is called to get the search query from the user,
//        and then the searchContactsByName() method of the contactsManager object is called to search for contacts with the given name.
//        If the user chooses to delete a contact, the getContactToDelete() method of the contactsMenu object is called to get the contact to delete from the user,
//        and then the deleteContact() method of the contactsManager object is called to delete the contact.
//
//        When the loop ends, and the saveContactsToFile() method of the contactsManager object is called to save the contacts to a file,
//        and a message is printed indicating that the application is exiting.
//
//        The class also contains a private method named clearConsole() which clears the console output using escape characters.
//        This method is called whenever the console needs to be cleared, such as when a new menu is displayed or when a message is printed.

