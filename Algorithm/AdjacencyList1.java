import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdjacencyList1 {
    //정점이 0~4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt(); //정점개수
            int m = sc.nextInt(); //간선개수

            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i=0; i<n; i++){
                graph[i] = new ArrayList<Integer>();
            }
            for (int i=0; i<m; i++){
                int u = sc.nextInt(); //정점
                int v = sc.nextInt(); //u랑 이어지는 정점

                graph[u].add(v);
                graph[v].add(u);
            }
            for (int i=0; i<n; i++){
                Collections.sort(graph[i]);
                for (int v:graph[i]){
                    System.out.print(v); //한 줄에 출력하고 싶으니 ln 안씀
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
