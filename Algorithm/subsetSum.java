import java.util.Scanner;

public class subsetSum {
    static int n;
    static int[] arr;
    static int t;
    static boolean found;



    public static void countSubsetsSum(int a, long Sum) {
        if (a==n){
            if (Sum==t){
                found=true;
            }
            return;
        }

        if (found) return; //found=True 일 경우 더이상 찾지 않아도 됨
        /*
        if (Sum==t){
            found=true;
            return;
        } //만약 target 값이 나오는 부분집합을 찾았을 경우 바로 YES return
        if (a==n) return; //배열의 끝까지 다 찾았으면 종료
         */

        countSubsetsSum(a+1, Sum); //현재 a번째 원소가 필요없는 경우
        countSubsetsSum(a+1, Sum+arr[a]); //현재 a번째 원소를 더하는 경우


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); //제일 첫 줄 입력받는 testcase
        while(testCases-- >0){
            n = sc.nextInt();

            arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            t = sc.nextInt();

            found=false;
            countSubsetsSum(0,0); //배열 0번부터 재귀 시작

            if (found) System.out.println("YES");
            else System.out.println("NO");


        }


    }
}
