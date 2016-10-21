package DynamicProgramming;

import java.util.Scanner;

/**
 * Optimal walk
 *
 * Given a point on x axis, (N,0), you are standing at origin and you can only move on x-axis.
 * Lets say you are at (x,0), at each step you can either move one step forward ie (x+1,0)
 * or one step backwards (x-1,0) or make a jump to double your current position (2*x,0).
 *
 * One step movement costs you A while a jump costs you B.
 * If your initial position is (0,0) ,
 * find the minimum cost to reach (N,0) .
 */
public class OptimalWalk {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(optimalWalk(n, a, b));
        }
    }

    private static long optimalWalk(int n, int a, int b) {
        long[] dp = new long[n+1];
        dp[1] = a;

        for(int i=2;i<=n;i++) {
            if(i % 2 == 0)
                dp[i] = Math.min(dp[i/2]+b, dp[i-1]+a);
            else
                dp[i] = Math.min(Math.min(dp[i/2]+a+b, dp[(i+1)/2]+a+b),dp[i-1]+a);
        }

        return dp[n];
    }
}
