package codingtest.baek2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visit = new boolean[n+1][n+1];
        dist = new int[n+1][n+1];
        for(int i = 0 ; i<n; i++) {
            int[] tmp = new int[n+1];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            dist[i] = tmp;
        }

        for(int i = 1; i<=n;i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for(int j = 0; j<n;j++) {
                map[i][j+1] = Integer.parseInt(split[j]);
            }
        }

        dijkstra();

        System.out.println(dist[n][n]);
    }

    private static void dijkstra() {

        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);

        p.add(new Node(1,1, 0));

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x][now.y]) {
                visit[now.x][now.y] = true;
                for(int i = 0 ; i<4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];
                    if(nextX >= 1 && nextY >= 1 && nextX <=n && nextY <=n) {
                        if(!visit[nextX][nextY]) {
                            if(map[nextX][nextY] == 0) {
                                p.add(new Node(nextX, nextY, now.weight + 1));
                            } else {
                                dist[nextX][nextY] = now.weight;
                                p.add(new Node(nextX, nextY, now.weight));
                            }
                        }
                    }
                }
            }

        }
    }

    static class Node{
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
