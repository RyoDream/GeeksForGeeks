package DynamicProgramming;

import java.util.Scanner;

/**
 * Count number of hops
 * Frog steps either 1, 2 or 3 steps to go to top.
 * In how many ways it reaches the top?
 */
public class CountNumberOfHops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(countHops(n));
        }
    }

    private static long countHops(int n) {
        switch(n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
        }

        long[] hops = new long[n+1];
        hops[1] = 1;
        hops[2] = 2;
        hops[3] = 4;

        for(int i=4;i<=n;i++) {
            hops[i] = hops[i-1] + hops[i-2] + hops[i-3];
        }

        return hops[n];
    }
}
