package Week3.Lecture;

class DNode{
    int data;
    DNode prev;
    DNode next;
    public DNode(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}
public class DLL {
    DNode head;
    DNode tail;
    int length;

    public DLL(int value){
        head = new DNode(value);
        tail = head;
        length = 1;
    }
    //Append at the head
    public void appendToHead(int value){
        DNode newNode = new DNode(value);
        newNode.next = head;
        if(length > 0){
            head.prev = newNode;
        }
        head = newNode;
        if(length == 0){
            tail = newNode;
        }
        length++;
    }
    //Append node at the end of the DLL
    public void appendNode(DNode aNode){
        tail.next = aNode;
        aNode.prev = tail;
        tail = tail.next;
        length+=1;
    }

    //Search for node
    DNode getNode(int index){
        DNode p = null;
        if(index < length / 2){ //index at the left half of the DLL
            p = head;
            for(int i = 0; i < index; i++){
                p = p.next;
            }
        } else{ //index starts from the end of the list
            p = tail;
            for (int i = length - 1; i > index; i--){
                p = p.prev; //goes backwards
            }
        }
        return p;
    }

    //insert before a node w
    public void addBefore(DNode w, int value){
        DNode u = new DNode(value);


        if (w == null) {
            throw new IllegalArgumentException("The reference node cannot be null.");
        }
        // Link the new node with the node before w
        u.next = w;
        u.prev = w.prev;

        // Check the w node is the head node, then w.prev will be null
        // Update the previous node's next to point to the new node
        if (w.prev != null) {
            w.prev.next = u;
        } else {
            // If w was the head, update the head to be the new node
            head = u; // Assuming you have a 'head' reference in your list
        }

        // Link w's previous to the new node
        w.prev = u;

        length++;
    }

    //Print nodes
    public void printlist(){
        DNode p = head;
        while(p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        DLL list = new DLL(5);
        list.appendNode(new DNode(8));
        list.appendNode(new DNode(9));
        list.appendToHead(4);
        DNode secondNode = new DNode(7);
        list.appendNode(secondNode);
        list.addBefore(secondNode,6);
        list.printlist();


        System.out.println(list.getNode(3).data);
    }
}
