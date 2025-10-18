import java.util.Scanner;

public class MinimumPalindromeSubdivision {
    //palindrome 끼리 나눠서, 그 개수가 가장 적어지게

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            String s = sc.next();
            boolean[][] ispal = new boolean[n][n];
            for (int j = 0; j < n; j++) ispal[j][j] = true;
            for (int j = 0; j < n - 1; j++) {
                if (s.charAt(j) == s.charAt(j+1)) ispal[j][j+1] = true;
                else ispal[j][j+1] = false;
            }
            for (int j = n - 1; j >= 0; j--) {
                for (int k = j + 2; k < n; k++) {
                    if (s.charAt(j) == s.charAt(k)) ispal[j][k] = ispal[j + 1][k - 1];
                    else ispal[j][k] = false;
                }
            }
            int[] ps = new int[n];
            for (int j = 0; j < n; j++) {
                if (ispal[0][j]) {
                    ps[j] = 1;
                    continue;
                }
                ps[j] = j + 1;
                for (int k = 1; k <= j; k++) {
                    if (ispal[k][j]) ps[j] = Math.min(ps[k - 1] + 1, ps[j]);
                }
            }
            System.out.println(ps[n-1]);

        }

    }
}
