package Week8.Lecture;

import java.util.*;

public class SourceRemoval {

    // Function to perform topological sort using the source removal algorithm
    public static List<Integer> topologicalSort(int vertices, List<List<Integer>> adjacencyList) {
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[vertices]; // To store the indegree of each vertex
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices]; // To mark visited vertices

        // Calculate the indegree for all vertices
        for (int u = 0; u < vertices; u++) {
            System.out.println("u: " + u);
            for (int v : adjacencyList.get(u)) {
                System.out.println("v: " + v);
                indegree[v]++;
            }
        }

        // Add vertices with indegree 0 to the queue
        for (int v = 0; v < vertices; v++) {
            if (indegree[v] == 0) {
                queue.offer(v);
                visited[v] = true;
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            // Process each neighbor of u
            for (int w : adjacencyList.get(u)) {
                if (!visited[w]) {
                    indegree[w]--;
                    if (indegree[w] == 0) {
                        queue.offer(w);
                        visited[w] = true;
                    }
                }
            }
        }

        return result; // Return the topologically sorted result
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices in the graph
        List<List<Integer>> adjacencyList = new ArrayList<>();

        // Initialize adjacency list for all vertices
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges to the adjacency list (directed graph)
        adjacencyList.get(5).add(2);
        adjacencyList.get(5).add(0);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);

        // Perform topological sort
        List<Integer> result = topologicalSort(vertices, adjacencyList);

        System.out.println("Topological Sort:");
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
    }
}
