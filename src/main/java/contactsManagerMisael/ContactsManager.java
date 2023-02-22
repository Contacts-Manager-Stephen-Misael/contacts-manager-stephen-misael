package contactsManagerMisael;



import java.util.List;

public class ContactsManager {
    private final List<Contact> contacts;
    private final ContactsFile contactsFile;

    public ContactsManager() {
        contactsFile = new ContactsFile("contacts.txt");
        contacts = contactsFile.readContactsFromFile();
    }

    public void viewContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("A contact with that name already exists. Please choose a different name.");
        }
    }

    public void searchContactsByName(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts with that name were found.");
        }
    }

    public boolean deleteContact(Contact name) {
        Contact contactToDelete = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name.getName())) {
                contactToDelete = contact;
                break;
            }
        }
        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            return true;
        } else {
            return false;
        }
    }

    public void saveContactsToFile() {
        contactsFile.writeContactsToFile(contacts);
    }
}





//        ContactsManager class that is responsible for managing a list of Contact objects.
//        It has several methods for adding, viewing, searching, and deleting contacts, as well as saving them to a file.
//
//        The class has a private field contacts which is a list of Contact objects,
//        and another private field contactsFile of type ContactsFile which is responsible for reading and writing contacts to a file.
//
//        The ContactsManager constructor initializes the contactsFile object with the file name "contacts.txt"
//        and reads the contacts from the file using the readContactsFromFile() method.
//
//        The viewContacts() method iterates over the contacts list and prints each Contact object using its toString() method.
//
//        The addContact(Contact contact) method adds a new contact to the contacts list,
//        but only if a contact with the same name doesn't already exist.
//
//        The searchContactsByName(String name) method searches for contacts by name,
//        and prints any matching contacts using their toString() method. If no matching contacts are found, it prints a message to indicate that.
//
//        The deleteContact(Contact name) method deletes a contact from the contacts list by name, if it exists.
//        It returns true if the contact was successfully deleted, and false if no contact with that name was found.
//
//        The saveContactsToFile() method saves the current contacts list to the file using the writeContactsToFile() method of the contactsFile object.

