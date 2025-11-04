import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TooMuchHomework {
    public static int MaximumScore(int[][] Homework, int n) {
        Arrays.sort(Homework, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Integer> scores = new PriorityQueue<>(); //점수 저장 큐
        int use_dates=0; //과제하느라 걸린 시간

        for (int i=0; i<n; i++){
            if (Homework[i][1]> use_dates){ //과제 할 기간이 남아있다면
                use_dates = use_dates+1;
                scores.add(Homework[i][0]); //스코어 입력
            }
            else if (!scores.isEmpty() && Homework[i][0]>scores.peek()){ //과제할 시간은 꽉찼지만, 더 점수가 높으면
                scores.poll();
                scores.add(Homework[i][0]); //빼고, 점수 높은 걸 넢음
            }

        }

        int total_score=0;
        while (!scores.isEmpty()){
            total_score = total_score + scores.poll();
        }
        return total_score;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int[][] Homework=new int[n][2];


            for (int i=0; i<n; i++) Homework[i][0]=sc.nextInt(); //score
            for (int i=0; i<n; i++) Homework[i][1]=sc.nextInt(); //due dates

            System.out.println(MaximumScore(Homework, n));


        }
        sc.close();
    }

}
