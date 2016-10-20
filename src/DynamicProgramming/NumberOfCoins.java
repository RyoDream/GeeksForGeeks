package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Number of Coins
 *
 * Given a value V, if we want to make change for V cents,
 * and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
 * what is the minimum number of coins to make the change?
 */
public class NumberOfCoins {
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
        Arrays.sort(coins);
        long[] dp = new long[v+1];
        dp[0] = 0;

        for(int i=1;i<=v;i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++) {
                if(coins[j] <= i && dp[i] > 1+dp[i-coins[j]])
                    dp[i] = 1+dp[i-coins[j]];
            }
        }

        return dp[v]==Integer.MAX_VALUE?-1:dp[v];
    }
}
