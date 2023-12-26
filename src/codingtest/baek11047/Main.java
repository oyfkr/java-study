package codingtest.baek11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i = N-1;
        int cnt = 0;
        while (true) {

            if(i == 0) {
                cnt += K / arr[i];
                break;
            }else {
                if (K / arr[i] != 0) {
                    cnt += K / arr[i];
                    if (K % arr[i] == 0) {
                        break;
                    }
                    K = K % arr[i];
                }
                i--;
            }
        }

        System.out.println(cnt);
    }
}
