package Week4.Tutorial;

public class BST {

    // Node class for Binary Search Tree
    static class BTNode {
        int data;
        BTNode left, right, parent;

        public BTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private BTNode root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    // Find a node with the given value
    private BTNode find(int x) {
        BTNode node = root;
        while (node != null) {
            if (x < node.data) {
                node = node.left;
            } else if (x > node.data) {
                node = node.right;
            } else {
                return node; // Node found
            }
        }
        return null; // Node not found
    }

    // Insert a new value into the tree
    public boolean insert(int value) {
        if (root == null) {
            root = new BTNode(value);
        } else {
            BTNode parent = null, current = root;
            while (current != null) {
                if (value < current.data) {
                    parent = current;
                    current = current.left;
                } else if (value > current.data) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Value already exists
                }
            }

            if (value < parent.data) {
                parent.left = new BTNode(value);
                parent.left.parent = parent;
            } else {
                parent.right = new BTNode(value);
                parent.right.parent = parent;
            }
        }
        size++;
        return true; // Insert successful
    }

    // Search for a value and count comparisons
    public int searchWithComparisons(int value) {
        BTNode current = root;
        int comparisons = 0;

        while (current != null) {
            comparisons++;
            if (value == current.data) {
                return comparisons; // Value found
            } else if (value < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return comparisons; // Value not found
    }

    // Remove a node from the tree
    private void remove(BTNode node) {
        if (node.left == null || node.right == null) {
            splice(node);
        } else {
            BTNode successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            node.data = successor.data;
            splice(successor);
        }
    }

    // Splice a node (used for deletion)
    private void splice(BTNode node) {
        BTNode child = (node.left != null) ? node.left : node.right;
        BTNode parent = node.parent;

        if (node == root) {
            root = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        if (child != null) {
            child.parent = parent;
        }

        size--;
    }

    // Get the size of the tree
    public int getSize() {
        return size;
    }

    // In-order traversal (for debugging and testing purposes)
    private void inOrderTraversal(BTNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }


    public static void main(String[] args) {
        BST bst = new BST();

        // Insert elements
        bst.insert(4);
        bst.insert(2);
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);
        bst.insert(9);
        bst.insert(6);
        bst.insert(5);

        // Print in-order traversal
        System.out.println("In-order traversal:");
        bst.inOrderTraversal(bst.root);
        System.out.println();

        // Search for values and count comparisons
        int valueToSearch = 7;
        int comparisons = bst.searchWithComparisons(valueToSearch);
        System.out.println("Searching for " + valueToSearch + ": Comparisons = " + comparisons);

        // Search for a non-existent value
        valueToSearch = 10;
        comparisons = bst.searchWithComparisons(valueToSearch);
        System.out.println("Searching for " + valueToSearch + ": Comparisons = " + comparisons);
    }
}
