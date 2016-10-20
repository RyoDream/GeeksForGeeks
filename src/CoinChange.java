import java.util.Scanner;

/**
 * Coin Change
 *
 * Given a value V, if we want to make change for V cents,
 * and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 * what is the minimum number of coins to make the change?
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
