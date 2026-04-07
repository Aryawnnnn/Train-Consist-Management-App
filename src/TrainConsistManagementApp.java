import java.util.Scanner;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Array of bogie IDs (unsorted)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.print(id + " ");
        }
        System.out.println("\nEnter the Bogie ID to search:");
        String searchKey = scanner.nextLine();

        boolean found = false;
        // Linear search
        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                found = true;
                break; // stop at first match
            }
        }

        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " was not found.");
        }

        scanner.close();
    }
}