import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge3 {
    int v; //정점
    int w; //가중치
    public Edge3 (int v, int w){
        this.v=v;
        this.w=w;
    }
}

public class LongestPath {
    public static void PathSolve(int n, ArrayList<Edge3>[] graph, int[] inDegree) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MIN_VALUE); //거리 최솟값으로 초기화

        dist[0]=0; //시작점, 거리 0

        Queue<Integer> q = new LinkedList<>(); //위상정렬 큐

        for (int i=0; i<n; i++){
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()){
            int u= q.poll();

            for (Edge3 e: graph[u]){ //u와 연결된 모든 다음 정점 체크
                int v = e.v;
                int w = e.w;

                if (dist[u] != Long.MIN_VALUE){
                    if (dist[v]<dist[u] + w) dist[v] = dist[u] + w;
                    //시작점에서 u까지 도달가능한 최장 경로 갱신
                }

                inDegree[v]--; //간선 제거
                if (inDegree[v] == 0) q.offer(v);
            }
        }

        System.out.println(dist[n-1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 t
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line);

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 정점 개수
            int m = Integer.parseInt(st.nextToken()); // 간선 개수

            ArrayList<Edge3>[] graph = new ArrayList[n]; //그래프
            int[] inDegree = new int[n]; //진입 차수
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 정보 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                // 양방향 연결 (무방향 그래프)
                graph[u].add(new Edge3(v, w));
                inDegree[v]++;
            }

            PathSolve(n, graph, inDegree);
        }
    }
}
