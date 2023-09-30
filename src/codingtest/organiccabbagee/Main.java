package codingtest.organiccabbagee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int m;
    static int n;
    static int[][] map;
    static boolean[][] check;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t;i++){
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            map = new int[m][n];
            check = new boolean[m][n];
            for(int j = 0; j<k;j++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = 1;
            }

            for(int a = 0; a<m; a++) {
                for(int b = 0; b<n; b++) {
                    if(!check[a][b] && map[a][b] == 1) {
                        cnt++;
                        dfs(a, b);
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }


    }

    public static void dfs(int a, int b) {
        check[a][b] = true;

        for(int i = 0; i<4; i++) {

            int x = a+dx[i];
            int y = b+dy[i];

            if(x >= 0 && y >= 0 && x < m && y<n) {

                if(map[x][y] == 1 && !check[x][y]) {
                    dfs(x, y);
                }
            }
        }

    }
}
