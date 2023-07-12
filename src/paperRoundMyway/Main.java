package paperRoundMyway;

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

        System.out.println(recur(white, d, 0, 0, 0));
    }

    // 흰 도화지를 돌며 1이 발견되는 지점에서 시작해서 4개의 변을 재귀적으로 탐색
    // 한번 조사한 좌표를 다시 조사하면, 그 좌표는 스스로를 또 조사하고, 또 조사하고... 하여 무한 루프 발생
    // 이를 방지하기 위해서 조사를 시작하자마자 값을 -1로 바꿔줌
    // (값이 -1인 경우에는 4개의 변 조사도 하지 말고 그대로 둘레 리턴)
    // 값이 1이 아닌 경우에는 4개의 변을 조사함
    // 조사한 값이 0이면 아무런 동작 없이 재귀함수 호출해서 4 방향으로 나아감
    // 1이면 방법 1에서 쓴 것과 동일한 로직으로 둘레++ 해줌
    public static int recur(int[][] white, int[][]d, int x, int y,int round) {
        int value = white[x][y];
        if(value==-1){return round;}
        white[x][y] = -1;

        for (int i = 0; i < d.length; i++) {
            int dx = x + d[i][0];
            int dy = y + d[i][1];
            System.out.printf("dx는 %d, dy는 %d, value는 %d, white[dx][dy]는 %d\n",dx, dy, value,white[dx][dy]);
            if(value == 1){
                if (dx < 0 || dx > 99 || dy < 0 || dy > 99 || white[dx][dy] == 0) { // 1인데 영역이 벗어나거나 물과 만나면 더 나아가면 안됨
                    round++;
                    System.out.println("hi");
                }
            }
            if(value == 0){

            }
            if(dx>=0 && dx<=99 && dy>=0 && dy<=99){
                return recur(white, d, dx, dy, round);
            }
        }
        return round;
    }
}