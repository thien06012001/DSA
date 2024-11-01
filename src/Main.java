//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 1, 3, 6, 9, 2, 4};
        rangeQueryAlgo1(0,8, arr);
    }
    public static void rangeQueryAlgo1(int L, int R, int[] arr) {
//        Set min with value at the first element in the array
        int min = arr[L];
//        Set start to the next index after L to iterate through the range
        int start = L + 1;
//        Loop through the array from start to R
        while(start <= R) {
//            Check if the min is bigger than the element at the index "start"
            if(min > arr[start]) {
//                Update min with this index "start" element
                min = arr[start];
            }
//            Move to the next index
            start++;
        }
//        Print out the minimum
        System.out.println(min);
    }
}