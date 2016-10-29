package DynamicProgramming;

import java.util.Scanner;

/**
 * Maximum value
 *
 * Find the maximum value of arr[j] – arr[i] + arr[l] – arr[k],
 * such that i < j < k < l
 */
public class MaximumValue {
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
            System.out.println(maxValue(nums));
        }

        scanner.close();
    }

    // O(n^2)
    private static int maxValue(int[] nums) {
        if(nums == null || nums.length < 4)
            return 0;
        if(nums.length == 4)
            return nums[1]+nums[3]-nums[0]-nums[2];

        int maxValue = 0;
        for(int i=2;i<=nums.length-2;i++) {
            int sum = 0;
            int max = nums[1] - nums[0];
            int min = nums[0];
            for(int j=1;j<i;j++) {
                max = Math.max(max, nums[j]-min);
                min = Math.min(min, nums[j]);
            }
            sum += max;

            max = nums[i+1] - nums[i];
            min = nums[i];
            for(int k=i+1;k<nums.length;k++) {
                max = Math.max(max, nums[k]-min);
                min = Math.min(min, nums[k]);
            }
            maxValue = Math.max(maxValue, sum+max);
        }

        return maxValue;
    }
}
