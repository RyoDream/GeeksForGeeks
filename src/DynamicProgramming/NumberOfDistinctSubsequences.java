package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Number of distinct subsequences
 *
 * You will be given strings consisting of lower case English alphabets.
 * The task for each string is to print the number of distinct subsequences
 * (include empty subsequence).
 */
public class NumberOfDistinctSubsequences {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            String str = scanner.next();
            System.out.println(numberOfDistinctSubsequence(str));
        }
    }

    private static long numberOfDistinctSubsequence(String str) {
        if(str == null || str.length() == 0)
            return 1;

        long[] dp = new long[str.length()+1];
        int[] index = new int[256];
        Arrays.fill(index, -1);
        dp[0] = 1;

        for(int i=1;i<=str.length();i++) {
            dp[i] = 2*dp[i-1];
            if(index[str.charAt(i-1)] != -1) {
                dp[i] -= dp[index[str.charAt(i-1)]];
            }
            index[str.charAt(i-1)] = i-1;
        }

        return dp[str.length()] % 1000000007;
    }
}
