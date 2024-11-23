package MidtermPractice;

import Week3.Lecture.ArrayQueue;

public class Practice1 {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        // enqueue 1 to 9
        for (int i = 1; i <= 9; i++) {
            queue.enQueue(i);
        }
        reverseQueue(3, queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.peekFront() + " ");
            queue.deQueue();
        }
    }

    // Reverse the first k elems in the queue
    public static void reverseQueue(int k, ArrayQueue<Integer> queue) {
        int n = queue.size();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = queue.peekFront();
            queue.deQueue();
        }

        // Take the k elems in the temporary array, enqueue to the queue in reverse order
        for(int j = k-1; j >=0; j--) {
            queue.enQueue(arr[j]);
        }

        for(int h = k; h < arr.length; h++){
            queue.enQueue(arr[h]);
        }
    }

}
