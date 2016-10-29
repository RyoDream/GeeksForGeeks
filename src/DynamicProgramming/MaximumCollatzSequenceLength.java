package DynamicProgramming;

import java.util.Scanner;

/**
 * Maximum Collatz sequence length
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=837
 */
public class MaximumCollatzSequenceLength {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(maxCollatzLength(n));
        }
    }

    private static int maxCollatzLength(int n) {
        int max = 1;
        int[] cache = new int[n+1];

        for(int i=1;i<=n;i++) {
            int count = 1;
            int temp = i;

            while (temp != 1) {
                if(temp < i) {
                    count += cache[temp]-1;
                    break;
                }

                if(temp%2 == 0)
                    temp = temp/2;
                else
                    temp = 3*temp+1;

                count++;
            }
            cache[i] = count;
            max = Math.max(max, count);
        }

        return max;
    }
}
