import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class p14888 {
    public static void main(String[] args) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int back = 0;
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            String[] cmd = s.split(" ");
            if(cmd[0].equals("push")){
                int num = Integer.parseInt(cmd[1]);
                queue.offer(num);
                back = num;
                continue;
            }
            else if(cmd[0].equals("front")){
                if(!queue.isEmpty()){
                    bw.write(Integer.toString(queue.peek()));
                }
                else{
                    bw.write("-1");
                }
            }
            else if(cmd[0].equals("back")){
                if(!queue.isEmpty()){
                    bw.write(Integer.toString(back));
                }
                else{
                    bw.write("-1");
                }
            }
            else if(cmd[0].equals("size")){
                bw.write(Integer.toString(queue.size()));
            }
            else if(cmd[0].equals("empty")){
                if(queue.isEmpty()){
                    bw.write("1");
                }
                else{
                    bw.write("0");
                }
            }
            else if(cmd[0].equals("pop")){
                if(!queue.isEmpty()){
                    bw.write(Integer.toString(queue.poll()));
                }
                else{
                    bw.write("-1");
                }
            }
            else{
                bw.write("wrong command: " + s);
            }
            bw.write("\n");
        }
        bw.flush();
        in.close();
        bw.close();
    }
}
