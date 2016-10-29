package DynamicProgramming;

import java.util.Scanner;

/**
 * Pick values
 *
 * You are given an array A[ ] of positive integers.
 * You have to pick up some values from the array.
 * The only condition is that at least one value among any four consecutive values must be picked.
 *
 * That means at least one among A[i], A[i+1], A[i+2], A[i+3] has to be picked.
 * The aim is to pick values in such a way that the sum of the values is minimized.
 */
public class PickValues {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(pickValues(nums));
        }
    }

    private static int pickValues(int[] nums) {
        if(nums == null)
            return 0;

        if(nums.length < 4) {
            int min = Integer.MAX_VALUE;
            for(int i=0;i<nums.length;i++) {
                if(min > nums[i])
                    min = nums[i];
            }
            return min;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2];
        dp[3] = nums[3];

        for(int i=4;i<nums.length;i++) {
            dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], Math.min(dp[i-3],dp[i-4]))) + nums[i];
        }

        int min = Integer.MAX_VALUE;
        for(int i=nums.length-4;i<nums.length;i++) {
            if(min > dp[i])
                min = dp[i];
        }
        return min;
    }
}
