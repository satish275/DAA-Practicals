import java.util.Scanner;

public class MatrixChain {

    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter dimensions:");

        for (int i = 0; i <= n; i++)
            p[i] = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];

        for (int length = 2; length <= n; length++) {

            for (int i = 1; i <= n - length + 1; i++) {

                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + p[i - 1] * p[k] * p[j];

                    dp[i][j] = min(dp[i][j], cost);
                }
            }
        }

        System.out.println("Minimum number of multiplications = "
                           + dp[1][n]);

        sc.close();
    }
}