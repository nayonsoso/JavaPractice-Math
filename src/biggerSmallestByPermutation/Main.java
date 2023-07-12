package biggerSmallestByPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, origin, min = Integer.MAX_VALUE;
    static int[] arr, out;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        // 입력 처리 : String -> int[]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        origin = Integer.parseInt(s);
        String[] sarr = s.split("");
        arr = new int[sarr.length];
        for(int i=0; i<sarr.length; i++){
            arr[i] = Integer.parseInt(sarr[i]);
        }

        N = arr.length;
        out = new int[N];
        visited = new boolean[N];

        per(0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    public static void per(int dept){
        if(dept == N){
            // 배열을 int로 바꾸기
            int outNum = 0;
            for(int i=0; i<arr.length; i++){
                outNum += Math.pow(10,i)*out[i];

            }

            // 기존 수보다 더 크면서 가장 작은 min 구하기
            if(outNum>origin){
                if(outNum<min){
                    min=outNum;
                }
            }
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]==false){
                visited[i]=true;
                out[dept] = arr[i];
                per(dept+1);
                visited[i]=false;
            }
        }
    }
}
