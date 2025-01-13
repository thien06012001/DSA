package Week7.Lecture;

public class MergeSort {

    // Main mergeSort method
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort the first half
            mergeSort(array, left, mid);

            // Recursively sort the second half
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Merge method to combine two sorted subarrays
    public static void merge(int[] array, int left, int mid, int right) {
        // Sizes of two subarrays to be merged
        int size1 = mid - left + 1;
        int size2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // Copy data to temporary arrays
        for (int i = 0; i < size1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < size2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indexes of left, right, and merged subarrays
        int i = 0, j = 0, k = left;

        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[], if any
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[], if any
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Utility method to print an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Given Array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted Array:");
        printArray(array);
    }
}
