package codingtest.baek1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int r,c,t,d;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] reverseDist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        init();

        int[][] di = dijkstra(false);
        int[][] reverseDist = dijkstra(true);

        int max = 0;
        for(int i = 0; i<r;i++) {
            for(int j = 0; j<c;j++) {
                if(di[i][j] != Integer.MAX_VALUE && reverseDist[i][j] != Integer.MAX_VALUE && di[i][j] + reverseDist[i][j] <= d) {
                    max = Math.max(max, map[i][j]);
                }
            }
        }
        System.out.println(max);
    }

    private static int[][] dijkstra(boolean isReverse) {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.time - o2.time);

        dist = new int[r][c];
        visit = new boolean[r][c];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        p.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x][now.y]) {
                visit[now.x][now.y] = true;

                for(int i = 0; i<4;i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx <r && ny < c) {
                        int gap = !isReverse ? getGap(map[now.x][now.y], map[nx][ny]) : getGap(map[nx][ny], map[now.x][now.y]);
                        if(gap == -1 || dist[nx][ny] < gap + now.time) continue;

                        dist[nx][ny] = gap + now.time;
                        p.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }

        return dist;
    }

    private static int getGap(int a, int b) {
        if(Math.abs(a-b) > t) return -1;
        if(a >= b) return 1;
        return (b-a) * (b-a);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = nextTokenInteger(st);
        c = nextTokenInteger(st);
        t = nextTokenInteger(st);
        d = nextTokenInteger(st);

        visit = new boolean[r][c];
        dist = new int[r][c];
        reverseDist = new int[r][c];

        for(int i = 0; i<dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(reverseDist[i], Integer.MAX_VALUE);
        }

        map = new int[r][c];
        for(int i = 0; i<r;i++) {
            String row = br.readLine();
            for(int j = 0; j<c;j++) {
                char tmp = row.charAt(j);
                map[i][j] = tmp >='a' ? tmp-'a' + 26 : tmp - 'A';
            }
        }
    }

    private static int nextTokenInteger(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Node{
        int x;
        int y;
        int time;
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
