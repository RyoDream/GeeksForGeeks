import java.util.Scanner;

/**
 * Longest Increasing Subsequence
 *
 * Given a sequence,
 * find the length of the longest subsequence of a given sequence .
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int l = scanner.nextInt();
            int[] array = new int[l];
            for(int i=0;i<l;i++)
                array[i] = scanner.nextInt();
            System.out.println(lis(array));
        }
    }

    private static int lis(int[] a) {
        int max = 0;
        int[] dp = new int[a.length];
        for(int i=0;i<a.length;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(a[i]>a[j] && dp[i]<=dp[j])
                    dp[i] = dp[j] + 1;
            }
        }

        for(int n:dp) {
            max = Math.max(max, n);
        }

        return max;
    }
}
