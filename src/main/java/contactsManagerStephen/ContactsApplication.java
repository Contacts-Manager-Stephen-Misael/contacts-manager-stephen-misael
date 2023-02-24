package contactsManagerStephen;

import util.Input;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApplication {
    private static Input input = new Input();
    private static final String contactsFilePath = ("contacts.txt");
    private static ArrayList<Contact> contactObjectList = new ArrayList<>();
    private static List<String> contactStringList = new ArrayList<>();

    public static void main(String[] args) {
        //creates file if nonexistent, if exists, run the method to get data from file
        checkContactsFile();
        //prints contact objects that were converted by previous method
        printContacts();
        //shows main menu and give user options and perform user choice
        doUserChoice();
    }


    ///////////METHODS USED TO GET THE DATA FROM THE FILE AND DISPLAY IT ON THE PAGE//////////
    private static void checkContactsFile() {
        Path contactFile = Paths.get(contactsFilePath);
        try {
            Files.createFile(contactFile);
        } catch (FileAlreadyExistsException e) {
            getStringDataFromFile();
        } catch (IOException e) {
            System.out.println("createFile Exception: " + e.getMessage());
        }
    }

    private static void getStringDataFromFile() {
        Path contactFile = Paths.get(contactsFilePath);
        try {
            contactStringList = Files.readAllLines(contactFile);
        } catch (IOException e) {
            System.out.println("file read exception: " + e.getMessage());
        }

        for (String fileString : contactStringList) {
            Contact newContact = Contact.fromFileString(fileString);
            contactObjectList.add(newContact);
        }
    }


    private static void printContacts() {
        System.out.println("""
                -----------------------------------------------|
                           Name          |     Phone Number    |
                -----------------------------------------------|""");
        for (Contact contact : contactObjectList) {
            System.out.format("%-12s %-7s     |     %-15s |%n", contact.getFirstName(), contact.getLastName(), contact.formatPhoneNumber(contact.getPhoneNumber()));
        }
        System.out.println("------------------------------------------------\n");
    }

    private static void printMenu() {
        System.out.println("""
                1. View Contacts
                2. Add a new contact
                3. Search contact by name
                4. Delete an existing contact
                5. Exit\n""");
    }


    ////////////DO USER CHOICE CONTAINS ALL THE "ACTION" METHODS BY THE USER///////////////
    private static void doUserChoice() {
        while (true) {
            printMenu();
            int userChoice = input.getInt(1, 5, "Enter your numeric option (1-5): ");
            System.out.println();
            switch (userChoice) {
                case 1 -> printContacts();
                case 2 -> addNewContact();
                case 3 -> searchContacts();
                //edit delete method so that the user can type and THEN is given a list of options if duplicate
                case 4 -> deleteContact();
                case 5 -> {
                    reWriteContactsFile();
                    System.exit(0);
                }
            }
        }
    }

    private static void addNewContact() {
        Contact userContact = new Contact();
        String userFirstName = input.getString("Enter first name: ");
        String userLastName = input.getString("Enter last name: ");
        String userPhoneNum = input.getString("Enter 10 digit phone number e.g 5555555555");
        //checks to see if contact exists
        for (Contact contact : contactObjectList) {
            if (contact.getFirstName().equalsIgnoreCase(userFirstName) && contact.getLastName().equalsIgnoreCase(userLastName)) {
                System.out.println("This contact already exists! Please try again\n");
                return;
            }
            if (contact.getPhoneNumber().equals(userPhoneNum)) {
                System.out.println("This phone number is already stored for another contact! Please try again\n");
                return;
            }
        }
        //checks and implements if last name or first name was entered as an empty string
        if (userFirstName.equals("") && !userLastName.equals("")) {
            userContact = new Contact(userLastName, userPhoneNum);
        } else if (userLastName.equals("") && !userFirstName.equals("")) {
            userContact = new Contact(userFirstName, userPhoneNum);
        } else {
            userContact = new Contact(userFirstName, userLastName, userPhoneNum);
        }
        System.out.println("Contact added successfully!");
        contactObjectList.add(userContact);
    }

    private static void searchContacts() {
        String userSearch = input.getString("Search for a user by name or phone number:");
        boolean contactExists = false;
        System.out.println("~~~Results for your Search~~~");
        for (Contact contact : contactObjectList) {
            if (contact.getFirstName().equalsIgnoreCase(userSearch) || contact.getLastName().equalsIgnoreCase(userSearch) || contact.getPhoneNumber().equals(userSearch)) {
                System.out.format("%-12s %-7s     |     %-15s |%n", contact.getFirstName(), contact.getLastName(), contact.formatPhoneNumber(contact.getPhoneNumber()));
                contactExists = true;
            }
        }
        System.out.println();
        if (!contactExists) {
            System.out.println("No contacts found within search criteria\n");
        }
    }

    private static void deleteContact() {
        if (contactObjectList.size() > 0) {
            //prints list of contacts with numbers
            int i = 1;
            System.out.println("""
                          ~~Existing contacts to choose from~~
                    --------------------------------------------------|""");
            for (Contact contact : contactObjectList) {
                System.out.format("%d. %-12s %-7s     |     %-15s |%n", i++, contact.getFirstName(), contact.getLastName(), contact.formatPhoneNumber(contact.getPhoneNumber()));
            }
            System.out.println("--------------------------------------------------|");

            //deletes contact based on index of object:ist of Contacts
            int userDelete = input.getInt(1, contactObjectList.size(), "Choose number to delete: ");
            for (Contact contact : contactObjectList) {
                if (userDelete == contactObjectList.indexOf(contact) + 1) {
                    System.out.format("Contact to delete:| %s %s | %s |%n", contact.getFirstName(), contact.getLastName(), contact.formatPhoneNumber(contact.getPhoneNumber()));
                }
            }
            if (input.yesNo("Confirm Delete [Y/N]: ")) {
                contactObjectList.remove(userDelete - 1);
            } else {
                System.out.println("No more contacts to delete!");
            }
        } else {
            System.out.println("No existing contacts to delete\n");
        }
    }


    ///////////METHODS USED TO GET THE DATA FROM THE ARRAY LIST AND OVERWRITE THE FILE//////////
    public static void reWriteContactsFile() {
        ArrayList<String> contactStringList2 = new ArrayList<>();
        for (Contact contact : contactObjectList) {
            contactStringList2.add(contact.toFileString());
        }

        try {
            Files.write(Path.of(contactsFilePath), contactStringList2);
        } catch (IOException e) {
            System.out.println("Did not re-write.");
        }
    }

}
