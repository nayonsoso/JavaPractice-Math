package palindromeByReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            // 회문인가
            if(sb.reverse().toString().equals(str)){
                System.out.println(0);
            } else { // 유사 회문인가
                boolean b = false;
                for (int j = 0; j < str.length(); j++) {
                    StringBuilder originSb = sb.reverse();
                    String sub = originSb.substring(j,j+1);
                    StringBuilder updatedSb = originSb.delete(j, j+1);
                    String originalSb2 = updatedSb.toString();
                    if(updatedSb.reverse().toString().equals(originalSb2)){
                        b = true;
                        break;
                    }
                    sb.insert(j,sub);
                }
                System.out.println(b?1:2);
            }
        }
    }
}