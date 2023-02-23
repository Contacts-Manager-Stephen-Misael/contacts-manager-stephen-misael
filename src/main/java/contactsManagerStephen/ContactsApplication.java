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

    private static final List<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        //reads from the contacts file and prints to the CLI all the contacts that exist in the
        readContactInfoFromFile();

        //shows main menu and give user options
        //perform user choice by calling a method that alters the list
        doUserChoice();
    }

    private static void readContactInfoFromFile() {
        ArrayList<Contact> contacts = new ArrayList<>(); //used to store the contacts from the file strings

        ContactsToFromFile printToCLIFromFile = new ContactsToFromFile();
        printToCLIFromFile.printContactsFile(contactsFilePath, contacts);

    }

    private static void printMenu() {
        System.out.println("""
                1. View Contacts
                2. Add a new contact
                3. Search contact by name
                4. Delete and existing contact
                5. Exit\n""");
    }

    private static void doUserChoice() {
        while (true) {
            printMenu();
            int userChoice = input.getInt(1, 5, "Enter your numeric option (1-5): ");
            switch (userChoice) {
                case 1 -> readContactInfoFromFile();
                case 2 -> addNewContact();
                case 3 -> System.out.println("search by name");
                case 4 -> System.out.println("delete existing contact");
                case 5 -> {
                    System.out.println("exit and save to contacts file");
                    System.exit(0);
                }
            }
        }
    }

    private static void addNewContact() {
        String userFirstName = input.getString("Enter first name: ");
        String userLastName = input.getString("Enter last name: ");
        String userPhoneNum = input.getString("Enter 10 digit phone number e.g 5555555555");
        Contact userContact = new Contact(userFirstName, userLastName, userPhoneNum);
        contactList.add(userContact);
    }
}
