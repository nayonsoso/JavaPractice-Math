package permutation;

import java.util.Arrays;

public class Main {
    // arr[] : 후보들이 담긴 배열
    // depth : 자리
    // n : 후보의 갯수 == arr의 크기
    // r : 뽑을 갯수
    // visited[] : arr의 요소들이 방문되었는지를 저장하는 배열
    // out[] : 순열의 결과를 담을 배열
    static void permutation2(int[] arr, int depth, int n, int r, boolean[] visited, int[] out){
        if(depth == r){
            for (int i = 0; i < r; i++) {
                System.out.print(out[i]);
            }
            System.out.println();
        }

        for(int i=0; i<n; i++){
            if(visited[i] != true){
                visited[i] = true;
                out[depth] = arr[i];
                // System.out.printf("dept:%d  i:%d  visited:%s  out:%s\n",depth,i,Arrays.toString(visited),Arrays.toString(out));
                permutation2(arr, depth+1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }

    static void permutation1(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation1(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
    static void swap(int[] arr, int depth, int idx){
        int tmp=arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        boolean[] visited = {false, false, false, false};
        int[] out = {0,0,0,0};

        // permutation1(arr, 0, arr.length, 3);
        permutation2(arr, 0, 4, 3, visited, out);
    }
}
