package Week2;

public class Lecture {
    public static void main(String[] args) {
    int[] A = {1,2,3,4,5};
    searchOneByOne(A,4);
    searchOneByOne(A,10);
    binarySearch(A,20);
    binarySearch(A,4);
    binarySearch(A,11);
    }

// Function to perform linear/sequential search
// Time complexity: O(n) for worst case scenario and O(1) for searching the element at index 0
    static void searchOneByOne(int[] arr, int num) {
        boolean found = false; // set the flag to false

        // Begin traversing the array
        for (int j : arr) {
            if (j == num) {
                found = true;
                break; // Stop searching if element is found
            }
        }
        if (found){
            System.out.println("Found");
        }
        else {
            System.out.println("Not Found");
        }

    }

    // Time complexity: O(logN), O(1) if it's the elem at the first middle index
    // To use this function, the array must be sorted first
    static void binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        boolean found = false;
        int index = 0;
        while(low <= high){
            // Formula to get middle index the safe way
            // Calculate low + high:
            // low + high = 1,500,000,000 + 2,000,000,000 = 3,500,000,000
            // Overflow Happens
            // The result, 3,500,000,000, is greater than the maximum value of an int in Java (2,147,483,647).
            // This causes integer overflow, and 3,500,000,000 wraps around to a negative value in Java.
            // Adding this result to low (which is already within the range) avoids overflow.
            int mid =  low + (high + low) / 2;
            if (target == arr[mid]){
                found = true;
                index = mid;
                break;
            }
            //If target is smaller, ignore right half
            if (target < arr[mid]) {
                // High takes the value after mid in the left half
                high = mid - 1;
            }
            //If target is greater, ignore the left half
            else {
                // Low takes the next value in the right half
                low = mid + 1;
            }
        }
        if(found){
            System.out.println("The element is in index " + index);
        }
        else  {
            System.out.println("Element not found.");
        }


    }
}
