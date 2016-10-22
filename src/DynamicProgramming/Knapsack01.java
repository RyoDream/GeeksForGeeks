package DynamicProgramming;

import java.util.Scanner;

/**
 * 0 - 1 Knapsack Problem
 *
 * You are given weights and values of N items,
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * Note that we have only one quantity of each item,
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1]
 * which represent values and weights associated with N items respectively.
 *
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that
 * sum of the weights of this subset is smaller than or equal to W.
 *
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class Knapsack01 {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int w = scanner.nextInt();
            int[] values = new int[n];
            int[] weights = new int[n];

            for(int i=0;i<n;i++)
                values[i] = scanner.nextInt();

            for(int i=0;i<n;i++)
                weights[i] = scanner.nextInt();

            System.out.println(knapsack(w, values, weights));
        }
    }

    private static int knapsack(int w, int[] values, int[] weights) {
        int[] dp = new int[w+1];
        for(int i=0;i<values.length;i++) {
            for(int v=w;v>=weights[i];v--) {
                dp[v] = Math.max(dp[v], dp[v-weights[i]]+values[i]);
            }
        }

        return dp[w];
    }
}
