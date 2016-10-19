/**
 * K-Palindrome
 *
 * A string is k palindrome if it can be transformed into a palindrome
 * on removing at most k characters from it.
 *
 * Your task is to complete the function is_k_palin
 * which takes two arguments a string str and a number N .
 *
 * Your function should return true
 * if the string is k palindrome else it should return false.
 */
public class K_Palinadrome {

    /**
     * If we carefully analyze the problem,
     * the task is to transform the given string into its reverse by removing at most K characters from it.
     * The problem is basically a variation of Edit Distance.
     *
     * We can modify the Edit Distance problem to consider given string
     * and its reverse as input and only operation allowed is deletion.
     */
    public int isKPalDP(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                // If first string is empty, only option is to
                // remove all characters of second string
                if(i == 0)
                    dp[i][j] = j;
                // If second string is empty, only option is to
                // remove all characters of first string
                else if(j == 0)
                    dp[i][j] = i;
                // If last characters are same, ignore last character
                // and recur for remaining string
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                // If last character are different, remove it
                // and find minimum
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public boolean is_k_palin(String str, int k) {
        String reverse = new StringBuffer(str).reverse().toString();

        // Since given string is compared with its reverse
        // we will do at most N deletions from first string
        // and N deletions from second string to make them equal.

        //Therefore, for a string to be k-palindrome,
        // 2*N <= 2*K should hold true.
        return (isKPalDP(str, reverse) <= 2*k);
    }

    public static void main(String[] args) {
        String s = "acdcb";
        int k = 1;
        System.out.println(new K_Palinadrome().is_k_palin(s, k));
    }
}
