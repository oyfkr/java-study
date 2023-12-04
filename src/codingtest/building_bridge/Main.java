package codingtest.building_bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        for(int i = 0; i<c;i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(com(m,n));

        }
    }

    private static int com(int m, int n) {

        // 이미 계산된 경우
        if(dp[m][n] > 0) {
            return dp[m][n];
        }

        // 원소의 개수가 조합의 개수와 동일하거나 0인 경우
        if (n == m || n==0) {
            return 1;
        }

        return dp[m][n] = com(m-1, n-1) + com(m-1, n);
    }

}
