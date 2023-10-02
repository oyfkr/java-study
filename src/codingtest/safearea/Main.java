package codingtest.safearea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] check;

    static int n ;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int maxHeight = 0;
        map = new int[n][n];
        check = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n;j++) {
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
                // 최고 높이를 알고 있어야함
                if(maxHeight < height) {
                    maxHeight = height;
                }
            }
        }
        int maxCnt = 0;

        for(int hig = 1; hig<=maxHeight; hig++) {
            int cnt = 0;
            check = new boolean[n][n];
            for(int i = 0; i<n;i++) {
                for(int j = 0; j<n;j++) {
                    if(!check[i][j] && map[i][j] >= hig) {
                        cnt++;
                        dfs(i,j, hig);
                    }
                }
            }
            if(maxCnt < cnt) {
                maxCnt = cnt;
            }
        }

        System.out.println(maxCnt);
    }

    private static void dfs(int x, int y, int hig) {

        check[x][y] = true;
        for(int i = 0; i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextY < n && nextX < n) {
                if(!check[nextX][nextY] && map[nextX][nextY] >= hig) {
                    dfs(nextX, nextY, hig);
                }
            }
        }
    }

}
