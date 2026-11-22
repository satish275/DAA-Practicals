
import java.util.Scanner;

public class TSP {
    static int n;
    static int[][] cost;
    static int[][] dp;
    static int INF = 1000000000;

    static int tsp(int mask, int pos) {
        if (mask == (1 << n) - 1) {
            return cost[pos][0];
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = INF;

        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = cost[pos][city]
                        + tsp(mask | (1 << city), city);

                ans = Math.min(ans, newCost);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        cost = new int[n][n];
        dp = new int[1 << n][n];

        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Minimum tour cost: " + tsp(1, 0));

        sc.close();
    }
}
