import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Sorted array of bogie IDs
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        Arrays.sort(bogieIDs); // Ensure sorted for binary search

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIDs) {
            System.out.print(id + " ");
        }
        System.out.println("\nEnter the Bogie ID to search:");
        String searchKey = scanner.nextLine();

        boolean found = binarySearch(bogieIDs, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " was not found.");
        }

        scanner.close();
    }

    // Binary search method for strings
    public static boolean binarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(array[mid]);

            if (cmp == 0) {
                return true; // Found
            } else if (cmp < 0) {
                high = mid - 1; // Search left half
            } else {
                low = mid + 1; // Search right half
            }
        }
        return false; // Not found
    }
}