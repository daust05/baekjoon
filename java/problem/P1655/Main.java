package P1655;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    private static int INITIAL = 50000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int pivot = INITIAL;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= pivot){
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }

            if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            else if(maxHeap.size()-minHeap.size() >1){
                minHeap.add(maxHeap.poll());
            }
            pivot = maxHeap.peek();
            bw.write(Integer.toString(pivot)+"\n");
        }
        bw.flush();
    }
}