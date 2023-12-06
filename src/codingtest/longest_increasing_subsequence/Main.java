package codingtest.longest_increasing_subsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dp;
    static int[] seq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        dp = new Integer[cnt];
        seq = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < cnt; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < cnt; i++) {
            lis(i);
        }

        int max = dp[0];
        for(int i = 0; i<cnt; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

    private static int lis(int n) {

        if(dp[n] == null) {
            dp[n] = 1;

            for(int i = n-1; i>=0; i--) {
                if(seq[i] < seq[n]) {
                    dp[n] = Math.max(dp[n], lis(i) + 1);
                }
            }
        }

        return dp[n];
    }
}
