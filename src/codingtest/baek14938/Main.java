package codingtest.baek14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int x;
        int distance;

        public Node(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }

    static int[] itemCnt;
    static int[] dist;
    static boolean[] visit;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 지역의 개수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        itemCnt = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            itemCnt[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<=n; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<r;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(start).add(new Node(end, weight));
            nodes.get(end).add(new Node(start, weight));
        }

        int max = 0;
        for(int i = 1; i<=n;i++) {
            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            visit = new boolean[n+1];
            dijkstra(i);

            max = Math.max(getItemCnt(dist, m), max);
        }

        System.out.println(max);
    }

    private static void dijkstra(int i) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.distance - o2.distance);

        q.add(new Node(i,0));
        dist[i] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> xConnectedNode = nodes.get(now.x);
                for(Node n : xConnectedNode) {
                    if(!visit[n.x] && now.distance + n.distance < dist[n.x]) {
                        dist[n.x] = now.distance + n.distance;
                        q.add(new Node(n.x, now.distance + n.distance));
                    }
                }
            }
        }
    }

    private static int getItemCnt(int[] dist, int m) {

        int cnt = 0;
        for(int i = 0; i< dist.length;i++) {
            if(dist[i] <= m) {
                cnt +=itemCnt[i];
            }
        }

        return cnt;
    }
}
