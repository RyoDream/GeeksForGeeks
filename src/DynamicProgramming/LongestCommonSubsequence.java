package DynamicProgramming;

import java.util.Scanner;

/**
 * Longest Common Subsequence
 *
 * Given two sequences,
 * find the length of longest subsequence present in both of them.
 * Both the strings are of uppercase.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int l1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(lcs(s1, s2));
        }
    }

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[m][n];
    }
}
