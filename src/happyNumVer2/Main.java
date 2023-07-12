package happyNumVer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String idx = st.nextToken();
            String originNum = st.nextToken();
            int n = Integer.parseInt(originNum);
            HashSet<Integer> hs = new HashSet<>();
            int squarSum=0;

            if(n==1 || !isPrim(Integer.parseInt(originNum))){
                System.out.println(idx+" "+originNum+" "+"NO");
                continue;
            }

            while(hs.add(n)){
                squarSum = 0;
                while(n>0){
                    int remain = n%10;
                    squarSum += remain*remain;
                    n/= 10;
                }
                n = squarSum;
                if(squarSum==1){
                    break;
                }
            }

            System.out.println(idx+" "+originNum+" "+(squarSum==1?"YES":"NO"));
        }
    }

    public static boolean isPrim(int n) {
        boolean b = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                b=false;
            }
        }
        return b;
    }
}
