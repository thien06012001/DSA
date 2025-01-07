package Week6.Lecture;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;

        // Outer loop to control the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop to perform comparisons and swaps
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap adjacent elements if they are in the wrong order
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Sort the array using bubble sort
        bubbleSort(array);

        System.out.println("\n\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
