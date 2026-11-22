
import java.util.Scanner;
import java.util.Arrays;

public class Kruskal {
    static int[] parent;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        int[][] edges = new int[m][3];

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int totalCost = 0;
        int count = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        for (int i = 0; i < m && count < n - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (find(u) != find(v)) {
                union(u, v);
                System.out.println(u + " - " + v + " : " + w);
                totalCost += w;
                count++;
            }
        }

        if (count == n - 1)
            System.out.println("Minimum cost = " + totalCost);
        else
            System.out.println("Graph is not connected; MST does not exist.");

        sc.close();
    }
}
