public class Week1 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 1, 3, 6, 9, 2, 4};
        rangeQueryAlgo1(0, 8, arr);
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

    public static void rangeQueryAlgo2(int L, int R, int[] arr) {}
}
