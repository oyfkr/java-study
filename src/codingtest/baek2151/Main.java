package codingtest.baek2151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static char[][] map;
    static boolean[][][] visit;
    static int sx, sy, ex, ey, N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] d1 = {2,3,1,0};
    static int[] d2 = {3,2,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visit = new boolean[N][N][4];

        int index = 0;
        for(int i = 0; i<N;i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int j = 0; j<N;j++) {
                map[i][j] = charArray[j];
                if(map[i][j] == '#' && index == 0) {
                    index++;
                    sx = i;
                    sy = j;
                }
                if(map[i][j] == '#' && index == 1) {
                    ex = i;
                    ey = j;
                }
            }
        }

        dijkstra();
    }

    private static void dijkstra() {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.cnt - o2.cnt);

        // 0 : 왼, 1 : 오, 2 : 아래, 3 : 위
        for(int i = 0; i<4; i++) {
            p.add(new Node(sx, sy, i,0));
        }

        int min = 0;
        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x][now.y][now.d]) {
                visit[now.x][now.y][now.d] = true;

                if(now.x == ex && now.y == ey) {
                    min = now.cnt;
                    break;
                }

                int nx = now.x + dx[now.d];
                int ny = now.y + dy[now.d];

                if(nx >= 0 && ny >=0 && nx <N && ny < N && map[nx][ny] != '*') {
                    if(map[nx][ny] == '!') {
                        int tmp = now.cnt;
                        p.add(new Node(nx,ny,d1[now.d], tmp+1));
                        p.add(new Node(nx,ny,d2[now.d], tmp+1));
                    }
                    p.add(new Node(nx,ny, now.d, now.cnt));
                }
            }
        }
        System.out.println(min);
    }

    static class Node{
        int x;
        int y;
        int d;
        int cnt;

        public Node(int x, int y, int d, int cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;
        }
    }
}
