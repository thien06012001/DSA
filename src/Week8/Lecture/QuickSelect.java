package Week8.Lecture;

public class QuickSelect {

    // QuickSelect function to find the k-th smallest element
    public static int quickSelect(int[] arr, int k, int left, int right, int count) {
        System.out.println("Recursive " + count);
        System.out.println("Left: " + left + " Right: " + right);
        if (left <= right) {

            // Partition the array using Lomuto partition scheme
            int partitionIndex = partition(arr, left, right);
            System.out.println("Partition Index: " + partitionIndex);
            // If the partition index matches the k-th position, return the element
            if (partitionIndex + 1 == k) {
                return arr[partitionIndex];
            }

            // If k is in the right part
            if (partitionIndex + 1 < k) {
                return quickSelect(arr, k, partitionIndex + 1, right, count + 1);
            }

            // If k is in the left part
            return quickSelect(arr, k, left, partitionIndex - 1, count + 1);
        }

        return -1; // Edge case, should not happen for valid inputs
    }

    // Lomuto partition scheme
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            System.out.println("j: " + j);
            if (arr[j] <= pivot) {
                i++;
                System.out.println("i: " + i);
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("Final i: " + i);
        System.out.print("Array after for loop: ");
        for (int a : arr) {
            System.out.print(a);
        }
        System.out.println();
        // Swap arr[i + 1] and arr[right] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        System.out.print("Array after swapping: ");
        for (int a : arr) {
            System.out.print(a);
        }
        System.out.println();
        return i + 1; // Return the partition index
    }

    // Main method to test the QuickSelect implementation
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 5, 4 };
        int k = 3; // Find the 3rd smallest element
        int count = 1;
        int result = quickSelect(arr, k, 0, arr.length - 1, count);

        if (result != -1) {
            System.out.println("The " + k + "-th smallest element is: " + result);
        } else {
            System.out.println("Invalid input.");
        }
    }
}
