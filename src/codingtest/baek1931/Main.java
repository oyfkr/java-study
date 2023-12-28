package codingtest.baek1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] storage = new int[N][2];
        for(int i = 0; i<N;i++) {
            st = new StringTokenizer(br.readLine());

            storage[i][0] = Integer.parseInt(st.nextToken());
            storage[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(storage, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int cnt = 1;
        int cur = storage[0][1];
        for(int i = 1; i<N;i++) {
            if(cur <= storage[i][0]) {
                cnt++;
                cur = storage[i][1];
            }
        }

        System.out.println(cnt);
    }
}
