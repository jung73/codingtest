import java.util.Scanner;

public class GatheringScore {
    public static int Root(int[][] grid, int n, int m) {
        int[][] dp=new int[n][m];
        dp[0][0]=grid[0][0];

        for (int i=1;i<n;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0]; //첫번째 열은 위에서 내려와야함
        }

        for (int j=1;j<n;j++){
            dp[0][j]=grid[0][j]+dp[0][j-1]; //첫번째 행은 왼쪽에서 오른쪽으로 가야함
        }

        for(int i=1; i<n; i++) {
            for (int j=1; j<m; j++){
                dp[i][j]=grid[i][j]+Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] grid = new int[n][m];
            for(int i=0; i<n; i++) {
                 for (int j=0; j<m; j++){
                     grid[i][j]=sc.nextInt();
                 }
            }
            System.out.println(Root(grid, n, m));

        }
    }
}
