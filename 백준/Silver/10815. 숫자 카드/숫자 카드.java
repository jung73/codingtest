import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr_L;
    static int[] arr_Q;
    static int target;

    public static int binary_Search(int[] L, int q) {
        int low=0;
        int high= L.length-1;

        while (low<=high){
            int mid = (low+high)/2;

            if (L[mid]==q) return 1; //찾는 값일시 1 반환
            else if (L[mid]<q) low=mid+1; //찾는 값이 중간보다 크면, 탐색 범위 오른쪽으로
            else high=mid-1; //찾는 값이 중간보다 작으면, 탐색 범위 왼쪽으로

        }
        return 0; //찾는 값 없으면 0 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            arr_L = new int[n];


            for(int i=0; i<n; i++) {
                arr_L[i] = sc.nextInt();
            }
        Arrays.sort(arr_L);

        int m = sc.nextInt();
        arr_Q = new int[m];
            for(int i=0; i<m; i++) {
                arr_Q[i] = sc.nextInt();
            }


            for(int i=0; i<m; i++){
                target=arr_Q[i];
                int result=binary_Search(arr_L, target);
                System.out.println(result);
            }


    }
}