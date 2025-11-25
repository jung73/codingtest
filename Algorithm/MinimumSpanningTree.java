import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge1{
    int v;
    int w;
    public Edge1(int v, int w){
        this.v=v;
        this.w=w;
    }
}

class Wedge implements Comparable<Wedge> {
    int u, v, w;
    public Wedge(int u, int v, int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }

    @Override
    public int compareTo(Wedge e)
    {
        return this.w-e.w;
    }

}

public class MinimumSpanningTree {
    public static int find(int u, int[] parent){
        if (u==parent[u]) return u;
        parent[u]=find(parent[u], parent);
        return parent[u]; //부모님 찾은 후 반환
        // 시간이 오래 걸려 timelimit 걸림, return에 find함수 호출이 아닌 코드 안에서 호출 후 parent[u]만 리턴
    }

    public static void union(int u, int v, int[] parent){
        u=find(u, parent);
        v=find(v, parent);
        parent[u]=v;
        //rank를 사용하는 방법도 있음. 교수님 코드 참고
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            Wedge[] edges = new Wedge[m];

            for (int i=0; i<m; i++){
                int u, v, w;
                u=sc.nextInt();
                v=sc.nextInt();
                w=sc.nextInt();
                
                edges[i]=new Wedge(u,v,w);
            }
            Arrays.sort(edges);
            int weight = 0;
            int[] parent = new int[n];
            for (int i=0; i<n; i++) parent[i]=i; //처음엔 자기 자신을 갖도록 초기화
            for (int i=0; i<m; i++){
                int u=edges[i].u;
                int v=edges[i].v;
                int w=edges[i].w;

                if (find(u, parent) != find(v,parent)){
                    weight += w;
                    union(u, v, parent);
                }
            }
            System.out.println(weight);
        }


    }
}
