package contactsManagerStephen;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(String firstName) {
        this.firstName = firstName;
    }

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, formatPhoneNumber(phoneNumber));
    }

    public String toFileString() {
        return String.format("%s,%s,%s", firstName, lastName, phoneNumber);
    }

    public static Contact fromFileString(String fileContact) {
        String[] contactPieces = fileContact.split(",");
        Contact contact = new Contact(contactPieces[0]);
        contact.setLastName(contactPieces[1]);
        contact.setPhoneNumber(contactPieces[2]);
        return contact;
    }

    public String formatPhoneNumber(String phoneNumber) {
        String first3 = phoneNumber.substring(0, 3);
        String second3 = phoneNumber.substring(3, 6);
        String last4 = phoneNumber.substring(6,9);
        return first3 + "-" + second3 + "-" + last4;
    }

    //accessors

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
