package contactsManagerMisael;


public class Contact {
    private final String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return formatPhoneNumber(phoneNumber);
    }


    @Override
    public String toString() {
        return String.format("%-20s| %-15s|", name, formatPhoneNumber(phoneNumber));
    }


    // This method updates the phone number of the Contact
    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }



    private String formatPhoneNumber(String phoneNumber) {
        // Remove any non-digit characters from the phone number
        String digits = phoneNumber.replaceAll("\\D", "");
        // Format the phone number with dashes
        return String.format("%s-%s-%s", digits.substring(0, 3), digits.substring(3, 6), digits.substring(6, 10));
    }
}





//        The class has two fields, name and phoneNumber, which represent the name and phone number of the contact, respectively.
//        The constructor takes these two values as arguments and initializes the corresponding fields.
//
//        The class has three methods:
//
//        getName(): This method returns the name of the contact.
//        getPhoneNumber(): This method returns the formatted phone number of the contact.
//        The phone number is formatted with dashes and any non-digit characters are removed.
//        toString(): This method overrides the default toString() method of the Object class and returns a formatted string representation of the Contact object.
//        The name and phone number of the contact are formatted into two columns with a width of 20 and 15 characters, respectively.
//        Additionally, the class has a private method formatPhoneNumber() which takes a string phoneNumber as an argument and returns the formatted phone number with dashes.
//        The method removes any non-digit characters from the phone number using a regular expression and formats the phone number into three groups of three digits separated by dashes.
//
//        The setPhoneNumber() method is also included, which updates the phone number of the Contact object.