package codingtest.baek13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] dist = new int[N];
        int[] price = new int[N+1];
        for(int i = 1; i<N;i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N;i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int cur = price[1];
        long answer = 0;
        for(int i = 2; i<=N;i++) {
            if(cur > price[i]) { // 현재보다 싼 가격을 만났을 때
                answer += (long) cur * dist[i-1];
                cur = price[i];
            } else { // 현재보다 비싸거나 같은 가격을 만났을 때
                answer += (long) cur * dist[i-1];
            }
        }

        System.out.println(answer);
    }
}
