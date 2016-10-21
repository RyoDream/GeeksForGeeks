package DynamicProgramming;

import java.util.Scanner;

/**
 * Kadane's Algorithm
 *
 * Given an array containing both negative and positive integers.
 * Find the contiguous sub-array with maximum sum.
 */
public class KadaneAlgorithm {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++)
                nums[i] = scanner.nextInt();
            System.out.println(kadaneAlgorithm(nums));
        }
    }

    private static int kadaneAlgorithm(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max_so_far = nums[0];
        int curr_max = nums[0];

        for(int i=1;i<nums.length;i++) {
            curr_max = Math.max(nums[i], curr_max+nums[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }

}
