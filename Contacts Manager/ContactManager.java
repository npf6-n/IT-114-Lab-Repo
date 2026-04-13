import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

    // --- TODO: REGEX HELPER METHOD ---
    public static String formatPhoneNumber(String raw) {

        String clean = raw.replaceAll("[^0-9]", "");

        if (clean.length() != 10) {
            return "Invalid Number";
        }

        clean = clean.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        return clean;
    }

    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();

        // Contacts to be sanitized and sorted
        contacts.add(new Contact("Zack Morris", "zack@bayside.edu", "555.123.4567"));
        contacts.add(new Contact("Alice Smith", "alice@test.com", "(555) 999-8888"));
        contacts.add(new Contact("Bob Jones", "bob@test.com", "5551112222"));

        System.out.println("--- Cleaning Data ---");

        // TODO: CLEAN DATA (Loop and Format)
        for (Contact c : contacts) {
            String formatted = formatPhoneNumber(c.getPhoneNumber());
            c.setPhoneNumber(formatted);
        }

        System.out.println("--- Sorting Data ---");
        // TODO: SORT DATA (Bubble Sort)
        int n = contacts.size();
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (contacts.get(j).getName().compareTo(contacts.get(j + 1).getName()) > 0) {

                    Contact temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }

        // Print sorted list
        for (Contact c : contacts) {
            System.out.println(c);
        }

        // Input name to search for
        System.out.println("\n--- Search ---");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a name to find: ");
        String searchName = scan.nextLine();
        boolean found = false;
        // TODO: Search Data for name inputted

        for (Contact c : contacts) {
            if (c.getName().equals(searchName)) {
                System.out.println("FOUND: " + c.toString());
                found = true;
            }
        }

        if (found == false) {
            System.out.println("Contact not found.");
        }

        scan.close();
    }
}
