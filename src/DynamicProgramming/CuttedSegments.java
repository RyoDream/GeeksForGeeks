package DynamicProgramming;

import java.util.Scanner;

/**
 * Cutted Segments
 *
 * Given an integer N denoting the Length of a line segment.
 * you need to cut the line segment in such a way that
 * the cut length of a line segment each time is integer either x , y or z.
 *
 * and after performing all cutting operation
 * the total number of cutted segments must be maximum.
 */
public class CuttedSegments {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            System.out.println(cuttedSegments(n, x, y, z));
        }
    }

    private static long cuttedSegments(int n, int... arg) {
        long[] dp = new long[n+1];
        dp[0] = 1;

        for(int i=1;i<=n;i++) {
            for(int j=0;j<arg.length;j++) {
                if (i == arg[j]) {
                    dp[i] = Math.max(dp[i], 1);
                }
                if (i > arg[j] && dp[i-arg[j]] != 0 && dp[arg[j]] != 0) {
                    dp[i] = Math.max(dp[i], dp[i - arg[j]] + dp[arg[j]]);
                }
            }
        }

        return dp[n];
    }
}
