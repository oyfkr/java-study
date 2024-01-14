package codingtest.baek2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[c];

        for(int i = 0; i<c;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(average(arr));

        Arrays.sort(arr);
        System.out.println(middle(arr));
        System.out.println(mostCnt(arr));
        System.out.println(maxMinMinus(arr));



    }

    private static int average(int[] arr) {

        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return Math.round((float) sum /arr.length);
    }

    private static int middle(int[] arr) {

        return arr[arr.length/2];
    }

    private static int mostCnt(int[] arr) {

        int cnt = 0;
        int max = -1;
        int mod = arr[0];
        boolean check = false;

        for(int i = 0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                cnt++;
            } else {
                cnt = 0;
            }

            if(max < cnt) {
                max = cnt;
                mod = arr[i];
                check = true;
            } else if (max == cnt && check) {
                mod = arr[i];
                check = false;
            }
        }
        return mod;
    }

    private static int maxMinMinus(int[] arr) {

        return arr[arr.length-1] - arr[0];
    }
}
