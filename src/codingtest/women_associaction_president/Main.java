package codingtest.women_associaction_president;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[15][15];

        for(int i = 0; i < 15; i++) {
            map[0][i] = i;
            map[i][1] = 1;
        }

        // i : 층 , j : 호
        for(int i = 1; i<15; i++) {
            for(int j = 2; j<15; j++) {
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }

        for(int i = 0; i<n; i++) {
            int f = Integer.parseInt(br.readLine());
            int h = Integer.parseInt(br.readLine());

            System.out.println(map[f][h]);
        }
    }
}
