import java.io.*;
import java.util.*;

public class Heaviestliquid {
    public static long HeaviestLiquid(int[][] L, double[] density, int n, long c) {
        //L을 w/v 밀도 순으로 sort
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> Double.compare(density[b], density[a]));

        double w=0;
        for (int i=0;i<n;i++){
            int index=idx[i];

            int volume=L[index][0]; //부피
            int weight=L[index][1]; //무게

            if (c<=volume){
                w = w+ (double) c*density[index];
                return (long) w;
            }
            else {
                w=w+weight;
                c=c-volume;
            }
        }
        return (long) w;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t= Integer.parseInt(br.readLine());

        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            int[][] L=new int[n][2];
            double[] density= new double[n];

            st = new StringTokenizer(br.readLine());
            for (int i=0;i<n;i++) L[i][0]=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i=0;i<n;i++) L[i][1]=Integer.parseInt(st.nextToken());

            for (int i=0; i<n; i++) density[i]=(double) L[i][1] / L[i][0];
            long p = Long.parseLong(br.readLine());

            System.out.println(HeaviestLiquid(L, density, n, p));
        }
    }
}
