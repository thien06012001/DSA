public class Week1 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 1, 3, 6, 9, 2, 4};
        rangeQueryAlgo1(0, 8, arr);
        rangeQueryAlgo2(0, 8, arr);
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
}
