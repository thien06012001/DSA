package Week3.Tutorial;

public class Problem1 {
    public static void main(String[] args) {
        Node n6 = new Node(6, null);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        n6.next = n3;

        run(10, n1);
        if(loop(n1)){
            System.out.println();
            System.out.println("Loop found");
            breakLoop(n1);
            run(10, n1);
        }else{
            System.out.println();
            System.out.println("No loop found");
        }

    }

    static void run(int times, Node start){
        Node node = start;
        int count = 0;

        while(count < times && node != null){ //run until n times and it is not the end of the ll
            System.out.print(node.data); //print out node data
            node = node.next; //Move forward
            count++;
        }
    }
    static boolean loop(Node start){
        Node hare = start;
        Node tortoise = start;

        do{
            if(hare.next == null){ //Check if it is the last node
                return false;
            }
            else{
                hare = hare.next; //Move node hare forward
            }
            if(hare.next == null){ //Check if it is the last node
                return false;
            }
            else {
                hare = hare.next; //Move node hare forward
                tortoise = tortoise.next; //Move node tortoise forward
            }
        }
        while(tortoise != hare);

        return true;
    }
    static void breakLoop(Node start){
        Node tortoise = start;
        Node hare = start;

        do{
            hare = hare.next; // Move forward node hare twice
            hare = hare.next;
            tortoise = tortoise.next; // Move node tortoise forward
        }while(tortoise != hare); //Move the nodes when they don't meet

        int count = 0; //Count how many nodes in the loop
        do{
            tortoise = tortoise.next;
            count++;
        }while(tortoise != hare); // Move node tortoise until they meet

        //Move node hare and tortoise to the starting node
        tortoise = hare = start;
        // Move node hare 'count' times
        while(count > 0){
            hare = hare.next;
            count--;
        }
        System.out.println(hare.data);
        //Move both nodes until they meet
        while(tortoise.next != hare.next){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        hare.next = null;
        System.out.println(hare.data);// remove loop by pointing hare node to null
    }
}
