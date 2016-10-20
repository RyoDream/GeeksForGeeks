package DynamicProgramming;

import java.util.Scanner;

/**
 * Letter Writer
 *
 * LOBO is a letter writer and he is working in shop near post office.
 * He has to write two types of letters which are:
 * 1. Corporate Letters: 12 letters of this type can be written in an hour.
 * 2. Informal Letters: 10 letters of this type can be written in an hour.
 *
 * You are to help him to save time.
 * Given N number of letters, print the minimum number of hours
 * he needs to put for combination of both the letters,
 * so that no time is wasted.
 */
public class LetterWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(countHours(n));
        }
    }

    private static int countHours(int n) {
        if(n%2 == 1)
            return -1;

        int min = Integer.MAX_VALUE;
        for(int i=0;i<14;i++) {
            for(int j=0;j<=15;j++) {
                if(i*12 + j*10 > n)
                    break;
                if(i*12 + j*10 == n)
                    if(min > i+j)
                        min = i+j;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
