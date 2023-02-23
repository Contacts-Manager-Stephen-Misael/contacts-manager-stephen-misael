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
        System.out.println("Your Contacts!");
        for (Contact contact: contactObjectList) {
            System.out.println(contact);
        }
        System.out.println();
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
                case 1 -> printContacts();
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
        Contact userContact = new Contact();
        String userFirstName = input.getString("Enter first name: ");
        String userLastName = input.getString("Enter last name: ");
        String userPhoneNum = input.getString("Enter 10 digit phone number e.g 5555555555");
        if(userFirstName.equals("")) {
            userContact = new Contact(userFirstName, userPhoneNum);
        } else if (userLastName.equals("")) {
            userContact = new Contact(userLastName, userPhoneNum);
        } else {
            userContact = new Contact(userFirstName, userLastName, userPhoneNum);
        }
        contactObjectList.add(userContact);
    }
}
