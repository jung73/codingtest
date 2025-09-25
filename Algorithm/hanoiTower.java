import java.util.Scanner;

public class hanoiTower {
    static int t;
    static int n;


    public static void hanoi(int n, char start, char mid, char dest) {
        if (n==1) {
            System.out.printf("%c %c %d\n",start, dest, n);
        }
        else {
            hanoi(n - 1, start, dest, mid);
            System.out.printf("%c %c %d\n", start, dest, n);
            hanoi(n - 1, mid, start, dest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t= sc.nextInt(); //제일 첫 줄 입력받는 testcase
        while(t-- >0){
            n = sc.nextInt();

            hanoi(n, 'A', 'B', 'C');

        }

    }
}
