package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            char[] arr = br.readLine().toCharArray();
            int l = arr.length;
            System.out.println(check(arr, 0, arr.length-1, 0));
        }
    }

    public static int check(char[] arr, int left, int right, int cnt){
        if(left>=right){
            return cnt;
        }

        if(arr[left]==arr[right]){
            cnt = check(arr, left+1, right-1, cnt);
        } else {
            if(cnt==0){
                // 불일치 횟수가 덮어씌워지는 문제 발새 -> 더 작은 불일치 횟수만 적용하게 바꿈
                int cnt1 = check(arr, left, right-1,cnt+1);
                int cnt2 = check(arr, left+1, right,cnt+1);
                cnt = Math.min(cnt1, cnt2);
            } else if(cnt==1){
                cnt = cnt+1;
            }
        }
        return cnt;
    }
}