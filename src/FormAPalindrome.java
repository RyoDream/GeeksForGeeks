import java.util.Scanner;

/**
 * Form a palindrome
 *
 * Given a string,
 * find the minimum number of characters to be inserted to convert it to palindrome.
 */

//If we find out LCS of string and its reverse,
// we know how many maximum characters can form a palindrome.
// We need insert remaining characters.
public class FormAPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            String s = scanner.next();
            System.out.println(formAPalindrome(s));
        }
    }

    public static int formAPalindrome(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        return s.length() - lcs(s, reverse);
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
