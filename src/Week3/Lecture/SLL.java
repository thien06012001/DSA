package Week3.Lecture;

import java.util.HashSet;
import java.util.List;

public class SLL {
    static Node head;
    Node tail;
    static int length;

    public SLL(int value){
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void appendNode(Node aNode){
        tail.next = aNode;
        tail = tail.next;
        length += 1;
    }

    public void appendAtHead(Node aNode){
        aNode.next = head;
        head = aNode;
        length += 1;
    }

    public static Node getNode(int index){
        Node current = head;
        for(int i = 0; i < index; i++){
            if (current != null)
                current = current.next;
        }
        return current;
    }

    public void appendAfter(Node w, int data){
        Node u = new Node(data);
        u.next = w.next;
        w.next = u;
        length += 1;
    }
    void add(int i, int data){
        appendAfter(getNode(i), data);
    }

    public void remove(int i){
        if(i == 0){
            head = head.next;
        } else if (i > 0) {
            Node prev = getNode(i - 1);
            Node cur = prev.next;
            prev.next = cur.next;
        }
        length --;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void printSecondEntry() {
        Node current = head;
        int count = 1;
        System.out.print("Every second entry: ");
        while(current != null){
            if(count % 2 == 0){
                System.out.print(current.data + " ");
            }
            current = current.next;
            count ++;
        }

    }
    public static void main(String[] args){
        SLL list = new SLL(10);
        Node secondNode = new Node(20);
        list.appendNode(secondNode);
        list.appendAfter(secondNode,30);
        list.appendNode(new Node(10));
        list.appendNode(new Node(69));
        list.add(0,15);
        list.appendNode(new Node(55));
        list.appendNode(new Node(40));
        list.printList();
        list.printSecondEntry();
        System.out.println();

        list.removeDuplicateNode2();
        System.out.print("Linked list after removing duplicates: ");
        list.printList();
        list.deleteMid();
        System.out.println("Linked List after removing the middle element:");
        list.printList();


    }
    public void deleteMid(){
        Node slow = head;
        Node fast = head;
        Node temp = head;
        while(fast.next != null && fast.next.next != null){
            if(slow != head) {
                temp = temp.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = slow.next; // delete the slow node
        length --;
    }

    public void removeDuplicates() {
        if (head == null) return;

        HashSet<Integer> data = new HashSet<>();

        Node current = head;
        data.add(current.data); // add the first node's data to the set

        while (current.next != null) {
            // First check the next node's data if it exists
            if (data.contains(current.next.data)) {
                current = current.next.next; // Skip the duplicate node
            } else {
                data.add(current.next.data); // continue adding the data of the node into the set
                current = current.next;
            }
        }
    }

    public void removeDuplicateNode2() {
        Node current = head;

        while (current != null) {
            // Initialize a second pointer to check for duplicates ahead of the current node
            Node move = current;

            // Nested loop for the second pointer
            while (move.next != null) {
                if(move.next.data == current.data) {
                    move.next = move.next.next; // Skip the duplicate
                } else {
                    move = move.next;
                }
            }

            current = current.next; // Move to the next node
        }

    }
}
class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

