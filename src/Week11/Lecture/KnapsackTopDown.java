package Week11.Lecture;

public class KnapsackTopDown {
    // Global variables for weights, values, and memoization table
    static int[] weights;
    static int[] values;
    static int[][] memo;

    // Top-Down Knapsack function
    public static int MFKnapSack(int i, int j) {
        // Base case: If the value is already computed
        if (memo[i][j] >= 0) {
            return memo[i][j];
        }

        int result;

        if (i == 0 || j == 0) {
            // Base case: No items or capacity is 0
            result = 0;
        } else if (weights[i - 1] > j) {
            // Case: Current item's weight exceeds capacity
            result = MFKnapSack(i - 1, j);
        } else {
            // Case: Take the maximum of including or excluding the current item
            result = Math.max(
                    MFKnapSack(i - 1, j), // Exclude current item
                    values[i - 1] + MFKnapSack(i - 1, j - weights[i - 1]) // Include current item
            );
        }

        // Store the result in the memoization table
        memo[i][j] = result;

        return result;
    }

    public static void main(String[] args) {
        // Example input: number of items, capacity, weights, and values
        int n = 4; // Number of items
        int W = 5; // Knapsack capacity
        weights = new int[] { 2, 1, 3, 2 }; // Weights of the items
        values = new int[] { 12, 10, 20, 15 }; // Values of the items

        // Initialize memoization table
        memo = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1; // -1 indicates that the value has not been computed yet
            }
        }

        // Call the top-down knapsack function and print the result
        int maxProfit = MFKnapSack(n, W);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
