package langPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int order, N;
    static String result="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            String[] arr = st.nextToken().split("");
            order = Integer.parseInt(st.nextToken());
            int n = arr.length;
            boolean[] visited = new boolean[n];
            String[] out = new String[n];

            N=0;
            result="";
            per(arr, out, visited, n, 0);

            System.out.println(line + " = " + ((N<order)?"No permutation": result));
        }
    }
    public static void per(String[] arr, String[] out, boolean visited[], int n, int depth){
        if(depth==n){
            N++;
            if(N==order){
                for (int i = 0; i < out.length; i++) {
                    result += out[i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]!=true){
                visited[i]=true;
                out[depth]=arr[i];
                per(arr, out, visited, n, depth+1);
                visited[i]=false;
            }
        }
    }
}