package Week11.Tutorial;

public class P1 {
    public static void main(String[] args) {
        int[][] distances = {
                { 0, 3, 2, 0 },
                { 3, 0, 0, 5 },
                { 2, 0, 0, 9 },
                { 0, 5, 9, 0 }
        };
        System.out.println("Shortest distance: " + shortestPath(distances, 0, distances.length - 1));
    }
 
    /**
 * Computes the shortest path between a source node and a destination node in a weighted graph
 * using Dijkstra's algorithm.
 * 
 * @param nodes A 2D array representing the adjacency matrix of the graph.
 *              - nodes[i][j] is the weight of the edge between node i and node j.
 *              - If nodes[i][j] = 0, it indicates no direct edge between node i and node j.
 * @param src   The index of the source node (starting node).
 * @param dest  The index of the destination node (target node).
 * @return      The shortest distance from the source node to the destination node. 
 *              If the destination is unreachable, returns Integer.MAX_VALUE.
 * 
 * Algorithm Overview:
 * - Initializes distances from the source node to all other nodes as infinity (except itself, which is 0).
 * - Iteratively selects the unvisited node with the smallest known distance.
 * - Updates the distances to its neighboring nodes based on the shortest path found so far.
 * - Tracks the path using the `previous` array, which stores the predecessor of each node in the path.
 * - Stops when the destination node is reached or all nodes are processed.
 * 
 * Time Complexity: O(V^2), where V is the number of nodes in the graph.
 *                  (Can be reduced to O((V + E) log V) with a priority queue.)
 * Space Complexity: O(V) for the distance, visited, and previous arrays.
 */
    static int shortestPath(int[][] nodes, int src, int dest) {
        int n = nodes.length;

        int[] distances = new int[n]; // distance[i] stores the minimum distance from src to i
        boolean[] visited = new boolean[n]; // visited state
        int[] previous = new int[n]; // used to construct the shortest path; previous[i] stores the node that is
                                     // visited before i

        // initialization
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }
        distances[src] = 0; // zero distance from the src to itself

        while (true) {
            // Greedy choice: retrieve the shortest-distance node from
            // unvisited nodes
            int shortest = Integer.MAX_VALUE;
            int shortestNode = -1;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (shortest > distances[i]) {
                    shortest = distances[i];
                    shortestNode = i;
                }
            }

            // update the shortest distance through shortest node
            // to all unvisited nodes
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                // shortestNode and i are connected?
                if (nodes[shortestNode][i] > 0) {
                    // current distance to i > distance reached through shortestNode
                    if (distances[i] > distances[shortestNode] + nodes[shortestNode][i]) {
                        distances[i] = distances[shortestNode] + nodes[shortestNode][i];
                        previous[i] = shortestNode;
                    }
                }
            }

            if (shortestNode == dest) {
                // we reach the destination
                // display the shortest path
                String path = shortestNode + "";
                while (previous[shortestNode] != -1) {
                    shortestNode = previous[shortestNode];
                    path = shortestNode + " -> " + path;
                }

                System.out.println("Shortest path: " + path);
                return distances[dest];
            }

            // even shortest is INFINITY => stop
            if (shortest == Integer.MAX_VALUE) {
                // we cannot go further
                return Integer.MAX_VALUE;
            }
            // continue the next round
            visited[shortestNode] = true;
        }
    }
}