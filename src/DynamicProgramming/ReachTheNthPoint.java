package DynamicProgramming;

import java.util.Scanner;

/**
 * Reach the Nth Point
 * There are N points on the road ,you can step ahead by 1 or 2 .
 * Find the number of ways you can reach at point N.
 * For example:  for n=4 we have 5 possible ways [1,1,1,1]  [1,1,2]  [1,2,1]  [2,1,1]  [2 2].
 */
public class ReachTheNthPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(reachNthPoint(n));
        }
    }

    private static long reachNthPoint(int n) {
        if(n<3)
            return n>=0?n:0;

        long first = 1;
        long second = 2;
        for(int i=3;i<=n;i++) {
            second += first;
            first = second-first;
        }

        return second;
    }
}
