
import java.util.Scanner;

public class GraphSearch {
    static int a[][] = new int[20][20];
    static boolean visited[] = new boolean[20];
    static int n;

    static void DFS(int v) {
        System.out.print(v + " ");
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            if (a[v][i] == 1 && !visited[i])
                DFS(i);
        }
    }

    static void BFS(int start) {
        int q[] = new int[20];
        int front = 0, rear = 0;

        for (int i = 0; i < n; i++)
            visited[i] = false;

        q[rear++] = start;
        visited[start] = true;

        while (front < rear) {
            int v = q[front++];
            System.out.print(v + " ");

            for (int i = 0; i < n; i++) {
                if (a[v][i] == 1 && !visited[i]) {
                    q[rear++] = i;
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.print("Enter starting vertex (0 to " + (n - 1) + "): ");
        int start = sc.nextInt();

        System.out.print("DFS: ");
        for (int i = 0; i < n; i++)
            visited[i] = false;
        DFS(start);

        System.out.print("\nBFS: ");
        BFS(start);

        sc.close();
    }
}
