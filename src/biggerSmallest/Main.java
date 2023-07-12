package biggerSmallest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1:10 ~ 1:59 (49m)
public class Main {
    // 1 : 숫자가 모두 내림차순으로 정렬되어있으면, 더 커질 수 없으므로 0출력
    // 2 : 숫자 중에 오름차순으로 정렬된게 있으면, 오름차순이 발견된 idx 중에서 가장 뒤에 있는 idx를 찾기 = point
    // 3 : point 뒤에 있는 수 중에서 point 해당하는 수보다 크면서 가장 작은 수 구해서 swap
    // 4 : swap 하면 그 자리엔 원래 수보다 큰 수가 오게 되므로 이후의 수는 모두 오름차순으로 정렬
    //   e.g 1234 => 1243 | 6372 => 6732 | 10044 => 10404 | 27711 => 71127

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int[] num = new int[s.length];
        for (int i = 0; i <s.length ; i++) {
            num[i] = Integer.parseInt(s[i]);
        }

        // 오름차순이 일어나는 idx 중 가장 마지막 idx를 확인하는 부분
        int point = -1;
        for (int i = 0; i < num.length-1; i++) {
            if(num[i]<num[i+1]){ // 오름차순 발견되었으면 인덱스 갱신
                point = i;
            }
        }
        // System.out.println("point는 " + point);

        int min = 0;
        int minIdx = -1;
        if(point==-1){ // 오름차순이 없는 경우
            System.out.println(0);
        } else {
            // 오름차순이 있는 경우
            // point뒤에 있는 수 중에서 point의 수보다 더 크면서 가장 작은 것 찾기
            for (int i = point+1; i < num.length; i++) {
                if(num[i]>num[point]){
                    if(minIdx==-1){
                        min = num[i];
                        minIdx = i;
                    } else{
                        if(num[i]<min){ // 같으면 더 앞에 있는 것과 바꾸는게 더 숫자가 작아지므로 idx 갱신안함
                            min = num[i];
                            minIdx = i;
                        }
                    }
                }
            }

            // swap
            int t = num[minIdx];
            num[minIdx] = num[point];
            num[point] = t;

            // bubble sort
            for (int i = point+1; i < num.length-1; i++) {
                for (int j = i+1; j < num.length; j++) {
                    if(num[i]>num[j]){
                        int p = num[i];
                        num[i] = num[j];
                        num[j] = p;
                    }
                }
            }

            // print
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i]);
            }
        }
    }
}
