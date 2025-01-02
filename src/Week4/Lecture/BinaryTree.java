import java.util.LinkedList;
import java.util.Queue;

// Binary Tree Node class
class BTNode {
    double data; // Value stored in the node
    BTNode left; // Pointer to the left subtree
    BTNode right; // Pointer to the right subtree

    // Constructor to create a node with data
    BTNode(double data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Binary Tree class
public class BinaryTree {
    BTNode root; // Root node of the binary tree

    // Constructor to initialize the tree
    public BinaryTree() {
        root = null;
    }

    // Pre-order traversal wrapper
    private void traversePreRecursive() {
        System.out.println("\nPre-order traversal recursive:");
        preRecursive(root);
    }

    // Recursive function for pre-order traversal
    private void preRecursive(BTNode node) {
        if (node != null) {
            System.out.print(" " + node.data); // Visit the node
            preRecursive(node.left); // Traverse left subtree
            preRecursive(node.right); // Traverse right subtree
        }
    }

    private void traverseInRecursive() {
        System.out.println("\nIn-order traversal recursive: ");
        inRecursive(root);
    }

    private void inRecursive(BTNode node) {
        if (node != null) {
            inRecursive(node.left);
            System.out.print(" " + node.data); // Node visit
            inRecursive(node.right);
        }
    }

    private void traversePostRecursive() {
        System.out.println("\nPost-order traversal recursive: ");
        postRecursive(root);
    }

    private void postRecursive(BTNode node) {
        if (node != null) {
            postRecursive(node.left);
            postRecursive(node.right);
            System.out.print(" " + node.data); // Visit node
        }
    }

    // Breadth-First Traversal (Iterative)
    private void bfTraverse() {
        System.out.println("\nBreadth-first traversal iterative:");
        if (root == null)
            return;

        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BTNode node = q.poll(); // Retrieve and remove the front node
            System.out.print(" " + node.data); // Visit the node

            // Add left and right children to the queue
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    // Main method to test the traversal
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Manually creating a tree for demonstration
        tree.root = new BTNode(1);
        tree.root.left = new BTNode(1.1);
        tree.root.right = new BTNode(1.2);
        tree.root.left.left = new BTNode(1.11);
        tree.root.left.right = new BTNode(1.12);
        tree.root.right.left = new BTNode(1.21);
        tree.root.right.right = new BTNode(1.22);

        // Perform various traversals
        tree.traversePreRecursive();
        tree.traverseInRecursive();
        tree.traversePostRecursive();
        tree.bfTraverse(); // Perform breadth-first traversal
    }
}
