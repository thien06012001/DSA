package Week1;
import java.util.HashSet;
import java.util.Set;
public class Tutorial {
    public static void main(String[] args) {
        //Problem 1
        int[] A = {7,6,9,3,2,5};
        System.out.println(findLargest(A));
        System.out.println(findSecondLargest(A));
        //Problem 2
        int[] B = {1,5,2,4,3};
        int[] C = {0,3,2,4,1};
        System.out.println(findMissingValue(B));
        System.out.println(findMissingValue(C));
        //Problem 3
        Sequence seq1 = new Sequence(new int[]{1,2,3,4});
        Sequence seq2 = new Sequence(new int[]{4,3,2,1});
        Sequence seq3 = new Sequence(new int[]{1,2,3});
        Sequence seq4 = new Sequence(new int[]{1,2,4});
        System.out.println(arePermutations(seq1,seq2));
        System.out.println(arePermutations(seq3,seq4));

        // Problem 4
        int[] myArray = {6, 2, 9, 8, 5, 4, 3};  // Sample array for testing

        // Compute the prefix sum array once for the input array A
        int[] prefixSum = computePrefixSum(myArray);

        // Test cases for range sum queries
        System.out.println("rangeSum(0, 0) => " + rangeSum(prefixSum, 0, 0)); // Expected output: 6 (myArray[0] to myArray[0])
        System.out.println("rangeSum(6, 6) => " + rangeSum(prefixSum, 6, 6)); // Expected output: 3 (myArray[6] to myArray[6])
        System.out.println("rangeSum(0, 6) => " + rangeSum(prefixSum, 0, 6)); // Expected output: 37 (myArray[0] to myArray[6])
        System.out.println("rangeSum(3, 4) => " + rangeSum(prefixSum, 3, 4)); // Expected output: 13 (myArray[3] to myArray[4])
    }
//  Find the largest value in a given array
    public static int findLargest(int[] arr){
//  Initialize max to the first index of the array
        int max = arr[0];
        int N = arr.length;
//  Loop through the array
        for(int i = 1; i < N; i++ ){
//  Compare the max value with the array value
            if(arr[i] > max){
//  Set the array value as the new maximum if true
                max = arr[i];
            }
        }
//  Return the maximum value
        return max;
    }

// Find the second largest value in a given array
    public static int findSecondLargest(int[] arr){
//  Initialize largest and secondLargest
        int largest;
        int secondLargest;
//  Compare value of index 0 and index 1
        if (arr[0] > arr[1]) {
//  If value of index 0 is larger, it is set as the largest and value of index 1 set as the secondLargest
            largest = arr[0];
            secondLargest = arr[1];
        }
        else {
//  Otherwise, do the opposite
            largest = arr[1];
            secondLargest = arr[0];
        }
//  Loop through the array starting from i = 2 to the last index because we already compared the two first values
        for(int i = 2; i < arr.length; i++){
//  Compare if any values is bigger than the current largest value
            if (largest < arr[i]) {
//  If yes, set the current largest as the secondLargest and the new value as the new largest
                secondLargest = largest;
                largest = arr[i];
//  Otherwise, check if any values is larger than the secondLargest
            } else if (secondLargest < arr[i]) {
//  If yes, set the value as the new second largest
                secondLargest = arr[i];
            }
        }
//  Return the second largest value as a result
        return secondLargest;
    }
//  Find missing value of an array with consecutive numbers 0 to N
    public static int findMissingValue(int[] arr){
        int N = arr.length;
        int sumArr = 0;
//  Formula to calculate the sum of an array
        int sumWithoutMissing = N * (N + 1) / 2;
        // Cach 1
//  Get the total of the array with missing value
        for(int i = 0; i < N - 1; i++){
            sumArr += arr[i];
        }
//  Substract the sum of the complete array with the missing array to get the missing value
        return sumWithoutMissing - sumArr;

        // Cach 2
//        for(int i = 0; i < N - 1; i++){
//            sumWithoutMissing -= arr[i];
//        }
//        return sumWithoutMissing;

    }

    static class Sequence{
        public int[] elements;
        public int currentIndex;

        public Sequence(int[] elements){
            this.elements = elements;
            this.currentIndex = 0;
        }
//  Return the elements of the Sequence from 0 to the last one
        public Integer next(){
            if(currentIndex < elements.length){
                return elements[currentIndex++];
            }
            return null; // No more elements
        }
    }
// Check whether the two sequences are permutations of the same set
    public static boolean arePermutations(Sequence seq1, Sequence seq2){
//  Create new set 1
        Set<Integer> set1 = new HashSet<>();
//  Set e (elements) as Integer
        Integer e;
//  Add the values of seq 1 to set 1
        while((e = seq1.next()) != null){
            set1.add(e);
        }
//  Go through seq 2
    while((e = seq2.next()) != null){
//  Get the old size of set 1
        int oldSize = set1.size();
//  If the element in seq 2 exists in set 1 remove it
        set1.remove(e);
//  Get the new size of set 1 after successful removal or not
        int newSize = set1.size();
//  If the old size equals to the new Size : element exists in seq 2 but not in set 1
        if(oldSize == newSize){
            return false;
        }
    }
//  If any elements remain in set1 : element exists in set 1 but not in seq 2
        return set1.isEmpty();
    }


// Find the sum of a range query in an array
    /**
     * Computes the prefix sum array for a given input array.
     * The prefix sum at index `i` represents the sum of all elements from index 0 to i in the original array.
     *
     * This allows us to calculate the sum of any sub-array in constant time later on.
     * In other words, prefixSum[i] = A[0] + A[1] + A[2] + ... + A[i]
     * @param A The input array containing the original values.
     * @return The prefix sum array, where each element at index `i` contains the sum of elements from A[0] to A[i].
     */
    public static int[] computePrefixSum(int[] A) {
        int N = A.length;               // Get the length of the input array
        int[] prefixSum = new int[N];    // Initialize the prefix sum array of the same length as A
        // Set the first element of prefixSum to be the first element of A
        // This is because the sum from A[0] to A[0] is just A[0] itself
        prefixSum[0] = A[0];

        // Calculate prefix sums for each index from 1 to N-1
        for (int i = 1; i < N; i++) {
            // Each prefix sum is the previous prefix sum plus the current element in A
            // This accumulates the sum of elements from A[0] to A[i]
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        // Return the fully computed prefix sum array
        return prefixSum;
    }

    /**
     * Returns the sum of elements in a specified sub-array range [L, R] using the prefix sum array.
     * This function relies on the precomputed prefix sum array to calculate the range sum in O(1) time.
     *
     * @param prefixSum The prefix sum array, where each element at index `i` contains the sum of elements from A[0] to A[i].
     * @param L The starting index of the range (inclusive).
     * @param R The ending index of the range (inclusive).
     * @return The sum of the sub-array A[L] to A[R].
     */
    public static int rangeSum(int[] prefixSum, int L, int R) {
        // If the range starts from the beginning of the array (L == 0),
        // the sum from A[0] to A[R] is simply the value at prefixSum[R]
        if (L == 0) {
            return prefixSum[R];
        }

        // For any other range, the sum from A[L] to A[R] can be calculated as:
        // prefixSum[R] - prefixSum[L - 1]
        // This subtracts the sum of elements from A[0] to A[L - 1], leaving only the sum from A[L] to A[R]
        return prefixSum[R] - prefixSum[L - 1];
    }
}
