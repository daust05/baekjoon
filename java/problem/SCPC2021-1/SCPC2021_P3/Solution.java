/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
	static String Answer;

	public static void main(String args[]) throws Exception	{
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

			Answer = "";
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			ArrayList<HashSet<Integer>> arr = new ArrayList<HashSet<Integer>>();
			for(int i = 0; i <= n; i ++){
				arr.add(new HashSet<Integer>());
				arr.get(i).add(i);
			}
			for(int i = 0; i < m; i ++){
				int start = sc.nextInt();
				int dest = sc.nextInt();
				arr.get(dest).addAll(arr.get(start));
			}
			char[] ans = new char[k];
			for(int i = 0; i < k; i++){
				int start = sc.nextInt();
				int dest = sc.nextInt();
				if(arr.get(start).contains(dest)) {
					for(HashSet<Integer> hs: arr){
						if(hs.contains(start)){
							hs.addAll(arr.get(dest));
						}
					}
					ans[i] = '1';
				}
				else{
					for(HashSet<Integer> hs: arr){
						if(hs.contains(dest)){
							hs.addAll(arr.get(start));
						}
					}
					ans[i] = '0';
				}
			}
			Answer = String.valueOf(ans);
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}