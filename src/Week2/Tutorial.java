package Week2;

import java.util.Arrays;

public class Tutorial {
    public static void main(String[] args) {
        int[] arrivals = {100, 140, 150, 200, 215, 400};
        int[] departures = {110, 300, 220, 230, 315, 600};

        System.out.println("Minimum gates required: " + minGatesRequired(arrivals, departures));
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
}
