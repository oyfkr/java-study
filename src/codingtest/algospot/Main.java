package codingtest.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] dist;
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 열 -> y
        M = Integer.parseInt(st.nextToken()); // 행 -> x

        map = new int[M][N];
        dist = new int[M][N];

        for(int i = 0; i< M; i++) {
            String[] split = br.readLine().split("");
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            for(int j = 0; j< N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        dijkstra(0,0);
        System.out.println(dist[M-1][N-1]);
    }

    private static void dijkstra(int x, int y) {
        PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> o1.cntBroken - o2.cntBroken);
        dist[0][0] = 0;
        nodes.offer(new Node(0,0,0));

        while(!nodes.isEmpty()) {
            Node now = nodes.poll();

            for(int i = 0; i<4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                int nextBroken = now.cntBroken;

                if (nextY < 0 || nextY >= M || nextX < 0 || nextX >= N)
                    continue;

                if(map[nextY][nextX] == 1) {
                    nextBroken++;
                }
                if(dist[nextY][nextX] > nextBroken) {
                    dist[nextY][nextX] = nextBroken;
                    nodes.add(new Node(nextX, nextY, nextBroken));
                }
            }
        }


    }

    static class Node {
        int x;
        int y;
        int cntBroken;

        public Node(int x, int y, int cntBroken) {
            this.x = x;
            this.y = y;
            this.cntBroken = cntBroken;
        }
    }
}
