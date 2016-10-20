import java.util.Scanner;

/**
 * Skip the work
 *
 * Given an array A[ ] denoting the time taken to complete N tasks,
 * determine the minimum amount of time required to finish the tasks
 * considering that you can skip any task, but skipping two consecutive tasks is forbidden.
 *
 * For example
 * For the array arr [] = {10, 5, 2, 4, 8, 6, 7, 10}
 * the output will be  22  (Skip the tasks taking more time ,
 * avoiding consective skipping(10,8,10).
 * Tasks done in: 5+2+4+6+7)
 */
public class SkipTheWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(skipTheWork(nums));
        }
    }

    private static int skipTheWork(int[] nums) {
        int lastSkip = 0;
        int lastNoSkip = 0;

        for(int i=0;i<nums.length;i++) {
            int temp = lastNoSkip;
            lastNoSkip = Math.min(lastNoSkip, lastSkip) + nums[i];
            lastSkip = temp;
        }

        return Math.min(lastNoSkip, lastSkip);
    }

}
