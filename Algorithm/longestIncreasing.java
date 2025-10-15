import java.util.Scanner;

public class longestIncreasing {

    public static int LongestIncreasingSubsequence(int[] L, int n) {
        int[] LIS_last = new int[n]; //LIS에서 마지막이 되는 원소가 각 들어감
        LIS_last[0]=1;

        for (int i=1;i<=n-1;i++){
            LIS_last[i]=1;
            for (int j=0;j<=i-1;j++){
                if (L[i]>L[j]) LIS_last[i]=Math.max(LIS_last[i], LIS_last[j]+1);
            }
        }

        int max=LIS_last[0];

        for (int i=1;i<n;i++){
            if (max<LIS_last[i]) max=LIS_last[i];
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[] L = new int[n];
            for(int i=0; i<n; i++) {
                L[i] = sc.nextInt();
            }
            System.out.println(LongestIncreasingSubsequence(L, n));

        }

    }
}


