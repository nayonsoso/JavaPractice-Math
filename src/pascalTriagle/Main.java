package pascalTriagle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 11:49 ~ 12:21 (32m)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);
        // 이항계수 C(n-1, k-1)로 접근하는 방법
        System.out.println(getRseult(n,k));

        // 삼각형을 만들면서 접근하는 법
        int[][] tri = new int[n+1][n+1]; // 헷갈리지 않게 index와 층 수가 대응되도록 함
        tri[1][1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
            }
        }
    }

    public static int getRseult (int n,int k){
        // int result = fact(n - 1) / (fact(n - k) * fact(k -1));
        int result = 1;

        for(int i = n-k+1; i<n; i++){
            result *=i;
            result /=(i-n+k);
        }

        return result;
    }
}
