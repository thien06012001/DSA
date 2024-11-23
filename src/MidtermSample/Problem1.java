package MidtermSample;

public class Problem1 {
    public static void main(String[] args) {
        StackSimulation stack = new StackSimulation();
        String[] result = stack.popAll(new String[] {"A", "B", "C"});
        System.out.print("popAll (A, B, C): ");
        for (String r : result) {
            System.out.print(r+" ");
        }
        System.out.println();

        System.out.println("Test minOperations");
        System.out.println(stack.minOperations(new String[] {}, new String[] {}));  // 0
        System.out.println(stack.minOperations(new String[] {"A"}, new String[] {}));  // 1
        System.out.println(stack.minOperations(new String[] {}, new String[] {"A"}));  // 1
        System.out.println(stack.minOperations(new String[] {"A", "B"}, new String[] {"A"}));  // 1
        System.out.println(stack.minOperations(new String[] {"A", "B"}, new String[] {"B", "A"}));  // 4
        System.out.println(stack.minOperations(new String[] {"A", "B", "C"}, new String[] {"A", "B"}));  // 1
        System.out.println(stack.minOperations(new String[] {"A", "B", "C"}, new String[] {"A", "B", "C", "D"}));  // 1
        System.out.println(stack.minOperations(new String[] {"A", "B", "C"}, new String[] {"A", "C", "B", "D"}));  // 5
    }
}
class StackSimulation{

    String[] popAll(String[] stack){
        int n = stack.length;
        if (n==0) {
            return new String[0]; //empty string array
        }

        String[] result = new String[n];

        // Initialize the i at the end of the stack
        for(int i = n - 1; i >= 0; i--){
            result[n-i-1] = stack[i];
        }

        return result;
    }

    int minOperations(String[] targetStack, String[] currentStack){
        int count = 0; // Count of operations
        int currentIndex = 0; // Pointer for currentStack

        count += Math.abs(targetStack.length - currentStack.length);

        for(int i = 0; i < Math.min(currentStack.length, targetStack.length); i++){
            if(currentStack[i] == null || targetStack[i] == null){
                return count;
            }
            if (!currentStack[i].equals(targetStack[i])) {
                if(currentStack[i] != null && targetStack[i] != null){
                    for (int j = Math.min(currentStack.length, targetStack.length) - 1; j > i; j--){
                        count++; // pop
                    }
                    count++; // push
                }

            }
        }

        return count;

    }
//count= 3
//
//    Target: ['A',"B","C",'D']
//
//    Current: ['A','C',null] i = 0 i = 1 i = 2
}
// N - m