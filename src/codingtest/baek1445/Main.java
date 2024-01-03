package codingtest.baek1445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visit;
    static int trashCnt, trashNearCnt, flowerX, flowerY, nowX, nowY, N, M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 -> x
        M = Integer.parseInt(st.nextToken()); // 가로 -> y

        map = new char[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i<N; i++) {
            String s = br.readLine();
            char[] charArray = s.toCharArray();
            for(int j = 0; j<M; j++) {
                map[i][j] = charArray[j];
                if(map[i][j] == 'S') {
                    nowY = j;
                    nowX = i;
                }
                if(map[i][j] == 'F') {
                    flowerY = j;
                    flowerX = i;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j<M; j++) {
                if(map[i][j] == 'g') {
                    for(int h = 0; h<4;h++) {
                        int nx = i + dx[h];
                        int ny = j + dy[h];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == '.') {
                            map[nx][ny] = 'n';
                        }
                    }
                }
            }
        }

        dijkstra();

        System.out.println(trashCnt + " " + trashNearCnt);
    }

    private static void dijkstra() {
        PriorityQueue<Node> p = new PriorityQueue<>(((o1, o2) -> {
            if(o1.trashCnt == o2.trashCnt) {
                return o1.trashNearCnt - o2.trashNearCnt;
            }

            return o1.trashCnt - o2.trashCnt;
        }));

        p.add(new Node(nowX,nowY,0,0));

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x][now.y]) {
                visit[now.x][now.y] = true;
                if(now.x == flowerX && now.y == flowerY) {
                    trashCnt = now.trashCnt;
                    trashNearCnt = now.trashNearCnt;
                    return;
                }
                for(int i = 0; i<4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if(!visit[nx][ny]) {
                            if (map[nx][ny] == 'g') {
                                p.add(new Node(nx, ny, now.trashCnt + 1, now.trashNearCnt));
                            } else if (map[nx][ny] == 'n') {
                                p.add(new Node(nx, ny, now.trashCnt, now.trashNearCnt + 1));
                            } else {
                                p.add(new Node(nx,ny,now.trashCnt, now.trashNearCnt));
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
        int trashCnt;
        int trashNearCnt;

        public Node(int x, int y, int trashCnt, int trashNearCnt) {
            this.x = x;
            this.y = y;
            this.trashCnt = trashCnt;
            this.trashNearCnt = trashNearCnt;
        }
    }
}
