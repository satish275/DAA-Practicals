
import java.util.Scanner;

public class Prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix (0 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        key[0] = 0;
        int totalCost = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }

            if (u == -1) {
                System.out.println("Graph is not connected.");
                sc.close();
                return;
            }

            visited[u] = true;

            if (parent[u] != -1) {
                System.out.println(parent[u] + " - " + u
                        + " : " + graph[parent[u]][u]);
                totalCost += graph[parent[u]][u];
            }

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]
                        && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Minimum cost = " + totalCost);
        sc.close();
    }
}
