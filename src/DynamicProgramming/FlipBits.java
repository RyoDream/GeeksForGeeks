package DynamicProgramming;

import java.util.Scanner;

/**
 * Flip Bits
 *
 * Given an array arr[] consisting of 0’s and 1’s.
 * A flip operation is one in which you turn 1 into 0 and a 0 into 1.
 * You have to do atmost one “Flip” operation on a subarray.
 * Then finally display maximum number of 1 you can have in the array.
 */
public class FlipBits {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] bits = new int[n];
            for(int i=0;i<n;i++)
                bits[i] = scanner.nextInt();
            System.out.println(flipBits(bits));
        }
    }

    private static int flipBits(int[] bits) {
        int orig_one_count = 0;
        int max_diff = 0;
        int curr_max = 0;

        for(int i=0;i<bits.length;i++) {
            if(bits[i] == 1)
                orig_one_count++;

            int val = (bits[i] == 0)?1:-1;
            curr_max = Math.max(val, curr_max+val);
            max_diff = Math.max(max_diff, curr_max);
        }

        max_diff = Math.max(max_diff, 0);

        return orig_one_count+max_diff;
    }

    private static int flipBits2(int[] bits) {
        int max_diff = 0;
        int original_ones = 0;

        for(int i=0;i<bits.length;i++) {
            if(bits[i] == 1)
                original_ones++;

            int count_0 = 0;
            int count_1 = 0;

            for(int j=i;j<bits.length;j++) {
                if(bits[j] == 1)
                    count_1++;
                else
                    count_0++;

                max_diff = Math.max(max_diff, count_0-count_1);
            }
        }

        return original_ones+max_diff;
    }

}
