package codingtest.virus;

import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[] visit;
    static int cnt;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();	// 컴퓨터 수(정점)
        m = scan.nextInt();	// 연결된 컴퓨터 쌍의 수(간선)

        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i = 0; i<m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            map[a][b] = 1;
        }

        dfs(1);

        System.out.println(cnt);
    }

    private static void dfs(int i) {

        visit[i] = true;

        for (int j = 1; j<=n;j++) {
            if(map[i][j] == 1 && !visit[j]) {
                cnt++;
                dfs(j);
            }
        }
    }
}
