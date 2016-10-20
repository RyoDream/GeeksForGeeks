package DynamicProgramming;

import java.util.Scanner;

/**
 * Longest Common Increasing Subsequence (LCS + LIS)
 *
 * Given two arrays, find length of the longest common increasing subsequence (LCIS).
 * For example length of LCIS for A[] = {3, 4, 9, 1} and B[] = {5, 3, 8, 9, 10, 2, 1}  is 2
 * ( The subsequence {3, 9} is the longest subsequence that is both common and increasing.)
 * As another example LCIS for A[] = {1, 1, 4, 3} and B[] = {1, 1, 3, 4} is 2
 * (There are two subsequences {1, 4} and {1, 3}).
 */
public class LongestCommonIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] array1 = new int[n];
            for(int i=0;i<n;i++)
                array1[i] = scanner.nextInt();
            int m = scanner.nextInt();
            int[] array2 = new int[m];
            for(int i=0;i<m;i++)
                array2[i] = scanner.nextInt();

            System.out.println(lcis(array1, array2, n, m));
        }
    }

    private static int lcis(int[] arr1, int[] arr2, int n, int m) {
        // dp[j] is going to store length of LCIS ending with arr2[j]
        int[] dp = new int[m];

        for(int i=0;i<n;i++) {
            // Initialize current length of LCIS
            int currentLen = 0;

            // For each element of arr1[]
            // trvarse all elements of arr2[].
            for(int j=0;j<m;j++) {
                // If both the array have same elements.
                // Note that we don't break the loop here.
                if(arr1[i] == arr2[j] && currentLen + 1 > dp[j])
                    dp[j] = currentLen + 1;

                // Now seek for previous smaller common element
                // for current element of arr1
                if(arr1[i] > arr2[j] && dp[j] > currentLen)
                    currentLen = dp[j];
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
            if(dp[i] > maxLen)
                maxLen = dp[i];

        return maxLen;
    }
}
