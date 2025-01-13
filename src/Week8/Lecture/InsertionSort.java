package Week8.Lecture;

public class InsertionSort {

    // Function to perform insertion sort on an array
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i]; // Set the key to be swapped
            int j = i - 1;

            // Move elements of array[0...i-1], that are greater than the key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            // Place the key at its correct position
            array[j + 1] = key;
        }
    }

    // Function to print the elements of an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the insertion sort implementation
    public static void main(String[] args) {
        int[] array = { 5, 3, 4, 1 };

        System.out.println("Original Array:");
        printArray(array);

        // Perform insertion sort
        insertionSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }
}
