import java.util.Scanner;

public class Flood {
    //grid 그래프, 그래프들이 정사각형으로 이어져있다고 생각
    //무방향성, 가중치 그래프 dfs로

    public static int floodDFS(int[][] grid, int x, int y, int n, int m){
        if (grid[x][y]==1) return 0;
        grid[x][y]=1;
        int cnt=1; //자기자신 방문으로 1번으로 초기화
        if (x>0) cnt += floodDFS(grid, x-1, y, n, m);
        if (x<n-1) cnt += floodDFS(grid, x+1, y, n, m);
        if (y>0) cnt += floodDFS(grid, x, y-1, n, m);
        if (y<m-1) cnt += floodDFS(grid, x, y+1, n, m); //자기 자신을 기준으로 위 아래 양 옆 다 확인

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i=0; i<n; i++){
                for (int j=0; j<m ; j++){
                    grid[i][j]=sc.nextInt(); //그리드 그래프 만듦
                }
            }
            int x=sc.nextInt();
            int y=sc.nextInt();

            System.out.println(floodDFS(grid, x, y, n, m));


        }
    }
}
