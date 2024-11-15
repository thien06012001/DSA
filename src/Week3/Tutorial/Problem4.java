package Week3.Tutorial;

import java.util.Stack;

public class Problem4 {

    public static void main(String[] args) {
        System.out.println(isBalance("(){{[]}}()")); // true
        System.out.println(isBalance("{)")); // false
        System.out.println(isBalance("{{[[}}]]")); // false
        System.out.println(isBalance("{{[[}}]]")); // false
    }

    // Check for balance brackets in a string
    /*
    []: balanced

    {}: balanced

    (): balanced

    (){{[]}}(): balanced

    {): not balanced

    {{[[}}]]: not balanced
    */

    public static boolean isBalance(String s) {
        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Loop through the string
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is an opening bracket, push it to the stack
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If the character is a closing bracket, pop the stack
            else if(c == ')' || c == '}' || c == ']') {
                // Firstly, If the stack is empty, return false. Since in the beginning there are no opening brackets
                if(stack.isEmpty()) {
                    return false;
                }

                // If the stack is not empty, pop the stack
                char top = stack.pop(); //pop() returns the element at the top of the stack

                // Check if the brackets are balanced
                if(c == ')' && top != '(') {
                    return false;
                }
                if(c == '}' && top != '{') {
                    return false;
                }
                if(c == ']' && top != '[') {
                    return false;
                }
            }
        }

        // If the stack is not empty, return false
        return stack.isEmpty();
    }
}
