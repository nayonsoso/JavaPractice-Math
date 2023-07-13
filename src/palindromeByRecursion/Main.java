package palindromeByRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            char[] arr = br.readLine().toCharArray();
            int l = arr.length;
            System.out.println(isPalindrome(0, arr.length - 1,arr, 0));
        }
    }

    public static int isPalindrome(int left, int right, char[]arr, int delCnt){
        while(left<right){
            if(arr[left]!=arr[right]){
                if(delCnt==0){
                    if(isPalindrome(left+1, right, arr, 1)==0 ||
                    isPalindrome(left, right-1,arr,1)==0){
                        return 1; // 하나 무시하고 끝까지 갔을 때 cnt 가 0이면, 최종적으로 1
                    } else {
                        return 2; // 하나 무사하고 끝까지 깠을 때 cnt가 0이 아니면 2
                    }
                } else {
                    return 2; // 1이거나 2일 때 불일치 발생하면 2를 리턴함 (하나를 더하지 않고)
                }
            } else {
                left++;
                right--;
            }
        }
        return 0;
    }
}