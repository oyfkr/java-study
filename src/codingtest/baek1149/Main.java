package codingtest.baek1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        map = new int[n][3];
        dp = new int[n][3];

        for(int i = 0; i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[i][0] = r;
            map[i][1] = g;
            map[i][2] = b;
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        System.out.println(Math.min(dp(n-1, 0), Math.min(dp(n-1, 1), dp(n-1, 2))));
    }

    /*
    점화식
    레드
    dp[N][0] = min(dp[N-1][1], dp[N-1][2]) + map[N][0] -> 이전까지 온 그린과 블루의 값중 더 작은 값 + 현재 레드의 값
     */
    private static int dp(int n, int color) {
        if(dp[n][color] == 0) {
            if(color == 0) {
                dp[n][0] = Math.min(dp(n-1, 1), dp(n-1,2)) + map[n][0];
            } else if(color == 1) {
                dp[n][1] = Math.min(dp(n-1,0), dp(n-1,2)) + map[n][1];
            } else {
                dp[n][2] = Math.min(dp(n-1,0), dp(n-1,1)) + map[n][2];
            }
        }
        return dp[n][color];
    }
}
