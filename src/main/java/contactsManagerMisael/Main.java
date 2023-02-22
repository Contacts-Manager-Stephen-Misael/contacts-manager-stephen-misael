package contactsManagerMisael;

public class Main {
    public static void main(String[] args) {
        ContactsApp contactsApp = new ContactsApp();
        contactsApp.run();
    }
}





//        Create a new Java project.
//        Create a Contact class with private fields for name and phone number, and getter and setter methods for both fields.
//        Also create a toString() method to display a contact's information in a formatted string.
//        Create a ContactsFile class to read and write contacts from and to a file.
//        Use a File object to represent the file, and use a Scanner to read from the file and a PrintWriter to write to the file. The readContactsFromFile
//        () method should return a List<Contact> object containing all contacts in the file,
//        and the writeContactsToFile() method should take a List<Contact> object and write each contact to the file in a specific format.
//        Create a ContactsManager class to manage contacts. This class should have a List<Contact> object to store all contacts,
//        and it should use the ContactsFile class to read and write contacts to and from a file. This class should also have methods to view all contacts,
//        add a new contact, search for a contact by name, and delete a contact.
//        Create a ContactsMenu class to display a menu of options to the user and get user input.
//        This class should have methods to display a main menu, get user input for a new contact,
//        get user input to search for a contact by name, and get user input for a contact to delete.
//
//        Create a Main class with a main() method that creates a new ContactsApp object and calls its run() method to start the program.
//






//        Main in the ContactsManager package. It contains a main method which serves as the entry point of the program.
//
//        In the main method, a new instance of the ContactsApp class is created and assigned to a variable called contactsApp.
//        The run() method of the contactsApp object is then called.
//
//        The ContactsApp class is not shown in this code snippet, but it likely contains the functionality for managing contacts,
//        such as adding, deleting, and searching for contacts.
//        The run() method is probably the method that starts the application and displays the user interface.






//        import java.io.File;
//        This line is an import statement that brings in the File class from the java.io package.
//        The File class provides methods for working with files and directories on the file system.
//
//        import java.io.IOException;
//        This line is another import statement that brings in the IOException class from the java.io package.
//        IOException is a checked exception that can be thrown when there is an error while working with input/output operations, such as reading or writing to files.
//
//        import java.util.ArrayList;
//        This line is an import statement that brings in the ArrayList class from the java.util package.
//        ArrayList is a class that provides a resizable array implementation, allowing you to store and manipulate collections of objects.
//
//        import java.util.List;
//        This line is an import statement that brings in the List interface from the java.util package.
//        List is an interface that represents an ordered collection of elements, and provides methods for adding, removing, and accessing elements in the list.
//
//        import java.util.Scanner;
//        This line is an import statement that brings in the Scanner class from the java.util package.
//        Scanner is a class that provides methods for parsing input data from various sources, including files, console input, and strings.