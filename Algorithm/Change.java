import java.util.Scanner;

public class Change {
    public static int MoneyChange(int money) {
        int[] exchange={50000, 10000, 5000, 1000}; //큰 금액권부터 순차적으로 확인

        int total_exchange=0;

        for (int i=0; i<4; i++){
            int num_exchange=money / exchange[i]; //해당 금액권으로 바꿔지는 장수

            total_exchange=total_exchange+num_exchange; //총 장수 업데이트

            money=money-(num_exchange*exchange[i]); //남은 금액 업데이트
        }

        return total_exchange;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int money=sc.nextInt();

            System.out.println(MoneyChange(money));


        }

    }
}
