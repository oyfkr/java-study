package codingtest.baek14497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visit;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N+1][M+1];
        visit = new boolean[N+1][M+1];
        dist = new int[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N;i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dijkstra(x1-1,y1-1);

        System.out.println(dist[x2-1][y2-1]);
    }

    private static void dijkstra(int x1, int y1) {
        PriorityQueue<Node> p = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        p.add(new Node(x1,y1,0));
        dist[x1][y1] = 0;

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x][now.y]) {
                visit[now.x][now.y] = true;

                for(int i = 0; i<4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    if(nextX >=0 && nextX <N && nextY >=0 && nextY < M) {
                        if(!visit[nextX][nextY] && dist[nextX][nextY] > now.weight) {
                            if(map[nextX][nextY] == '1' || map[nextX][nextY] == '#') {
                                p.add(new Node(nextX, nextY, now.weight+1));
                                dist[nextX][nextY] = now.weight+1;
                            } else {
                                p.add(new Node(nextX, nextY, now.weight));
                                dist[nextX][nextY] = now.weight;
                            }
                        }
                    }
                }

            }
        }
    }

    static class Node {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
