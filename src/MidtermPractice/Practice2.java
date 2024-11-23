package MidtermPractice;
import Week3.Lecture.ArrayStack;

public class Practice2 {
    public static void main(String[] args) {
        String str = "GeeksQuiz";
        reverseString(str);
    }
    public static void reverseString(String str){
        int n = str.length();
        ArrayStack<Character> stack = new ArrayStack<>();

        // Push every letter of the string to the stack
        for(int i=0; i<n; i++){
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            System.out.print(stack.peek());
            stack.pop();
        }
    }

}
