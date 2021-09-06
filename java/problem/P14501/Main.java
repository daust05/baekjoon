package P14501;

import java.io.FileInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // Scanner sc = new Scanner(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int max = 0;

        for(int i = 1; i<= N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++){
            DP[i] = Math.max(DP[i],max);

            if(i + T[i] -1 <= N){
                DP[i+T[i]-1] = Math.max(DP[i+T[i]-1],P[i]+ DP[i-1]);
            }
            max = DP[i];
            // for(int j =1; j<= N; j++){
            //     System.out.print(DP[i]+" ");
            // }
            // System.out.println();
        }
        
        System.out.println(max);
    }
}
