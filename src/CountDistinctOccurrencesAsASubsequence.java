/**
 * Count distinct occurrences as a subsequence
 *
 * Given a two strings S and T,
 * find count of distinct occurrences of T in S as a subsequence.
 *
 * Examples:
 * Input  : S = banana, T = ban
 * Output : 3
 * T appears in S as below three subsequences.
 * [ban], [ba  n], [b   an]
 *
 * Input  : S = geeksforgeeks, T = ge
 * Output : 6
 * T appears in S as below three subsequences.
 * [ge], [     ge], [g e], [g    e] [g     e]
 * and [     g e]
 */
public class CountDistinctOccurrencesAsASubsequence {
    public int findSubsequenceCount(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++)
            dp[i][0] = 0;

        for(int j=0;j<=n;j++)
            dp[0][j] = 1;

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(j-1) != t.charAt(i-1))
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        CountDistinctOccurrencesAsASubsequence countDistinctOccurrencesAsASubsequence = new CountDistinctOccurrencesAsASubsequence();
        int count = countDistinctOccurrencesAsASubsequence.findSubsequenceCount("abcecdedcecascedjkle", "ce");
        System.out.println(count);
    }


}
