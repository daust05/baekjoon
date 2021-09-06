package SCPC2021.P5;

/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static int Answer;
    static int[] tower;
    static int N = 6;
    static List<Character> strBuffer;

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
            int M = sc.nextInt();
            tower = new int[] {-1,N,0,0};
            strBuffer = new ArrayList<>();
            move(N);
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(N);
            printBuffer();
        }
    }
    private static void move(int size){
        boolean top = true;
        while(tower[3] < size){
            if(top){
                moveTop(size-tower[3]);
                top = false;
            }
            else{
                moveLast(size-tower[3]);
                top = true;
            }
        }
    }
    private static void moveTop(int size){
        if(size > 2){
            movehelper(size -1, 1,2, 3);
            savePrint(1,3);
            tower[1]--;
            tower[3]++;
        }
        else{
            savePrint(1,3);
            savePrint(1,3);
            tower[1]-= 2;
            tower[3]+= 2;
        }
    }
    private static void moveLast(int size){
        if(size > 2){
            movehelper(size -2, 2,1, 3);
        }
        savePrint(2,3);
        savePrint(2,3);
        tower[2]-= 2;
        tower[3]+= 2;
    }
    private static void movehelper(int size, int start, int dest, int remain){
        boolean reverse = (tower[dest]+tower[start]) %2 == 0;
        if(size > 2){
            movehelper(size-2,start,remain,dest);
            movehelper(2,start,dest,remain);
            movehelper(size-2,remain,dest,start);
        }
        else{
            if(size == 2){
                if(!reverse){
                    savePrint(start,dest);
                    savePrint(start,dest);
                }
                else{
                    savePrint(start,remain);
                    savePrint(start,dest);
                    savePrint(remain,dest);
                }
            }
            else{
                savePrint(start,dest);
            }
            tower[start] -= size;
            tower[dest] += size;
        }
    }
    private static void savePrint(int start, int dest){
        if(start == 1){
            if(dest == 2){
                strBuffer.add('A');
            }
            else{
                strBuffer.add('B');
            }
        }
        else if(start == 2){
            if(dest==1){
                strBuffer.add('C');
            }
            else{
                strBuffer.add('D');
            }
        }
        else{
            if(dest == 1){
                strBuffer.add('E');
            }
            else{
                strBuffer.add('F');
            }
        }
    }
    private static void printBuffer(){
        strBuffer.iterator().forEachRemaining(System.out::print);
        System.out.println();
    }
}