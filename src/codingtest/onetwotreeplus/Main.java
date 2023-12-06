package codingtest.onetwotreeplus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());


            System.out.println(recur(n));
        }
    }

    private static int recur(int n) {
        if(n == 1) {
            return dp[1];
        } else if (n == 2) {
            return dp[2];
        } else if (n == 3) {
            return dp[3];
        }

        return recur(n-1) + recur(n-2) + recur(n-3);
    }
}
