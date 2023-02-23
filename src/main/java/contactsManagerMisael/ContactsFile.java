package contactsManagerMisael;

import colors.Colors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactsFile {
    private final File file;

    public ContactsFile(String fileName) {
        this.file = new File(fileName);
    }

    public List<Contact> readContactsFromFile() {
        List<Contact> contacts = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] contactData = scanner.nextLine().split("\\|");
                Contact contact = new Contact(contactData[0].trim(), contactData[1].trim());
                contacts.add(contact);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the contacts file: " + e.getMessage());
            System.out.println(Colors.red + "The contact could not be found." + Colors.reset + e.getMessage());
        }
        return contacts;
    }

    public void writeContactsToFile(List<Contact> contacts) {
        try {
            file.createNewFile();
            java.io.PrintWriter writer = new java.io.PrintWriter(file);
            for (Contact contact : contacts) {
                writer.println(contact.getName() + " | " + contact.getPhoneNumber());
            }
            writer.close();
        } catch (IOException e) {
//            System.out.println("An error occurred while writing to the contacts file: " + e.getMessage());
            System.out.println(Colors.red + "An error occurred while writing to the contacts file:" + Colors.reset + e.getMessage());


        }
    }
}





//       class ContactsFile that is used for reading and writing contacts information to a file.
//       The class contains two methods: readContactsFromFile() and writeContactsToFile().
//
//        The readContactsFromFile() method reads contacts information from a file and returns a list of Contact objects.
//        It creates a new File object using the specified file name and uses a Scanner to read the contents of the file.
//        It then loops through each line of the file and splits it using the pipe character |.
//        It creates a new Contact object with the name and phone number obtained from the split string and adds it to a list of contacts.
//        If an IOException occurs, it prints an error message.
//
//        The writeContactsToFile() method writes a list of Contact objects to a file.
//        It first creates a new file with the specified file name using the createNewFile() method.
//        It then uses a PrintWriter object to write each contact to the file in the format name | phone number.
//        If an IOException occurs, it prints an error message.