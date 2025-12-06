import java.util.*;

public class MazeRun {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; //상하좌우 이동 배열

    public static int Maze(int n, int m, int[][] maze){
        int[][] dist = new int[n][m]; //방문 여부 및 거리 저장 배열
        for (int i=0; i<n; i++){
            Arrays.fill(dist[i], -1); //초기값 -1
        }

        Queue<int[]> q = new ArrayDeque<>(); //BFS 큐

        dist[0][0] = 0;//시작점
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()){
            int[] current = q.poll();
            int r= current[0]; //행
            int c= current[1]; //열

            if (r==n-1&&c==m-1){ return dist[r][c]; }//도착점 도달 시 거리 반환

            for (int i=0; i<4; i++){
                int maze_r = r+ dx[i];
                int maze_c = c+ dy[i];

                if (maze_r>=0&& maze_c>=0&&maze_r<n&&maze_c<m){ //미로 이내
                    if (maze[maze_r][maze_c] == 1 && dist[maze_r][maze_c] == -1){
                        //길이 있고, 아직 마킹 전이면
                        dist[maze_r][maze_c] = dist[r][c] + 1; //거리 1 증가
                        q.offer(new int[] {maze_r, maze_c});
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt(); // 행
            int m = sc.nextInt(); // 열

            int[][] maze = new int[n][m];

            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    maze[i][j]= sc.nextInt(); //미로 input
                }
            }


            System.out.println(Maze(n, m, maze));
        }
    }
}
