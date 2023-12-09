package codingtest.baek4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int[][] weight;
    static boolean[][] check;
    static int[] dx= {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        int index = 0;
        while(!(s = br.readLine()).equals("0")) {
            n = Integer.parseInt(s);
            index++;
            map = new int[n][n];
            weight = new int[n][n];
            check = new boolean[n][n];

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    weight[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();
            System.out.println("Problem "+ index +": " + weight[n-1][n-1]);
        }
    }

    private static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        q.add(new Node(0, 0, map[0][0]));
        weight[0][0] = map[0][0];

        while (!q.isEmpty()) {
            Node now = q.poll();
            if(!check[now.x][now.y]) {
                check[now.x][now.y] = true;
                for(int i = 0; i<4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    if(nextX >= 0 && nextX <n && nextY >=0 && nextY < n){
                        if(!check[nextX][nextY] && map[nextX][nextY] + now.weight < weight[nextX][nextY]) {
                            weight[nextX][nextY] = map[nextX][nextY] + now.weight;
                            q.add(new Node(nextX,nextY,map[nextX][nextY] + now.weight));
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
