package contactsManagerStephen;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsApplication {
    private static Input input = new Input();

    public static void main(String[] args) {
        getContactInfoFromFile();
        //load all contact by calling a method that returns a list of contact objects from txt file

        //show main menu and give user options

        //perform user choice by calling a method that alters the list

        //loop until the user decides to exit

        //once the user exits, re-write the contents of the txt file using the list of contact objects
    }

    private static void getContactInfoFromFile() {
        List<String> contactList = new ArrayList<>();
        Path contactFile = Paths.get("./contacts-manager-stephen-misael/contacts.txt");
        try {
            List<String> fileStrings = Files.readAllLines(contactFile);
            for (int i = 0; i < fileStrings.size(); i++) {

            }
        } catch (IOException e) {
            System.out.println("file read exception: " + e.getMessage());
        }
    }


}
