import java.util.Scanner;

public class Bossam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[] des = new int[n];
            int maxdes=1;
            for(int i=0; i<n; i++) {
                des[i] = sc.nextInt();
                if (maxdes < des[i]) maxdes=des[i];
            }
            int amount=sc.nextInt();

            int low=1;
            int high=maxdes;

            while (low <= high){
                int mid = (low+high)/2;
                int pieces=0;
                for (int j=0; j<n; j++){
                    if (mid>des[j]) pieces +=des[j];
                    else pieces += mid;
                    if (pieces > amount) break;
                }
                if (pieces>amount) high=mid-1;
                else low=mid+1;
            }
            System.out.println(high);

        }
    }
}
