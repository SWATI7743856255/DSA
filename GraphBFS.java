import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello graph");

        int n = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (1-based indexing)
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(1);
        graph.get(4).add(3);
        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(5).add(2);
        graph.get(5).add(4);

        // Print the graph
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }

        // Run BFS from node 1
        System.out.println("\nBFS Traversal starting from node 1:");
        bfs(graph, n, 1);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1]; // 1-based indexing
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 0; i < graph.get(current).size(); i++) {
                int neighbor = graph.get(current).get(i);
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
