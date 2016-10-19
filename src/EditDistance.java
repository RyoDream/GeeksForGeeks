import java.util.Scanner;

/**
 * Edit Distance
 *
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
 */
public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(EditDistance(s1, s2));
        }
    }

    public static int EditDistance(String s, String t) {
        int[][] distance = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++)
            distance[i][0] = i;
        for(int j=0;j<t.length()+1;j++)
            distance[0][j] = j;

        for(int j=1;j<t.length()+1;j++) {
            for(int i=1;i<s.length()+1;i++) {
                int insertion = distance[i][j-1]+1;
                int deletion = distance[i-1][j]+1;
                int match = distance[i-1][j-1];
                int mismatch = distance[i-1][j-1]+1;

                if(s.charAt(i-1) == t.charAt(j-1))
                    distance[i][j] = Math.min(Math.min(insertion, deletion), match);
                else
                    distance[i][j] = Math.min(Math.min(insertion, deletion), mismatch);
            }
        }
        return distance[s.length()][t.length()];
    }

}
