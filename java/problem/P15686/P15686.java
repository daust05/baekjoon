package P15686;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P15686 {
    static int M;
    static int N;
    static List<XY> chicks;
    static List<XY> homes;
    static List<List<Integer>> dist;
    static class XY{
        int x;
        int y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int[][] city = new int[N][N];
        homes = new ArrayList<>();
        chicks = new ArrayList<>();
        dist = new ArrayList<>();

        setCity(sc, city);
        setDistance();

        int answer = getMinDistance(chicks.size(), 0);
        System.out.println(answer);
    }

    private static int getMinDistance(int chickNum, int index){
        int min = 2* N * homes.size();
        if (chickNum == M){
            int distSum = 0;
            for(int i = 0; i < homes.size(); i++){
                int minDist = 2* N;
                for(int j = 0; j< chickNum; j++){
                    Integer chickDist = dist.get(j).get(i);
                    if(chickDist < minDist){
                        minDist = chickDist;
                    }
                }
                distSum += minDist;
            }
            return distSum;
        }
        else{
            for(int i = index; i < chickNum; i++){
                List<Integer> remove = dist.remove(i);
                int distance = getMinDistance(chickNum-1,i);
                dist.add(i,remove);

                if(distance < min){
                    min = distance;
                }
            }
        }
        return min;
    }


    private static void setDistance() {
        for(int i = 0; i < chicks.size(); i++){
            XY chick = chicks.get(i);
            List<Integer> chickDist = new ArrayList<>();
            for(int j = 0; j < homes.size(); j++){
                XY home = homes.get(j);
                chickDist.add(Math.abs(chick.x - home.x) + Math.abs(chick.y - home.y));
            }
            dist.add(chickDist);
        }
    }

    private static void setCity(Scanner sc, int[][] city) {
        sc.nextLine();
        for(int i = 0; i < N; i++){
            city[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j< N; j++){
                if(city[i][j] == 1){
                    homes.add(new XY(i,j));
                }
                else if(city[i][j] == 2){
                    chicks.add(new XY(i,j));
                }
            }
        }
    }
}
