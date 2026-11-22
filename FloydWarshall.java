
import java.util.Scanner;

public class FloydWarshall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] d = new int[n][n];

        System.out.println("Enter adjacency matrix (use 999 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] != 999 && d[k][j] != 999
                            && d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 999)
                    System.out.print("INF ");
                else
                    System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
