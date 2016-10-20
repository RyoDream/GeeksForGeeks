package DynamicProgramming;

import java.util.Scanner;

/**
 * Maximum Calorie
 * Kapil always likes to eat and he has a diet plan.
 * He has an array of elements indicating the calorie of food ,
 * he can consume in a day.
 *
 * In his diet plan he cannot eat on for three consecutive days.
 * But Kapil is very fond of eating ,
 * so he decided to take as much as calorie
 * despite remembering the fact that he cannot eat on three consecutive days.
 *
 * Help him in finding amount of calorie he could take.
 */
public class MaximumCalorie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] calorie = new int[n];
            for(int i=0;i<n;i++)
                calorie[i] = scanner.nextInt();
            System.out.println(maxCalorie(calorie));
        }
    }

    private static long maxCalorie(int[] calorie) {
        if(calorie.length < 3) {
            int res = 0;
            for(int c:calorie)
                res += c;
            return res;
        }

        long[] notEat = new long[calorie.length];
        long[] eat = new long[calorie.length];
        eat[0] = calorie[0];
        notEat[0] = 0;
        eat[1] = eat[0]+calorie[1];
        notEat[1] = eat[0];

        for(int i=2;i<calorie.length;i++) {
            eat[i] = Math.max(notEat[i-1], notEat[i-2]+calorie[i-1])+calorie[i];
            notEat[i] = Math.max(eat[i-1], notEat[i-1]);
        }

        return Math.max(eat[calorie.length-1], notEat[calorie.length-1]);
    }
}
