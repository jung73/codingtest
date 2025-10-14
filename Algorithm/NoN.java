import java.util.Arrays;
import java.util.Scanner;

public class NoN {
    static int[] arr_L;

    public static int binary_Search_first(int[] L, int n, int q) {
        int low=0;
        int high= n-1;

        while (low<=high){
            int mid = (low+high)/2;

            if (L[mid]>=q) {
                high=mid-1;
            }
            else low=mid+1;

        }
        return low; //끝나면 ex) 2(high) 3(low) 3 3(mid) ... 5 가 되어있으니 low 반환
    }

    public static int binary_Search_last(int[] L, int n, int q) {
        int low=0;
        int high= n-1;

        while (low<=high){
            int mid = (low+high)/2;

            if (L[mid]>q) {
                high=mid-1;
            }
            else low=mid+1;

        }
        return high; //끝나면 ex) 2 3 3 3(mid) ... 3(high) 5(low) 가 되어있으니 high 반환
    }

    public static void main(String[] args) {
        //두 개의 리스트 입력, L=1,2,2,0,3 Q=1,2,3 -> 1(1이 하나), 2(2가 2개), 1(3이 하나)
        //Q의 각 숫자가 L에 몇개 있는지, input에 따라 output함
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            arr_L = new int[n];

            for(int i=0; i<n; i++) {
                arr_L[i] = sc.nextInt();
            }
            Arrays.sort(arr_L);

            for(int i=0; i<m; i++) {
                int target = sc.nextInt();
                int first =binary_Search_first(arr_L, n, target);
                int last = binary_Search_last(arr_L, n, target);
                System.out.print(last-first+1);
                System.out.print(" ");
            }
            System.out.println();

        }
    }
}
