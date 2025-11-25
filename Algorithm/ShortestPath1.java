import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Edge1>[] graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Edge1>();
            }

            for (int i = 0; i < m; i++) {
                int u, v, w;
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();

                graph[u].add(new Edge1(v, w));
            }
            PriorityQueue<Dist> h = new PriorityQueue<>();
            h.offer(new Dist(0,0));
            boolean[] fixed = new boolean[n];
            for (int i=0; i<n; i++) fixed[i] = false;
            int[] dist = new int[n];
            while (h.size()>0){
                Dist d = h.poll(); //dist 작은 것부터 하나하나 해나감
                if (!fixed[d.v]){
                    fixed[d.v]=true;
                    dist[d.v]=d.w; //최단 경로 길이 확정

                    for (Edge1 e: graph[d.v]){
                        h.offer(new Dist(e.v, d.w+e.w)); //새로운 최단 경로
                    }
                }
            }
            if (fixed[n-1]) System.out.println(dist[n-1]); //최단 경로가 있을 때, dist 출력
            else System.out.println("-1"); //최단경로 없을 때, -1 출력
        }
    }
}
