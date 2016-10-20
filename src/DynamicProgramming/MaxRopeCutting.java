package DynamicProgramming;

import java.util.Scanner;

/**
 * Max rope cutting
 *
 * Given a rope of length n meters,
 * cut the rope in different parts of integer lengths in a way
 * that maximizes product of lengths of all parts.
 * You must make at least one cut.
 */
public class MaxRopeCutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(maxRopeCut(n));
        }
    }

    private static long maxRopeCut(int n) {
        if(n == 0)
            return 0;
        else if(n <= 2)
            return 1;
        else if(n == 3)
            return 2;

        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4;i<=n;i++) {
            dp[i] = Integer.MIN_VALUE;
            for(int j=1;j<=i/2;j++) {
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
            }
        }

        return dp[n];
    }
}
