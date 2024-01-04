package codingtest.baek18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int min = 256;
        int max = 0;
        for(int i = 0; i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M;j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp > max) {
                    max = tmp;
                }
                if(tmp < min) {
                    min = tmp;
                }
            }
        }

        int answerHeight = 0;
        int answerTime = Integer.MAX_VALUE;
        for(int i = min; i<=max; i++) {

            int time = 0;
            int block = B;

            for (int x = 0; x<N;x++) {
                for(int y = 0; y<M;y++) {
                    int now = map[x][y];
                    if(now > i) {
                        time = (now - i) * 2 + time;
                        block = block + now - i;
                    }
                    if(now < i) {
                        time = time + (i - now);
                        block = block - (i - now);
                    }
                }
            }
            if(block < 0) {
                break;
            }
            if(answerTime >= time) {
                answerTime = time;
                answerHeight = i;
            }
        }

        System.out.println(answerTime + " " + answerHeight);
    }
}
