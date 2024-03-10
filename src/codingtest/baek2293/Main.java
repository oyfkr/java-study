package codingtest.baek2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 현재 coin 보다 적은 수 로만 만든 값 + coin 만큼 작은 값을 구하기 위해 필요한 개수
        // dp[i] = dp[i-coin] + dp[i]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[k+1];

        for(int i = 0; i<n;i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for(int i = 0; i<n;i++) { // 현재 coin의 index 값
            for(int j = 1; j<=k; j++) { // dp에 저장된 값
                if(j >= coin[i]) {
                    dp[j] += dp[j-coin[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
