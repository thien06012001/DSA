package Week2;

import java.util.Arrays;

public class Tutorial {
    public static void main(String[] args) {
        int[] arrivals = {100, 140, 150, 200, 215, 400};
        int[] departures = {110, 300, 220, 230, 315, 600};

        System.out.println("Minimum gates required: " + minGatesRequired(arrivals, departures));

        int[] arr1 = {2, 3, 9, 6};
        int[] arr2 = {-100, 50, -52, 99};

        System.out.println("Closest to zero in arr1: " + Arrays.toString(findClosestSumToZero(arr1)));
        System.out.println("Closest to zero in arr2: " + Arrays.toString(findClosestSumToZero(arr2)));
    }
    public static int minGatesRequired(int[] arrivals, int[] departures) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int maxGates = 0;
        int currentGate = 0;
        int i = 0, j =0;
        int n = arrivals.length;
        while(i < n && j <n) {
            if(arrivals[i] <= departures[j]) {
                currentGate++;
                maxGates = Math.max(maxGates, currentGate);
                i++;
            } else {
                currentGate--;
                j++;
            }
        }
        return maxGates;
    }

    public static int[] findClosestSumToZero(int[] arr) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int[] closestPair = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                closestPair[0] = arr[left];
                closestPair[1] = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return closestPair;
    }
}
