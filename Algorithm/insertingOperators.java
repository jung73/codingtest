import java.util.Scanner;

public class insertingOperators {
    public static int countopers(int n, int i, int[] opers, int T) {
        if (n-1 ==i){
            int res=0; //계산한 최종 결과물
            int curnum =1; //맨 처음 계산할 숫자
            int curop =1; //앞에 있는 숫자가 뭔지
            // 연산자가 없을 때는 *10 +뒤의 숫자
            // +1 일 때는 res+=curnum
            // -1 일 때는 res-=curnum
            for (int j = 0; j < n-1; j++) {
                if (opers[j] == 0) curnum = curnum * 10 + j + 2;
                else {
                    if (curop == 1) res += curnum;
                    else res -= curnum;
                    curnum = j + 2;
                    curop = opers[j];
                }
            }
            if (curop == 1) res += curnum;
            else res -= curnum;
            if (res == T) return 1;
            else return 0;
            //목표 숫자랑 같으면 1 다르면 0 반환
        }
        else {
            int res = 0;
            opers[i] = 0;
            res += countopers(n, i + 1, opers, T);
            opers[i] = 1;
            res += countopers(n, i + 1, opers, T);
            opers[i] = -1;
            res += countopers(n, i + 1, opers, T);
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int T = sc.nextInt();
            int[] ops = new int[n-1]; //연산자
            System.out.println(countopers(n,0, ops, T));
            }
    }
}
