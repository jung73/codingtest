import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ComputerVirus {
    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int u) {
        visited[u] = true; // 현재 컴퓨터 방문 체크

        // 연결된 이웃 컴퓨터들을 확인 (AL1.java 스타일)
        for (int v : graph[u]) {
            if (!visited[v]) { // 아직 감염 안 된 컴퓨터라면
                dfs(graph, visited, v); // 재귀적으로 전파
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 속도를 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 t
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터(정점) 개수
            int m = Integer.parseInt(st.nextToken()); // 연결(간선) 개수

            // 1. 그래프 생성 (AL1.java 스타일: 인접 리스트)
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            // 2. 간선 정보 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                // 양방향 연결 (무방향 그래프)
                graph[u].add(v);
                graph[v].add(u);
            }

            // 3. 연결 요소(덩어리) 개수 세기
            boolean[] visited = new boolean[n]; // 방문 여부 체크 (감염 여부)
            int attacks = 0; // 필요한 공격 횟수

            for (int i = 0; i < n; i++) {
                // 아직 감염되지 않은 컴퓨터를 발견하면
                if (!visited[i]) {
                    attacks++; // 공격 횟수 1 증가 (새로운 덩어리 발견)
                    dfs(graph, visited, i); // 연결된 모든 컴퓨터 감염 시키기
                }
            }

            System.out.println(attacks);
        }
    }
}
