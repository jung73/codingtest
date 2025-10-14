import java.util.Scanner;

public class longestPalindrome {
    static int n;

    public static int LongestPalindromeSubsequence(String s, int n) {
        int[][] LPS = new int[n][n];
        for (int i=0; i<n; i++) LPS[i][i]=1;

        for (int i=1;i<n-1;i++){
            if (s.charAt(i)==s.charAt(i+1)) LPS[i][i+1]=2;
            else LPS[i][i+1]=1;
        }

        for (int i=n-3;i>=0;i--){
            for (int j=i+2;j<n;j++){
                if (s.charAt(i)==s.charAt(j)) LPS[i][j]=LPS[i+1][j-1]+2;
                else LPS[i][j]=Math.max(LPS[i+1][j],LPS[i][j-1]);
            }
        }

        return LPS[0][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            n = sc.nextInt();
            sc.nextLine();

            String s = sc.nextLine();

            int ans=LongestPalindromeSubsequence(s, n);
            System.out.println(ans);

        }

    }
}
