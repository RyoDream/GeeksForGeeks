import java.util.Scanner;

/**
 * Adjacents are not allowed
 *
 * You have a rectangular grid of dimension 2 x N .
 * you need to find out the maximum sum such that
 *
 * no two chosen numbers are adjacent, vertically, diagonally or horizontally, .
 */
public class AdjacentsAreNotAllowed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[2*n];
            for(int i=0;i<2*n;i++)
                nums[i] = scanner.nextInt();
            System.out.println(adjNotAllowed(nums));
        }
    }

    /**
     * Suppose we have rectangular:
     * 1 2 7 5 6 2 4 3
     * 3 2 1 2 3 2 1 2
     *
     * Each column, we pick the larger one:
     * 3 2 7 5 6 2 4 3
     *
     * For ith element, current maximum sum is
     * nums[i] + max(dp[i-2], dp[i-3])
     */
    private static long adjNotAllowed(int[] nums) {
        int n =nums.length/2;
        long[] dp = new long[n];
        long max = Long.MIN_VALUE;

        for(int i=0;i<n;i++) {
            dp[i] = Math.max(nums[i], nums[i+n]);
            if(i > 2)
                dp[i] += Math.max(dp[i-2], (i-3>=0)?dp[i-3]:0);
            if(max < dp[i])
                max = dp[i];
        }

        return max;
    }
}
