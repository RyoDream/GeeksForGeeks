package DynamicProgramming;

import java.util.Scanner;

/**
 * Unique BST's
 *
 * Given an interger N,
 * how many structurally unique binary search trees are there
 * that store values 1...N?
 */
public class UniqueBST {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(uniqueBST(n));
        }
    }

    private static int uniqueBST(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }
}
