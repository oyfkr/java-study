package codingtest.baek2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean[][] map = new boolean[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for(int j = x; j<x+10;j++) {
                for(int h = y; h<y+10;h++){
                    map[j][h] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i<101;i++) {
            for(int j = 0; j<101;j++) {
                if(map[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
