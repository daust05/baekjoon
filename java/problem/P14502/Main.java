package P14502;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        List<List<Integer>> zeroes = new ArrayList<>();
        sc.nextLine();
        for(int i = 0; i < N; i++){
            arr[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j< M; j++){
                if(arr[i][j] == 0){
                    zeroes.add(List.of(i,j));
                }
            }
        }
        int max = -1;
        for(int i = 0; i < zeroes.size(); i++){
            makeWall(zeroes.get(i));
            for(int j = i+1; j < zeroes.size(); j++){
                makeWall(zeroes.get(j));
                for(int k = j+1; k < zeroes.size(); k++){
                    makeWall(zeroes.get(k));
                    int safePlace = findSafe();
                    if(safePlace > max){
//                        System.out.println(i + " " + j + " " + k + " :" + safePlace);
                        max = safePlace;
                    }
                    removeWall(zeroes.get(k));
                }
                removeWall(zeroes.get(j));
            }
            removeWall(zeroes.get(i));
        }
        System.out.println(max);
    }

    private static int findSafe(){
        int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] arrCopy = new int[N][M];
        for(int i = 0; i < N; i++){
            arrCopy[i] = arr[i].clone();
        }
        Queue<List<Integer>> poses = new LinkedList<>();
        for(int i = 0; i< N; i++){
            for(int j =0; j< M; j++){
                if(arr[i][j] == 2){
                    poses.add(List.of(i,j));
                }
            }
        }
        while(!poses.isEmpty()){
            List<Integer> pos = poses.remove();
            int x = pos.get(0);
            int y = pos.get(1);
            for(int i = 0; i < 4; i++){
                int newX = x + move[i][0];
                int newY = y + move[i][1];
                if(!(newX < 0 || newY < 0 || newX >= N || newY >= M)){
                    if (arrCopy[newX][newY] == 0) {
                        arrCopy[newX][newY] = 2;
                        poses.add(List.of(newX,newY));
                    }
                }
            }
        }
        Long count = getCount(arrCopy);

        return Long.valueOf(count).intValue();
    }

    private static long getCount(int[][] arrCopy) {
        return Arrays.stream(arrCopy)
                .flatMapToInt(Arrays::stream)
                .filter(p -> p == 0)
                .count();
    }

    private static void makeWall(List<Integer> pos){
        int x = pos.get(0);
        int y = pos.get(1);
        arr[x][y] = 1;
    }

    private static void removeWall(List<Integer>pos){
        int x = pos.get(0);
        int y = pos.get(1);
        arr[x][y] = 0;
    }
}
