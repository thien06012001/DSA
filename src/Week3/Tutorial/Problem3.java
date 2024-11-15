package Week3.Tutorial;

public class Problem3 {
    public static void main(String[] args) {

    }
    public static void simulateATMQueue(int[] A, int[] D) {
        int totalPeople = A.length; // Number of people
        int[] waitingTimes = new int[totalPeople];
        int endTime = 0; // Tracks when the ATM becomes free

        for (int i = 0; i < totalPeople; i++) {
            // Calculate the waiting time for person i
            waitingTimes[i] = Math.max(0, endTime - A[i]);

            // Update the ATM's free time
            endTime = Math.max(endTime, A[i]) + D[i];
        }

        // Calculate maximum and average waiting times
        int maxWaitingTime = 0;
        int totalWaitingTime = 0;

        for (int time : waitingTimes) {
            maxWaitingTime = Math.max(maxWaitingTime, time);
            totalWaitingTime += time;
        }

        double avgWaitingTime = (double) totalWaitingTime / totalPeople;

        // Output the results
        System.out.println("Maximum Waiting Time: " + maxWaitingTime);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
    }

    public static void simulateATMQueue2(int[] A, int[] D){
        int n = A.length; // Number of people
        int currentTime = 0;
        int totalWaitingTime = 0;
        int maxWaitingTime = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] >= currentTime) {
                // No waiting
                currentTime = A[i] + D[i];
            } else {
                // Calculate waiting time
                int waitingTime = currentTime - A[i];
                totalWaitingTime += waitingTime;
                maxWaitingTime = Math.max(maxWaitingTime, waitingTime);
                // Update current time
                currentTime += D[i];
            }
        }

        // Calculate average waiting time
        double averageWaitingTime = (double) totalWaitingTime / n;

        // Output the results
        System.out.println("Maximum Waiting Time: " + maxWaitingTime);
        System.out.println("Average Waiting Time: " + averageWaitingTime);
    }
}
