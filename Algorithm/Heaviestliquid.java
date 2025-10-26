import java.util.Arrays;
import java.util.Scanner;

public class Heaviestliquid {
    public static long HeaviestLiquid(int[][] L, int n, long c) {
        //L을 w/v 밀도 순으로 sort
        Arrays.sort(L, (a,b) ->{
            long ValA=(long) a[1] * b[0]; //[1]은 무게, [0]은 크기
            long ValB=(long) b[1] * a[0];
            return Long.compare(ValB, ValA); //내림차순
        });

        double w=0;
        for (int i=0;i<n;i++){
            if (c<=L[i][0]){
                w = w+ (double) c*L[i][1]/L[i][0];
                return (long) w;
            }
            else {
                w=w+L[i][1];
                c=c-L[i][0];
            }
        }
        return (long) w;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[][] L=new int[n][2];
            for (int i=0;i<n;i++) L[i][0]=sc.nextInt();
            for (int i=0;i<n;i++) L[i][1]=sc.nextInt();
            long p = sc.nextLong();
            System.out.println(HeaviestLiquid(L, n, p));
        }
    }
}
