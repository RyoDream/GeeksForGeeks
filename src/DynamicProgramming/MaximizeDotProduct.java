package DynamicProgramming;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Maximize Dot Product
 *
 * Given a array A with N elements and array B with M elements.
 * You have to insert (N-M) zeroes in between array B
 * such that the dot product of array A and array B is maximum.
 *
 * Definition of Dot Product : A.B = A[0]*B[0] + A[1]*B[1]+....A[N]*B[N].
 */
public class MaximizeDotProduct {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] A = new int[n];
            int[] B = new int[m];

            for(int i=0;i<n;i++)
                A[i] = scanner.nextInt();

            for(int j=0;j<m;j++)
                B[j] = scanner.nextInt();

            System.out.println(maxDotProduct(A, B, n, m));
            //System.out.println(maxDotProduct2(A, B, n, m).toString());
        }
    }

    private static long maxDotProduct(int[] A, int[] B, int n, int m) {
        long[][] dp = new long[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(i<j) {
                    continue;
                }
                else if(i==j) {
                    dp[i][j] = A[i-1]*B[j-1] + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+A[i-1]*B[j-1]);
                }

                printDP(dp);
            }
        }

        return dp[n][m];
    }

    private static void printDP(long[][] dp) {
        for(int i=0;i<dp.length;i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private static BigDecimal maxDotProduct2(int[] A, int[] B, int n, int m) {
        BigDecimal[][] dp = new BigDecimal[n+1][m+1];

        for(int i=0;i<=n;i++) {
            dp[i] = new BigDecimal[m+1];
            for(int j=0;j<=m;j++) {
                dp[i][j] = new BigDecimal(0);
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                BigDecimal product = new BigDecimal(A[i-1]).multiply(new BigDecimal(B[j-1]));
                BigDecimal temp = dp[i-1][j-1].add(product);
                if(i==j) {
                    dp[i][j] = temp;
                }
                else {
                    dp[i][j] = (dp[i-1][j].compareTo(temp) > 0)?dp[i-1][j]:temp;
                }
            }
        }

        return dp[n][m];
    }


}
