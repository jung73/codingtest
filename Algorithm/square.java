import java.util.Scanner;

public class square {
    static int n;
    static long k;

    public static long square(int n, long k) {
        if (k==0) return 1;

        long half=square(n, k/2);

        long ans=(half*half)%25919;

        if (k%2==1) {
            ans=(ans*n)%25919;
        }

        return ans;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            n = sc.nextInt();
            k = sc.nextLong();

            long ans=square(n, k);
            System.out.println(ans);
        }

    }
}
