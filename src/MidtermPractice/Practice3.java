package MidtermPractice;

import Week3.Lecture.ArrayQueue;
import Week3.Lecture.ArrayStack;
import MidtermPractice.Practice2;


public class Practice3 {
    public static void main(String[] args){
        String s2 = "abbaca";
        String s = "azxxzy";

        removeAdjacentDuplicates(s2);
        System.out.println();
        removeAdjacentDuplicates(s);

        usingQueue(s2);
        usingQueue(s);
    }

    public static void removeAdjacentDuplicates(String str){
        int n = str.length();
        ArrayStack<Character> stack = new ArrayStack<>();

        // Push every letter of the string to the stack
        for(int i = 0; i <n; i++){
            if(stack.isEmpty()){
                stack.push(str.charAt(i));
            } else {
                if(stack.peek() == str.charAt(i) ){
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }

        int stackSize = stack.size();
        char[] res = new char[n];

        for(int i = stackSize - 1; i >= 0; i--){
            res[i] = stack.peek();
            stack.pop();
        }

        for(int j = 0; j < stackSize; j++){
            System.out.print(res[j]);
        }
    }

    public static void usingQueue(String str){
        int n = str.length();
        ArrayQueue<Character> queue = new ArrayQueue<>();

        // Push every letter of the string to the stack
        for(int i = 0; i <n; i++){
            if (queue.isEmpty()) {
                queue.enQueue(str.charAt(i));
            } else {
                if(queue.peekRear() == str.charAt(i)){
                    queue.deQueue();
                } else{
                    queue.enQueue(str.charAt(i));
                }
            }
        }

        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.peekFront());
            queue.deQueue();
        }
    }
}
