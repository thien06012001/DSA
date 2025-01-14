package Week7.Tutorial;

public class P3 {
    public static void main(String[] args) {
        int[] test1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        // inversion = 0
        System.out.println(InversionBruteforce.count(test1));
        System.out.println(InversionDivideConquer.count(test1));

        int[] test2 = new int[] { 1, 2, 3, 4, 5, 6, 8, 7 };
        // inversion = 1
        System.out.println(InversionBruteforce.count(test2));
        System.out.println(InversionDivideConquer.count(test2));

        int[] test3 = new int[] { 5, 4, 3, 2, 1 };
        // inversion = 10
        System.out.println(InversionBruteforce.count(test3));
        System.out.println(InversionDivideConquer.count(test3));

        // correctness test
        int SIZE = 2000;
        int[] test4 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            test4[i] = (int) (Math.random() * SIZE + 1);
        }
        System.out.println(InversionBruteforce.count(test4));
        System.out.println(InversionDivideConquer.count(test4));

        // performance test
        SIZE = 200000;
        int[] test5 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            test5[i] = (int) (Math.random() * SIZE + 1);
        }
        long t1 = System.currentTimeMillis();
        System.out.println(InversionBruteforce.count(test5));
        System.out.println("Brute force time: " + (System.currentTimeMillis() - t1));
        t1 = System.currentTimeMillis();
        System.out.println(InversionDivideConquer.count(test5));
        System.out.println("Divide and Conquer time: " + (System.currentTimeMillis() - t1));
    }
}
/**
     * Counts the number of inversions in the array using a brute force approach.
     * An inversion is a pair of indices (i, j) such that i < j and arr[i] > arr[j].
     * This approach checks all possible pairs.
     * 
     * Time Complexity: O(N^2), where N is the length of the array.
     * 
     * @param arr The input array.
     * @return The number of inversions in the array.
     */
class InversionBruteforce {
    static int count(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) { // Check if an inversion exists
                    res++;
                }
            }
        }
        return res; // Return the total inversion count
    }
}

class InversionDivideConquer {
    /**
     * Counts the number of inversions in the array using a divide-and-conquer approach.
     * This method divides the array into two halves, counts inversions in each half recursively,
     * and counts inversions between the two halves during the merge step.
     * 
     * Time Complexity: O(N log N), where N is the length of the array.
     * 
     * @param arr The input array.
     * @return The number of inversions in the array.
     */
    static int count(int[] arr) {
        int res = 0;
        if (arr.length == 1) { // Base case: single-element array has no inversions
            return res;
        }
        int mid = arr.length / 2;
         // Split the array into left and right halves
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
         // Recursively count inversions in the left and right halves
        res = count(left) + count(right);
        // Count and merge inversions between the two halves
        res += merge(left, right, arr);

        return res; // Return the total inversion count
    }
 /**
     * Merges two sorted arrays (left and right) into a destination array, while counting inversions.
     * During the merge, inversions are counted when an element from the right array is placed
     * before an element from the left array.
     * 
     * @param left The left subarray (sorted).
     * @param right The right subarray (sorted).
     * @param dest The destination array where the merged result is stored.
     * @return The number of inversions found during the merge.
     */
    static int merge(int[] left, int[] right, int[] dest) {
        int res = 0;
        int pLeft = 0, pRight = 0, pDest = 0; // Pointers for left, right, and destination arrays

         // Merge the arrays while counting inversions
        while (pLeft < left.length && pRight < right.length) {
            if (left[pLeft] <= right[pRight]) {
                dest[pDest] = left[pLeft]; // Take element from the left array
                pDest++;
                pLeft++;
            } else {
                dest[pDest] = right[pRight]; // Take element from the right array
                pDest++;
                pRight++;
                res += left.length - pLeft; // Count inversions: remaining elements in the left array
            }
        }
        while (pLeft < left.length) { // Copy remaining elements from the left array (if any)
            dest[pDest++] = left[pLeft++];
        }
        while (pRight < right.length) { // Copy remaining elements from the right array (if any)
            dest[pDest++] = right[pRight++];
        }
        return res; // Return the inversion count from the merge step
    }
}