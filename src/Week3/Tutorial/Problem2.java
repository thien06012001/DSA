package Week3.Tutorial;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        n5.next = n1; // Make it circular

        int step = 2;

        josephusProblem(step, n1);
    }



    static void josephusProblem(int step, Node start) {
        // Ensure the circular linked list is not empty
        if (start == null) return;

        List<Integer> result = new ArrayList<>();
        System.out.println("Original Order:");
        Node currentNode = start;
        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != start);

        System.out.println();

        // Start the Josephus process
        Node current = start;
        Node prev = null;

        while (current.next != current) { // Until only one node is left
            // Move (step - 1) times to find the node to remove
            for (int i = 1; i < step; i++) {
                prev = current;
                current = current.next;
            }
            // Remove the current node
            System.out.println("Eliminating: " + current.data);
            result.add(current.data);
            prev.next = current.next; // Skip the current node
            current = prev.next; // Move to the next node
        }

        // Add the last person to be killed
        result.add(current.data);
        current.next = null;
        System.out.println("The elimination order is: " + result);
        System.out.println("The last person to be killed is: " + current.data);
    }
}

