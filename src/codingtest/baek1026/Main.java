package codingtest.baek1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Integer[] arr1 = new Integer[N];
        Integer[] arr2 = new Integer[N];

        for(int i = 0; i<2;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N;j++) {
                if(i==0) {
                    arr1[j] = Integer.parseInt(st.nextToken());
                } else {
                    arr2[j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        int answer = 0;
        for(int i = 0; i<N;i++) {
            answer = answer + arr1[i] * arr2[i];
        }

        System.out.println(answer);
    }
}
