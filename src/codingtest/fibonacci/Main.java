package codingtest.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp = new int[41][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};

        for(int i = 0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());

            recur(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    private static int[] recur(int n) {
        if(n == 0) {
            return dp[0];
        } else if(n == 1) {
            return dp[1];
        }

        if(dp[n][0] == 0 && dp[n][1] == 0) {
            int[] recurMinus1 = recur(n - 1);
            int[] recurMinus2 = recur(n - 2);

            int zeroCnt = recurMinus1[0] + recurMinus2[0];
            int oneCnt = recurMinus1[1] + recurMinus2[1];
            dp[n] = new int[]{zeroCnt, oneCnt};
        }

        return dp[n];
    }
}
