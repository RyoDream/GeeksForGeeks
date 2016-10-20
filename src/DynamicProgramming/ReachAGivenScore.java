package DynamicProgramming;

import java.util.Scanner;

/**
 * Reach a given score
 *
 * Consider a game where a player can score 3 or 5 or 10 points in a move.
 * Given a total score n, find number of distinct combinations to reach the given score.
 *
 * when n = 8
 * { 3, 5 } and {5, 3} are the two possible permutations
 * but these represent the same cobmination. Hence output is 1.
 */
public class ReachAGivenScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(reachAGivenScore(n));
        }
    }

    private static int reachAGivenScore(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=3;i<=n;i++)
            dp[i] += dp[i-3];
        for(int i=5;i<=n;i++)
            dp[i] += dp[i-5];
        for(int i=10;i<=n;i++)
            dp[i] += dp[i-10];

        return dp[n];
    }
}
