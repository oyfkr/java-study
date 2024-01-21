package codingtest.baek2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        dp = new Integer[n+1];

        for(int i = 1; i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if(n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(n));
    }

    private static int find(int n) {

        if(dp[n] == null) {
            dp[n] = Math.max(find(n-2), find(n-3) + arr[n-1]) + arr[n];
        }

        return dp[n];
    }
}
