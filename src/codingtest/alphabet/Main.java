package codingtest.alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static char[][] map;
    static boolean[][] check;
    static int cnt;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        check = new boolean[R][C];

        for(int i = 0; i< R; i++) {
            String s = br.readLine();
            for(int j = 0; j<C;j++) {
                map[i][j] = s.charAt(j);
            }
        }

        check[0][0] = true;
        dfs(0,0,Character.toString(map[0][0]), 1);

        System.out.println(cnt);
    }

    private static void dfs(int x, int y, String str, int len) {

        if(cnt < len) {
            cnt = len;
        }

        for(int i = 0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || check[nextX][nextY]) {
                continue;
            }

            if(!str.contains(Character.toString(map[nextX][nextY]))) {
                check[nextX][nextY] = true;
                dfs(nextX, nextY, str + map[nextX][nextY], len+1);
                check[nextX][nextY] = false;
            }
        }
    }
}
