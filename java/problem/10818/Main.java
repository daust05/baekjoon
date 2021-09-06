    import java.util.Scanner;

    public class Main{
        public static void main(String[] args){
            int n;
            int min = 1000001, max = -1000001;
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int t = sc.nextInt();
                if (t < min){
                    min = t;
                }
                else if (t > max){
                    max = t;
                }
            }

            System.out.println(min+" "+max);
            sc.close();
        }
    }