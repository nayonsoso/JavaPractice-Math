package happyNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for(int i=0; i<times; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String idx = st.nextToken();
            String originNum = st.nextToken();
            int origin = Integer.parseInt(originNum);
            char[] num = originNum.toCharArray();
            ArrayList<Integer> list = new ArrayList<>();
            int result;

            if(origin==1 || !isPrim(Integer.parseInt(originNum))){
                System.out.println(idx+" "+originNum+" "+"NO");
                continue;
            }

            while(true){
                // 각 자리의 제곱을 더하는 부분
                result = 0;
                for (int j = 0; j < num.length; j++) {
                    result += (num[j] - 48) * (num[j] - 48);
                }

                if(list.contains(result) || result==1){
                    break;
                }
                list.add(result);
                num = String.valueOf(result).toCharArray();
            }
            System.out.println(idx+" "+originNum+" "+((result==1)?"YES":"NO"));
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