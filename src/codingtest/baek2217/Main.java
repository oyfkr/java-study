package codingtest.baek2217;

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

        int[] arr = new int[N];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int last = arr[arr.length-1];
        int cnt = 1;
        for(int i = arr.length-2; i>=0;i--) {
            cnt++;
            if(last < arr[i] * cnt) {
                last = arr[i] * cnt;
            }
        }
        System.out.println(last);
    }
}
