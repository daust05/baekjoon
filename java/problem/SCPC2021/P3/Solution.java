package SCPC2021.P3;
/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static int Answer;
    static int N;
    static int K;
    static int[][] wideMap;
    static int[][] scoreMap;
    public static void main(String args[]) throws Exception {

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            int margin = K+1;
            wideMap = new int[N+2*margin][N+2*margin];
            scoreMap = new int[N+2*margin][N+2*margin];
            Answer = 0;
            sc.nextLine();
            for (int i = margin; i < N+margin; i++) {
                int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                System.arraycopy(arr,0, wideMap[i], margin,N);
            }
            for(int i = margin-1; i<= N+margin; i++){
                for(int j = margin-1; j<= N+margin; j++){
                    int score = getScore(i,j);
                    scoreMap[i][j] = score;
                    Answer = Math.max(Answer, score);
                }
            }
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
    private static int getScore(int x, int y){
        int score= scoreMap[x-1][y];
        for(int i = 0; i<K;i ++){
            for(int j = y-i; j <= y+i; j++){
                score -= wideMap[x-K+i][j];
            }
        }
        for(int i = 0; i<K;i ++){
            for(int j = y-(K-i-1); j <= y+(K-i-1); j++){
                score += wideMap[x+i][j];
            }
        }
        return score;
    }
}