package Week8.Tutorial;

public class P1 {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        // correctness test
        System.out.println("Power brute force: " + powerBruteForce(2, 100));
        System.out.println("Power decrease conquer: " + powerFast(2, 100));

        System.out.println("Power brute force: " + powerBruteForce(7, 10001));
        System.out.println("Power decrease conquer: " + powerFast(7, 10001));

        // performance test
        long t1 = System.nanoTime();
        System.out.println("Power brute force: " + powerBruteForce(201, 500000000));
        System.out.println("Time: " + (System.nanoTime() - t1));

        long t2 = System.nanoTime();
        System.out.println("Power decrease conquer: " + powerFast(201, 500000000));
        System.out.println("Time: " + (System.nanoTime() - t2));
    }
    /**
     * Efficient method to compute X^N % MOD using the "decrease and conquer" approach.
     * This implementation uses exponentiation by squaring to achieve O(log N) time complexity.
     *
     * @param X Base of the power
     * @param N Exponent
     * @return Result of (X^N) % MOD
     **/
    /* who is this diva */
    static int powerFast(int X, int N) {
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return X;
        }
        long sub = powerFast(X, N / 2);
        sub = (sub * sub) % MOD;
        if (N % 2 == 1) {
            return (int) ((sub * X) % MOD);
        }
        return (int) sub;
    }
 /**
     * Naive method to compute X^N % MOD using a brute force approach.
     * This implementation uses a loop to compute the result in O(N) time complexity.
     *
     * @param X Base of the power
     * @param N Exponent
     * @return Result of (X^N) % MOD
     **/
    static int powerBruteForce(int X, int N) {
        long res = 1;
        for (int i = 0; i < N; i++) {
            res = (res * X) % MOD;
        }
        return (int) res;
    }
}