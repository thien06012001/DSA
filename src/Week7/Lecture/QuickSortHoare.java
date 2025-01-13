package Week7.Lecture;

public class QuickSortHoare {

    // Main quickSort method
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the partition index
            int pivotIndex = hoarePartition(array, low, high);

            // Recursively sort the two subarrays
            quickSort(array, low, pivotIndex);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Hoare partition method
    public static int hoarePartition(int[] array, int low, int high) {
        // Choose the pivot as the first element
        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Find the first element greater than or equal to the pivot from the left
            do {
                i++;
            } while (array[i] < pivot);

            // Find the first element less than or equal to the pivot from the right
            do {
                j--;
            } while (array[j] > pivot);

            // If two pointers meet or cross, return the partition index
            if (i >= j) {
                return j;
            }

            // Swap the two elements
            swap(array, i, j);
        }
    }

    // Utility method to swap elements in the array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Utility method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] array = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Given Array:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted Array:");
        printArray(array);
    }
}
