package Week1;

public class Lecture {
    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 1, 3, 6, 9, 2, 4};
//        rangeQueryAlgo1(0, 8, arr);
//        rangeQueryAlgo2(0, 8, arr);
        rangeQueryAlgo3(0, 7, arr);
    }

    //    Find the minimum value in the range query
//    Complexity: O(n) -> If we have 1 millions inputs, it will cost 1 millions operations
//    Example: Array size = 1M; Query amount: 1M => Cost of operations = 1M x 1M
    public static void rangeQueryAlgo1(int L, int R, int[] arr) {
//        L: start of range; R: end of range; arr: input array
//        Set min with value at the index "L" element in the array
        int min = arr[L];
//        Set start to the next index after L to iterate through the range
        int start = L + 1;
//        Loop through the array from start to R
        while (start <= R) {
//            Check if the min is bigger than the element at the index "start"
            if (min > arr[start]) {
//            Update min with this index "start" element
                min = arr[start];
            }
//            Move to the next index
            start++;
        }
//        Print out the minimum
        System.out.println(min);
    }
    //    Find the minimum value in the range query
// Time complexity for the precomputed table is O(n^2)
// For retrieving the minimum value, it's O(1) because searching for an element in an array takes constant time
// Example: Array size = 1M; Query amount: 1M => Cost of operations = 1 x 1M
    public static void rangeQueryAlgo2(int L, int R, int[] arr) {
//      Set N equal to the array length
        int N = arr.length;
//       Initialize a 2D array min with the size of N
        int[][] min = new int[N][N];
//        Teacher code
//      Creation of a Lookup table with a for loop
        for (int i = 0; i <= N - 1; i++) {
//      Add the array value in the 2D array
            min[i][i] = arr[i];
        }
//      Nested for loop to add the minimum value in the array
        for (int i = 0; i <= N - 2; i++) {
            // fill the missing values
            for (int j = i + 1; j <= N - 1; j++) {
                min[i][j] = Math.min(min[i][j - 1], arr[j]);
            }
        }
//        Ha code
        // Precompute minimum values for each possible subarray [i, j]
        for (int i = 0; i < N; i++) {
            // The minimum of a subarray [i, i] (single element) is the element itself
            min[i][i] = arr[i];

            // For each starting point i, calculate minimum for subarrays ending at j > i
            for (int j = i + 1; j < N; j++) {
                // Find the minimum value in the range from index i to j
                // min[i][j] = minimum of the previous minimum value (min[i][j-1]) and arr[j]
                min[i][j] = Math.min(min[i][j - 1], arr[j]);
            }
            System.out.println(min[L][R]);
        }
    }

    // Find the minimum value in the range query using Sparse Table preprocessing
// Time complexity for precomputing the table is O(n * log(n))
// For retrieving the minimum value, it’s O(1) due to constant time lookup
// Example: Array size = 1M; Query amount: 1M => Cost of operations = 1M * log(1M) + 1M
    public static void rangeQueryAlgo3(int L, int R, int[] arr) {
        // L: start of range; R: end of range; arr: input array
        // Set N equal to the array length
        int N = arr.length;
        // Calculate the maximum power of 2 needed for ranges up to N
        int logN = (int) (Math.log(N) / Math.log(2)) + 1;
        // Initialize a 2D array MQR to store minimum values for each range length
        // Storage is reduced by storing only the minimum values for ranges of size powers of 2 (1, 2, 4, 8, ...)
        // Instead of storing minimums for all possible subarrays, which would require O(n^2) space,
        // we use O(n * log(n)) space by only keeping minimums for intervals of length 2^j, where j is a power of 2.
        int[][] MQR = new int[N][logN];

        // Populate the sparse table for ranges of size 1 (j = 0)
        for (int i = 0; i < N; i++) {
            // Each element in the array is the minimum for its range of size 1
            MQR[i][0] = arr[i];
        }

        // Precompute minimum values for ranges of size `2^j` for j > 0
        for (int j = 1; (1 << j) <= N; j++) { // `1 << j` is equivalent to `2^j`
            // For each starting index i, compute the minimum for the range [i, i + 2^j - 1]
            for (int i = 0; (i + (1 << j) - 1) < N; i++) {
                // Calculate the minimum for range size `2^j` using overlapping intervals
                MQR[i][j] = Math.min(MQR[i][j - 1], MQR[i + (1 << (j - 1))][j - 1]);
            }
        }

        // Calculate the length of the query range [L, R]
        int rangeLength = R - L + 1;
        // Calculate the largest power of 2 that fits within the range
        int rangePower = (int) (Math.log(rangeLength) / Math.log(2));

        // Retrieve the minimum by comparing the two overlapping ranges
        int minVal = Math.min(MQR[L][rangePower], MQR[R - (1 << rangePower) + 1][rangePower]);

        // Print the result for the minimum value in the range [L, R]
        System.out.println("Minimum value in range [" + L + ", " + R + "] is: " + minVal);
    }



}
