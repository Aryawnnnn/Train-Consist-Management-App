import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Example: Bogie collection (can be empty to test UC20)
        String[] bogieIDs = {}; // Empty array to simulate no bogies

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the Bogie ID to search:");
            String searchKey = scanner.nextLine();

            // Defensive check for empty train
            checkTrainNotEmpty(bogieIDs);

            // Example: choose linear search
            boolean found = linearSearch(bogieIDs, searchKey);

            if (found) {
                System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
            } else {
                System.out.println("Bogie ID " + searchKey + " was not found.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Search operation completed.");
            scanner.close();
        }
    }

    // UC20: Defensive check
    public static void checkTrainNotEmpty(String[] bogies) {
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Cannot perform search: No bogies in the train.");
        }
    }

    // Linear search for demonstration
    public static boolean linearSearch(String[] array, String key) {
        for (String id : array) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }
}