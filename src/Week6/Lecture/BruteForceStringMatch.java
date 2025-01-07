package Week6.Lecture;

public class BruteForceStringMatch {

    public static int bruteForceStringMatch(String text, String pattern) {
        int n = text.length(); // Length of the text
        int m = pattern.length(); // Length of the pattern

        // Outer loop to slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // Inner loop to check for a match
            while (j < m && pattern.charAt(j) == text.charAt(i + j)) {
                j++;
            }

            // If we have matched all characters of the pattern
            if (j == m) {
                return i; // Return the starting index of the match
            }
        }

        return -1; // No match found
    }

    public static void main(String[] args) {
        String text = "THIS IS A TEST TEXT";
        String pattern = "TEST";

        int result = bruteForceStringMatch(text, pattern);

        if (result != -1) {
            System.out.println("Pattern found at index: " + result);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
