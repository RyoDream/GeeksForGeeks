import java.util.Scanner;

/**
 * Maximum sum increasing subsequence
 *
 * Given an array of n positive integers.
 * Write a program to find the sum of maximum sum subsequence of the given array
 * such that the integers in the subsequence are sorted in increasing order.
 */
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++)
                nums[i] = scanner.nextInt();
            System.out.println(maxSumSubsequence(nums));
        }
    }

    private static long maxSumSubsequence(int[] nums) {
        long[] dp = new long[nums.length];
        long max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            dp[i] = nums[i];
            for(int j=0;j<i;j++) {
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+nums[i]);
            }
            if(dp[i] > max)
                max = dp[i];
        }

        return max;
    }
}
