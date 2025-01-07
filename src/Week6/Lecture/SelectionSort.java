package Week6.Lecture;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;

        // Loop through the array, stopping at the second-to-last element
        for (int i = 0; i < n - 1; i++) {
            // Assume the current index is the smallest
            int minIndex = i;

            // Find the smallest element in the remaining unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Update the index of the smallest element
                }
            }

            // Swap the smallest element with the first unsorted element
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Original Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Sort the array using selection sort
        selectionSort(array);

        System.out.println("\n\nSorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
