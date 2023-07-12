package paperRoundByrecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperNum = Integer.parseInt(br.readLine());
        int[][] white = new int[100][100];

        for (int i = 0; i < paperNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 색종이 붙이기
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    white[x + j][y + k] = 1;
                }
            }
        }

        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                // 해당 위치가 1일때만 실행됨
                if(white[i][j]==1){
                    result += recur(white, d,i,j);
                }
            }
        }

        System.out.println(result);
    }

    public static int recur(int[][] white, int[][]d, int x, int y) {
        white[x][y] = -1;

        // 해당하는 값이 1임을 보장한다는게 이 알고리즘을 단순화하는 가장 큰 요인인듯
        int cnt = 0;
        for (int i = 0; i < d.length; i++) {
            int dx = x + d[i][0];
            int dy = y + d[i][1];
            if (dx < 0 || dx > 99 || dy < 0 || dy > 99 || white[dx][dy] == 0) { // 1인데 영역이 벗어나거나 물과 만나면 더 나아가면 안됨
                cnt++;
            }else {
                if(white[dx][dy]==1){
                    cnt += recur(white, d, dx,dy);
                }
            }
        }
        return cnt;
    }
}