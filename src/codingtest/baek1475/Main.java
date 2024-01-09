package codingtest.baek1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int[] arr = new int[10];

        for(char c : s.toCharArray()) {

            if(c == '6') {
                arr[9]++;
            } else {
                arr[c -'0']++;
            }
        }

        int max = 0;
        for(int i = 0; i<9; i++) {
            max = Math.max(max, arr[i]);
        }
        int nine = arr[9]/2;
        if(arr[9]%2==1) nine++;
        max = Math.max(max,nine);
        System.out.println(max);

    }
}
