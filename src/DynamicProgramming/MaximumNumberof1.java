package DynamicProgramming;

import java.util.Scanner;

/**
 * Maximum Number of 1s
 *
 * You are a binary string A consisting of 0s and 1s only.
 * You are allowed to do exactly one move that is you have to choose two indices i and j (1 ≤ i ≤ j ≤ |A|
 * where |A| is string length) and toggle all the characters at position k where i ≤ k ≤ j.
 * Toggling means changing 0 to 1 and 1 to 0.
 *
 * The task is that after exactly one move you have to obtain the maximum possible number of 1's.
 */
public class MaximumNumberof1 {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            String str = scanner.next();
            System.out.println(maxNumberFo1(str));
        }
    }

    private static int maxNumberFo1(String str) {
        int count1 = 0;
        int[] nums = new int[str.length()];
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '1') {
                nums[i] = -1;
                count1++;
            }
            else
                nums[i] = 1;
        }

        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        if(max == 0)
            return count1-1;
        return count1+max;
    }
}
