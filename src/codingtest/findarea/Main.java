package codingtest.findarea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] check;
    static int area;
    static int cnt;
    static int m;
    static int n;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        check = new boolean[m][n];

        for(int i = 0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for(int a = leftX; a < rightX; a++) {
                for(int b = leftY; b < rightY; b++) {
                    map[b][a] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(!check[i][j] && map[i][j] != 1) {
                    area = 1;
                    bfs(i, j);
                    cnt++;
                    areas.add(area);
                }
            }
        }

        Collections.sort(areas);

        System.out.println(cnt);
        for(Integer i : areas) {
            System.out.print(i + " ");
        }
    }
    
    public static void bfs(int x, int y) {
        check[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x,y});

        while (!queue.isEmpty()) {
            int[] data = queue.poll();

            int curX = data[0];
            int curY = data[1];

            for(int i = 0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >=0 && nextY >= 0 && nextX < m && nextY < n) {
                    if(!check[nextX][nextY] && map[nextX][nextY] != 1) {
                        check[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY});
                        area++;
                    }
                }
            }
        }
    }
}
