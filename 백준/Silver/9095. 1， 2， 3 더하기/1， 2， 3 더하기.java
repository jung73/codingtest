import java.util.Scanner;

public class Main {
    static int n;

    public static int plus(int n) {
        int[] dp = new int[n+1];

        if (n>=1) dp[1]=1; //한 개는 한 번에 끝
        if (n>=2) dp[2]=2; //(1+1) (2)
        if (n>=3) dp[3]=4; //(1+1+1) (1+2) (2+1) (3) 총 네 번
        if (n>=4) dp[4]=7; //(1+1+1+1) (1+3) (3+1) (4) 등..
        for(int i = 5; i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3]);
        }

        return dp[n];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            n = sc.nextInt();

            int ans=plus(n);
            System.out.println(ans);

        }
    }
}
