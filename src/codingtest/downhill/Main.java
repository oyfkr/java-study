package codingtest.downhill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] dp;
    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y) {

        if(x == n-1 && y == m-1) return 1; // 끝이면
        if(dp[x][y] != -1) return dp[x][y]; // 방문 했으면

        dp[x][y] = 0;

        for(int i = 0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                if(map[x][y] > map[nextX][nextY]) {
                    dp[x][y] += dfs(nextX,nextY);
                }
            }
        }

        return dp[x][y];
    }
}
