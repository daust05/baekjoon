package P14888;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int maxNum = -1000000000;
    private static int minNum = 1000000000;
    private static int N;
    private static int[] arr;
    // private static int[] cal;
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        N = Integer.parseInt(sc.nextLine());
        arr = new int[N];
        int[] cal;
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cal = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solve(arr[0], 1, cal);
        System.out.println(maxNum);
        System.out.println(minNum);
        sc.close();
    }
    private static void solve(int sum, int n, int[] cal){
        if(n == N){
            if(sum > maxNum){
                maxNum = sum;
            }
            if(sum < minNum){
                minNum = sum;
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            int calNum = sum;
            if(cal[i] == 0){
                continue;
            }

            if(i == 0){
                calNum += arr[n];
            }
            else if(i == 1){
                calNum -= arr[n];
            }
            else if(i == 2){
                calNum *= arr[n];
            }
            else{
                calNum /= arr[n];
            }
            cal[i] -= 1;
            solve(calNum, n+1, cal);
            cal[i] += 1;
        }
    }
}
