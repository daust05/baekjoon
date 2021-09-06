/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;
import java.io.FileInputStream;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
	static int Answer;
	static int groupNum;
	static int[] di;
	static int[] group;
	static int[] pre;

	public static void main(String args[]) throws Exception{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			int N = sc.nextInt();
			di = new int[N];
			group = new int[N];
			pre = new int[N];
			for(int i = 0; i < N; i++){
				di[i] = sc.nextInt();
				group[i] = -1;
				pre[i] = -1;
			}
			groupNum = 0;
			for(int i = 0; i < N; i++){
				if(pre[i] == -1 && group[i] == -1){
					groupNum += 1;
					DFS(i);
				}
			}

			Answer = groupNum;
			/////////////////////////////////////////////////////////////////////////////////////////////


			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static void DFS(int n){
	    if(group[n] != -1){
	        int t = pre[n];
			groupNum -= 1;
			while(t != -1){
				group[t] = group[n];
				t = pre[t];
			}
	    }
		else{
			group[n] = groupNum;
			if(n+di[n] <di.length){
				pre[n+di[n]] = n;
				DFS(n+di[n]);
			}
		}
		return;
	}
}