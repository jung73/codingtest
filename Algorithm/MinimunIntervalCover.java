import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Interval implements Comparable<Interval>{
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval p){
        return this.start - p.start;
    }
}

public class MinimunIntervalCover {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();

            int[] start = new int[n];
            int[] ends = new int[n];
            Interval[] intervals = new Interval[n];
            for (int i=0; i<n; i++) start[i]= sc.nextInt();
            for (int i=0; i<n; i++) ends[i]= sc.nextInt();
            for (int i=0; i<n; i++) intervals[i]= new Interval(start[i],ends[i]);
            Arrays.sort(intervals);

            int cur = intervals[0].start;
            int cnt = 0;
            int i=0;

            while (i<n){
                cur = Math.max(cur, intervals[i].start);
                int reach = cur;
                while (i<n && intervals[i].start <= cur){
                    reach = Math.max(reach, intervals[i].end);
                    i += 1;
                }
                if (cur != reach) cnt +=1;
                cur = reach;
            }

            System.out.println(cnt);

            // class의 comparto를 통해 비교를 하고, Arrays.sort 적용하면 sort가 됨
            //cur:커버하지 않은 것 중 제일 앞, 정렬한 interval 중 제일 앞
            //커버하는 데 쓴 개수
            //reach는 커버할거, while 안의 while문을 통해 제일 큰 interval을 찾으려고 함



        }

    }
}
