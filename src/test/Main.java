package test;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 1};
        int[] visited = new int[arr.length];
        int visitCnt = 0;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;
        while(visitCnt < arr.length) {
            for(int i=0; i<arr.length; i++){
                if(arr[i]<minVal && visited[i]==0){
                    minVal = arr[i];
                    minIdx = i;
                }
            }
            System.out.print(minVal + " ");
            visited[minIdx] = 1;
            visitCnt++;
            minVal = Integer.MAX_VALUE;
            minIdx = -1;
        }
    }
}
