package Week8.Tutorial;

public class P3 {
    public static void main(String[] args) {
        // compare the results of our Binary search square root
        // with the built-in square root function
        System.out.printf("\nBuilt-in sqrt(5): %.6f", Math.sqrt(5));
        System.out.printf("\nBinary search sqrt(5): %.6f", sqrt(5));

        System.out.printf("\nBuilt-in sqrt(101): %.6f", Math.sqrt(101));
        System.out.printf("\nBinary search sqrt(101): %.6f", sqrt(101));

        System.out.printf("\nBuilt-in sqrt(0.5): %.6f", Math.sqrt(0.5));
        System.out.printf("\nBinary search sqrt(0.5): %.6f", sqrt(0.5));
    }

    static double sqrt(double X) {
        double eps = 0.0000001; // Define the precision level
        double min = 0;
        double max = X;
        // if X is less than 1
        if (X < 1) {
            max = 1;
        }

         // Perform binary search to approximate the square root
        while (max - min > eps) {
            double mid = (min + max) / 2.0;

            // Check if the square of the midpoint is less than X
            if (mid * mid < X) {
                min = mid; // Update min to narrow down the range
            } else {
                max = mid; // Update max to narrow down the range
            }
        }
        // Return the result within the desired precision
        return max;
    }
}
