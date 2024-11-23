package Week3.Lecture;

public class ArrayQueue<T> {
    private int size;
    private int front, rear;

    // I set a small value to test
    // you should replace 10 with a larger value when you use this ADT
    private static int MAX_SIZE = 10;
    private T[] items;

    public ArrayQueue() {
        size = 0;
        front = rear = 0;
        items = (T[])new Object[MAX_SIZE];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enQueue(T item) {
        // make sure the queue still have empty slot
        if (size < MAX_SIZE) {
            items[rear] = item;
            rear = (rear + 1) % MAX_SIZE;
            size++;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        // make sure the queue is not empty
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % MAX_SIZE;
        size--;

        return true;
    }

    public T peekFront() {
        // make sure the queue is not empty
        if (isEmpty()) {
            return null;
        }
        return items[front];
    }

    public T peekRear(){
        if (isEmpty()) {
            return null;
        }

        return items[rear];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        // enqueue 1 to 9
        for (int i = 1; i <= 9; i++) {
            queue.enQueue(i);
        }
        // dequeue 5 times => should get 1 to 5
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.peekFront());
            queue.deQueue();
        }
        // enqueue 1 to 5
        for (int i = 1; i <= 5; i++) {
            queue.enQueue(i);
        }
        // dequeue until empty()
        // should get 6 to 9, then 1 to 5
        while (!queue.isEmpty()) {
            System.out.println(queue.peekFront());
            queue.deQueue();
        }
    }
}