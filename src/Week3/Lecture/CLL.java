package Week3.Lecture;

class CNode {
    int data;
    CNode next;

    public CNode(int data) {
        this.data = data;
        this.next = this;
    }
}

public class CLL {
    int size;
    CNode first;

    public CLL() {
        this.size = 0;
        this.first = null;
    }

    // Initialize a new CLL with a node
    public CLL(CNode head) {
        this.size = 1;
        this.first = head;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    public CNode getLastNode() {
        if (isEmpty()) {
            return null;
        }

        CNode current = this.first;
        while (current.next != first) {
            current = current.next;
        }

        return current;
    }

    public void addNode(int data) {
        CNode newNode = new CNode(data);
        if (isEmpty()) {
            first = newNode;
            newNode.next = first;
        } else {
            CNode lastNode = this.getLastNode();
            lastNode.next = newNode;
            newNode.next = first;
        }
        size++;
    }

    public void addNode2(CNode newNode) {
        if (isEmpty()) {
            first = newNode;
            newNode.next = first;
        } else {
            CNode lastNode = this.getLastNode();
            lastNode.next = newNode;
            newNode.next = first;
        }
        size++;
    }

    public void addAfter(CNode before, int data) {
        if (isEmpty()) {
            System.out.println("List is empty");
        }

        CNode current = first;

        do {
            if (current == before) {
                CNode newNode = new CNode(data);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return;
            }
            current = current.next; // Continue until meet the node to be inserted after
        } while (current != first);
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot remove.");
            return;
        }

        if (first.next == first) { // Only one node
            first = null;
        } else {
            CNode current = first;
            // Traverse to the second last node
            while (current.next.next != first) {
                current = current.next;
            }

            current.next = first; // Remove last node
            size--;
        }
    }

        public void removeFirst() {
            if (isEmpty()) {
                System.out.println("List is empty. Cannot remove.");
                return;
            }

            if (first.next == first) { // Only one node
                first = null;
            } else {
                CNode last = getLastNode();
                first = first.next;     // Update first to second node
                last.next = first;      // Maintain circularity
            }
            size--;
        }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        CNode current = first; // Start from first
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != first);
        System.out.println(first.data);
    }


    public static void main(String[] args) {
        CLL list = new CLL(new CNode(5));
        list.addNode(6);
        list.addNode(7);
        CNode nodeNine = new CNode(9);
        list.addNode2(nodeNine);
        list.addAfter(nodeNine, 8);

        list.addNode(10);
        list.removeLast();
        list.removeFirst();

        list.display();
    }
}
