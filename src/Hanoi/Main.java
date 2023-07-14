package Hanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        System.out.println((int)Math.pow(2,N)-1);
        System.out.println(sb);
    }

    // n개를 start에서 mid를 거쳐 to로 옮기는 순서를 출력함
    public static void hanoi(int n, int start, int mid, int to){
        if(n==1){
            sb.append(start + " "+to+"\n");
            return;
        }

        hanoi(n-1,start, to, mid);
        sb.append(start + " "+to+"\n");
        hanoi(n-1,mid,start,to);
    }
}