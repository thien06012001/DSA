package Week11.Tutorial;

public class P2 {
    public static void main(String[] args) {
        int[][] castles = {
                { 0, 1, 2, 8 },
                { 1, 0, 3, 5 },
                { 2, 3, 0, 4 },
                { 8, 5, 4, 0 }
        };
        System.out.println("Shortest total length: " + minimumSpanningTree(castles));
    }


/**
 * Computes the total length of the Minimum Spanning Tree (MST) for a connected, weighted, 
 * and undirected graph using Prim's algorithm.
 *
 * @param nodes A 2D array representing the adjacency matrix of the graph.
 *              - nodes[i][j] represents the weight of the edge between node i and node j.
 *              - If nodes[i][j] = 0, it indicates no direct edge between node i and node j.
 * @return      The total weight of the Minimum Spanning Tree (MST).
 *              If the graph is not connected, returns Integer.MAX_VALUE.
 *
 * Algorithm Overview:
 * - Uses Prim's algorithm to find the MST:
 *   1. Initializes a set of added nodes and an array of distances to keep track of the shortest
 *      distance from the MST to the remaining nodes.
 *   2. Starts with an arbitrary node (in this case, node 0) and adds it to the MST.
 *   3. Iteratively selects the node with the smallest distance to the current MST and adds it.
 *   4. Updates distances for the remaining nodes based on the newly added node.
 *   5. Stops when all nodes are added or when it becomes impossible to connect more nodes.
 * - The algorithm ensures that the resulting tree connects all nodes with the minimum total weight.
 *
 * Time Complexity: O(N^2), where N is the number of nodes in the graph.
 *                  (Can be improved to O(E log N) using a priority queue.)
 * Space Complexity: O(N) for storing the added nodes and distances arrays.
 */

    static int minimumSpanningTree(int[][] nodes) {
        int n = nodes.length;
        int length = 0;

        // use this array to mark nodes have been added already
        boolean[] added = new boolean[n];

        // distance between the tree being built and not-yet-added nodes
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        // insert node zero (any node is OK) first, so set its distance to zero
        distances[0] = 0;

        // stop when the number of added nodes = n
        int nodeCount = 0;
        while (nodeCount < n) {
            int shortest = Integer.MAX_VALUE;
            int shortestNode = -1; // index of the node having the shortest distance to the tree

            // determine the shortest-distance node to the tree
            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    continue;
                }
                if (shortest > distances[i]) {
                    shortest = distances[i];
                    shortestNode = i;
                }
            }

            if (shortest == Integer.MAX_VALUE) {
                // we cannot go further - the graph is not connected
                return Integer.MAX_VALUE;
            }

            // add the shortest node to the tree
            added[shortestNode] = true;
            length += distances[shortestNode];
            nodeCount++;

            // update other distances to the tree
            for (int i = 0; i < n; i++) {
                if (added[i]) {
                    continue;
                }
                // shortestNode and i are connected
                if (nodes[shortestNode][i] > 0) {
                    // connect through shortestNode is better?
                    if (distances[i] > nodes[shortestNode][i]) {
                        distances[i] = nodes[shortestNode][i];
                    }
                }
            }
        }
        return length;
    }
}
