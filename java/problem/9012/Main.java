import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            Stack<Character> stack = new Stack<>();
            String s = in.readLine();
            for(int j = 0; j<s.length();j++){
                char c = s.charAt(j);
                if(c == '('){
                    stack.add('(');
                }
                else if(c == ')'){
                    if(!stack.empty()){
                        stack.pop();
                    }
                    else{
                        stack.add(')');
                        break;
                    }
                }
                else{
                    bw.write("wrong\n");
                }
            }
            if(stack.empty()){
                bw.write("YES\n");
            }
            else{
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
        in.close();
    }
}
