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

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++) {
            if(i==0)
                dp[i][0] = s1.charAt(i) == s2.charAt(0)?1:0;
            else
                dp[i][0] = s1.charAt(i) == s2.charAt(0)?1:0 + dp[i-1][0];
        }

        for(int i=0;i<n;i++) {
            if(i==0)
                dp[0][i] = s1.charAt(0) == s2.charAt(i)?1:0;
            else
                dp[0][i] = s1.charAt(0) == s2.charAt(i)?1:0 + dp[0][i-1];
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[m-1][n-1];
    }
}
