import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ClassroomAssinment {
    public static int Classroom(int[][] c, int n) {
        Arrays.sort(c, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> classendtimes = new PriorityQueue<>(); //종료시간 저장 큐

        classendtimes.add(c[0][1]); //각 강의실의 수업 끝나는 시간

        for (int i=1; i<n; i++){
            if (c[i][0]>= classendtimes.peek()){
                classendtimes.poll();
            }
            classendtimes.add(c[i][1]);

        }
        return classendtimes.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int[][] Class=new int[n][2];

            for (int i=0; i<n; i++) Class[i][0]=sc.nextInt();
            for (int i=0; i<n; i++) Class[i][1]=sc.nextInt();

            System.out.println(Classroom(Class, n));


        }

    }
}
