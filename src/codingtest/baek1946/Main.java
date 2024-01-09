package codingtest.baek1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i<T;i++) {
            int answer = 0;
            int applyCnt = Integer.parseInt(br.readLine());
            int[][] tmp = new int[applyCnt][2];
            for(int j = 0; j<applyCnt; j++) {
                st = new StringTokenizer(br.readLine());
                tmp[j][0] = Integer.parseInt(st.nextToken());
                tmp[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(tmp, Comparator.comparingInt(row -> row[0]));

            int standard = tmp[0][1];
            for(int j = 1; j<applyCnt; j++) {
                if(standard > tmp[j][1]) {
                    answer++;
                    standard = tmp[j][1];
                }
            }
            System.out.println(answer+1);
        }
    }
}
