package MidtermPractice;

import Week3.Lecture.ArrayQueue;
import Week3.Lecture.ArrayStack;

public class Practice4 {
    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};

        int[] students2  = {1,1,1,0,0,1};
        int[] sandwiches2  = {1,0,0,0,1,1};
        System.out.println(countStudents(students2, sandwiches2));


        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches){
        ArrayStack<Integer> stackSandwiches = new ArrayStack<>();
        ArrayQueue<Integer> queueStudents = new ArrayQueue<>();

        int currentStudentLooped = 0;

        for(int i = sandwiches.length - 1; i >= 0; i--){
            stackSandwiches.push(sandwiches[i]);
        }

        for (int i = 0; i < students.length; i++) {
            queueStudents.enQueue(students[i]);
        }

        while(!queueStudents.isEmpty()){
            if (queueStudents.peekFront() == stackSandwiches.peek()) {
                // Student eats the sandwich
                stackSandwiches.pop();
                queueStudents.deQueue();
                currentStudentLooped = 0; // Reset the deadlock counter
            } else {
                // Student cannot eat; move to the back of the queue
                queueStudents.enQueue(queueStudents.peekFront());
                queueStudents.deQueue();
                currentStudentLooped++;
            }

            // If all students have been cycled through without eating, stop
            if (currentStudentLooped == queueStudents.size()) {
                break;
            }

//
//                if (queueStudents.peekFront() == stackSandwiches.peek() ){
//                    stackSandwiches.pop();
//                    queueStudents.deQueue();
//                    count = 0;
//                }
//                else{
//                    queueStudents.enQueue(queueStudents.peekFront());
//                      queueStudents.deQueue();
//                    count++;
//
//                    // If all students in the queue have been cycled through without eating, break
//                    if (count == queueStudents.size()) {
//                        break;
//                    }
//                }


        }
        return queueStudents.size();
    }

//    all queue are the same elements, peek of the stack is not the same => stop the while loop and return the queue size
//    queue 0

    public static boolean isTheSameElements(ArrayQueue<Integer> students, ArrayStack<Integer> sandwiches) {
        if (students.isEmpty() || sandwiches.isEmpty()) {
            return false;
        }

        int currentElement = students.peekFront();

        for (int i = 0; i < students.size(); i++) {
            int front = students.peekFront();
            students.deQueue();
            students.enQueue(front); // Restore the queue state
            if (front != currentElement) {
                return false;
            }
        }

        // Check if the queue's elements differ from the top of the stack
        return currentElement == sandwiches.peek();
    }
}
