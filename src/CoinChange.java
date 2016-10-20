import java.util.Scanner;

/**
 * Coin Change
 *
 * Given a value N, find the number of ways to make change for N cents,
 * if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins.
 *
 * The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4.
 *
 * For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int v = scanner.nextInt();
            int n = scanner.nextInt();
            int[] coins = new int[n];
            for(int i=0;i<n;i++)
                coins[i] = scanner.nextInt();
            System.out.println(numberOfCoins(coins, v));
        }
    }

    private static long numberOfCoins(int[] coins, int v) {
        long[] dp = new long[v+1];
        dp[0] = 1;

        for(int i=0;i<coins.length;i++) {
            for(int j=coins[i];j<=v;j++) {
                dp[j] += dp[j-coins[i]];
            }
        }

        return dp[v];
    }
}
