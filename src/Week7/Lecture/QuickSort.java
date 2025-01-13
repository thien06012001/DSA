package Week7.Lecture;

public class QuickSort {

    // Main quickSort method
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = lomutoPartition(array, low, high);

            // Recursively sort elements before and after the pivot
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Lomuto partition method
    public static int lomutoPartition(int[] array, int low, int high) {
        // Choose the last element as the pivot
        int pivot = array[high];
        int i = low - 1; // Pointer for elements less than the pivot

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap elements
                swap(array, i, j);
            }
        }

        // Place the pivot in the correct position
        swap(array, i + 1, high);
        return i + 1; // Return the index of the pivot
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
        int[] array = { 10, 80, 30, 90, 40, 50, 70 };
        System.out.println("Given Array:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted Array:");
        printArray(array);
    }
}
