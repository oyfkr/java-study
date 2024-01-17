package codingtest.baek1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i<N;i++) {

            String s = br.readLine();
            for(int j = 0; j<M;j++) {
                map[i] = s.toCharArray();
            }
        }

        dfs();

        System.out.println(count);
    }

    private static void dfs() {
        for(int i = 0; i<N;i++) {
            for(int j = 0; j<M;j++) {
                if(!visit[i][j]) {
                    if(map[i][j] == '-') {
                        count++;
                        visit[i][j] = true;
                        if(j+1 == M) {
                            continue;
                        }
                        checkGa(i, j+1);
                    }
                    if(map[i][j] == '|') {
                        count++;
                        visit[i][j] = true;
                        if(i+1 == N) {
                            continue;
                        }
                        checkSe(i+1, j);
                    }
                }
            }
        }
    }

    private static void checkGa(int i , int j) {
        if(map[i][j] == '-') {
            visit[i][j] = true;
            if(j+1 == M) {
                return;
            }
            checkGa(i, j+1);
        }
    }

    private static void checkSe(int i , int j) {
        if(map[i][j] == '|') {
            visit[i][j] = true;
            if(i+1 == N) {
                return;
            }
            checkSe(i+1, j);
        }
    }
}
