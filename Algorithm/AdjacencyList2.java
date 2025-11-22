import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int v; //정점
    int w; //가중치
    public Edge (int v, int w){
        this.v=v;
        this.w=w;
    }

    @Override
    public int compareTo(Edge e)
    {
       return this.v-e.v;
    }

}

public class AdjacencyList2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt(); //정점개수
            int m = sc.nextInt(); //간선개수

            ArrayList<Edge>[] graph = new ArrayList[n];
            for (int i=0; i<n; i++){
                graph[i] = new ArrayList<Edge>();
            }
            for (int i=0; i<m; i++){
                int u = sc.nextInt(); //정점
                int v = sc.nextInt(); //u랑 이어지는 정점
                int w = sc.nextInt(); //u에서 v로 가는 가중지가 w인 그래프

                graph[u].add(new Edge(v,w));
            }
            for (int i=0; i<n; i++){
                Collections.sort(graph[i]);
                for (Edge e :graph[i]){
                    System.out.print(e.v); //한 줄에 출력하고 싶으니 ln 안씀
                    System.out.print(" ");
                }
                System.out.println();
                for (Edge e :graph[i]){
                    System.out.print(e.w); //한 줄에 출력하고 싶으니 ln 안씀
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

    }
}
