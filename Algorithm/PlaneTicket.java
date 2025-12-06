import java.util.*;

class Edge2 implements Comparable<Edge2>{
    int v; //정점 : 도착지
    int w; //가중치 : 비용
    public Edge2 (int v, int w){
        this.v=v;
        this.w=w;
    }

    @Override
    public int compareTo(Edge2 e)
    {
        return this.w-e.w;
    }

}

class Info implements Comparable<Info>{
    int v; //도착지
    long cost;
    int used; //0: 안씀, 1: 씀

    public Info(int v, long cost, int used){
        this.v=v;
        this.cost=cost;
        this.used=used;
    }

    @Override
    public int compareTo(Info other){ return Long.compare(this.cost, other.cost);}
}
public class PlaneTicket {
    public static long plane(int n, ArrayList<Edge2>[] graph) {
        long[][] dist = new long[n][2]; // dist[i][0] : 티켓 안 쓰고 i 도착, dist[i][1] : 티켓 쓰고 i 도착

        for (int i =0; i<n; i++){
            Arrays.fill(dist[i], Long.MAX_VALUE); //무한대로 초기화
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();

        dist[0][0]=0;
        pq.offer(new Info(0, 0, 0));

        while (!pq.isEmpty()){
            Info current=pq.poll();

            int u = current.v;
            long c = current.cost;
            int used = current.used;

            if (c>dist[u][used]) continue; //더 짧은 경로가 이미 있다면 스킵

            for (Edge2 next : graph[u]){
                int v = next.v;
                int w = next.w;

                //티켓 사용 x
                if (dist[v][used] > c + w){
                    dist[v][used] = c+w;
                    pq.offer(new Info(v, dist[v][used], used));
                }

                //티켓 사용
                if (used==0){
                    if (dist[v][1]>c){
                        dist[v][1]=c;
                        pq.offer(new Info(v, dist[v][1], 1));
                    }
                }
            }
        }
        return Math.min(dist[n-1][0], dist[n-1][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt(); //정점개수
            int m = sc.nextInt(); //간선개수

            ArrayList<Edge2>[] graph = new ArrayList[n];
            for (int i=0; i<n; i++){
                graph[i] = new ArrayList<>();
            }
            for (int i=0; i<m; i++){
                int u = sc.nextInt(); //정점
                int v = sc.nextInt(); //u랑 이어지는 정점
                int w = sc.nextInt();

                graph[u].add(new Edge2(v,w));
            }

            System.out.println(plane(n, graph));
        }
    }



}
