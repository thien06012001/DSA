package Week8.Lecture;

public class RecursiveBinarySearch {

    // Recursive Binary Search function
    public static int binarySearch(int[] array, int left, int right, int key) {
        // Base case: if the search range is invalid
        if (left > right) {
            return -1; // Key not found
        }

        // Calculate the middle index
        int mid = left + (right - left) / 2; // Avoids overflow compared to (left + right) / 2

        // Check if the key is present at the middle
        if (array[mid] == key) {
            return mid; // Key found, return its index
        }

        // If the key is smaller than the middle element, search the left subarray
        if (key < array[mid]) {
            return binarySearch(array, left, mid - 1, key);
        }

        // Otherwise, search the right subarray
        return binarySearch(array, mid + 1, right, key);
    }

    // Main method to test the recursive binary search
    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 11 }; // Sorted array
        int key = 11; // Key to search
        int n = array.length;

        int result = binarySearch(array, 0, n - 1, key);

        if (result != -1) {
            System.out.println("Key " + key + " found at index " + result);
        } else {
            System.out.println("Key " + key + " not found in the array");
        }
    }
}
