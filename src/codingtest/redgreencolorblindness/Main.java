package codingtest.redgreencolorblindness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        check = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n ; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int blindCnt = 0;
        int cnt = 0;

        // 일반인 dfs
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++) {
                if(!check[i][j]) {
                    cnt++;
                    dfs(i,j, map[i][j]);
                }
            }
        }
        check = new boolean[n][n];

        // 색약 dfs
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++) {
                if(!check[i][j]) {
                    blindCnt++;
                    blindDfs(i,j, map[i][j]);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(blindCnt);
    }

    private static void dfs(int x, int y, char curString) {

        check[x][y] = true;

        for(int i = 0 ; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextY < n && nextX < n) {
                if(!check[nextX][nextY] && Objects.equals(map[nextX][nextY], curString)) {
                    dfs(nextX, nextY, map[nextX][nextY]);
                }
            }
        }
    }

    private static void blindDfs(int x, int y, char curString) {
        check[x][y] = true;

        for(int i = 0 ; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextY < n && nextX < n) {
                if(!check[nextX][nextY] && (Objects.equals(map[nextX][nextY], curString) || checkBlind(curString, map[nextX][nextY]))) {
                    blindDfs(nextX, nextY, map[nextX][nextY]);
                }
            }
        }
    }

    private static boolean checkBlind(char cur, char next) {
        if(cur == 'G' || cur == 'R') {
            return next == 'G' || next == 'R';
        }

        return false;
    }
}
