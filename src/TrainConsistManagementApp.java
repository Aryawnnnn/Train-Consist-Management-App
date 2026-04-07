public class BubbleSortPassengerBogies {
    public static void main(String[] args) {
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original capacities:");
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }
        System.out.println();

        // Bubble Sort implementation
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap capacities[j] and capacities[j+1]
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted capacities (ascending order):");
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }
        System.out.println();
    }
}