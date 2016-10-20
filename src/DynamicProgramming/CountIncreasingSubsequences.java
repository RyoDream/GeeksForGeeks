package DynamicProgramming;

import java.util.Scanner;

/**
 * Count Increasing Subsequences
 *
 * Given an array of digits (values lie in range from 0 to 9).
 * The task is to count all the sub sequences possible in array
 * such that in each subsequence every digit is greater
 * than its previous digits in the subsequence.
 */
public class CountIncreasingSubsequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++)
                nums[i] = scanner.nextInt();

            System.out.println(countIncreasingSubsequence(nums));
        }
    }

    private static long countIncreasingSubsequence(int[] nums) {
        long[] dp = new long[nums.length];
        long sum = 0;
        for(int i=0;i<nums.length;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j])
                    dp[i] += dp[j];
            }
            sum += dp[i];
        }

        return sum;
    }
}
