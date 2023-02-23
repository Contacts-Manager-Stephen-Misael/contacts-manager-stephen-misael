package contactsManagerStephen;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ContactsToFromFile{

    public void printContactsFile(String filepath, ArrayList<Contact> passedArrList) {
        Path contactFile = Paths.get(filepath);
        // creates the file if not already created
        try {
            Files.createFile(contactFile);
        } catch (FileAlreadyExistsException e) {
            printContactsFromFile(passedArrList, filepath);
        } catch (IOException e) {
            System.out.println("createFile Exception: " + e.getMessage());
        }
    }

    public void printContactsFromFile(ArrayList<Contact> passedArrayList, String filepath) {
        List<String> fileStrings = new ArrayList<>(); //used to store the file strings into the format we want in order to create the contact objects to store in our arraylist
        Path contactFile = Paths.get(filepath);

        try {
            fileStrings = Files.readAllLines(contactFile);
        } catch (IOException e) {
            System.out.println("file read exception: " + e.getMessage());
        }

        for (String fileString : fileStrings) {
            Contact newContact = Contact.fromFileString(fileString);
            passedArrayList.add(newContact);
        }

        System.out.println("Your Contacts!");
        for (Contact contact: passedArrayList) {
            System.out.println(contact);
        }
        System.out.println();
    }
}
