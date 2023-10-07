package codingtest.iceberg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static int[][] nextMeltAmount;
    static int cnt;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];
        nextMeltAmount = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m;j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        int answer = 0;
        while(true) {
            answer++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    melt(i, j);

                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int amount = map[i][j] - nextMeltAmount[i][j];
                    map[i][j] = Math.max(amount, 0);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !check[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            if (cnt >= 2) {
                break;
            }
            if (max == 0) {
                answer = 0;
                break;
            }
            cnt = 0;
            max = 0;
            check = new boolean[n][m];
        }

        if(cnt == 1) {
            cnt = 0;
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        if(max < map[x][y]) {
            max = map[x][y];
        }
        check[x][y] = true;
        for(int i = 0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                if(!check[nextX][nextY] && map[nextX][nextY] != 0) {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    private static void melt(int x, int y) {

        if(map[x][y] != 0) {
            int amount = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (map[x][y] != 0 && map[nextX][nextY] == 0) {
                        amount++;
                    }
                }
            }
            nextMeltAmount[x][y] = amount;
        }
    }

}
