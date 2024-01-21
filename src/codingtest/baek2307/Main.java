package codingtest.baek2307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<StartEnd> startEnds = new ArrayList<>();
    static List<List<Node>> nodes = new ArrayList<>();
    static int[] dist;
    static boolean[] visit;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visit = new boolean[N+1];
        path = new int[N+1];

        for(int i = 0; i<=N;i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Node(end, weight));
            nodes.get(end).add(new Node(start, weight));
        }

        dijkstra();
        int minDis = dist[N];

        int maxDis = 0;
        for(int i = N; i>0; i=path[i]) {
            visit = new boolean[N+1];
            otherPath(path[i], i);
            maxDis = Math.max(maxDis, dist[N]);
        }

        if(maxDis == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(maxDis - minDis);
        }



    }

    private static void dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));

        pq.add(new Node(1,0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> connectedNodes = nodes.get(now.x);
                for(Node n : connectedNodes) {
                    if(!visit[n.x] && n.weight + now.weight < dist[n.x]) {
                        dist[n.x] = n.weight + now.weight;
                        pq.add(new Node(n.x, n.weight + now.weight));
                        path[n.x] = now.x;
                    }
                }
            }
        }
    }

    private static void otherPath(int from, int to) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));

        dist[1] = 0;
        pq.add(new Node(1,0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> connectedNodes = nodes.get(now.x);
                for(Node n : connectedNodes) {
                    if(now.x == from && n.x == to) {
                        continue;
                    }
                    if(!visit[n.x] && n.weight + now.weight < dist[n.x]) {
                        dist[n.x] = n.weight + now.weight;
                        pq.add(new Node(n.x, n.weight + now.weight));
                    }
                }
            }
        }
    }

    static class StartEnd{
        int start;
        int end;
        int weight;

        public StartEnd(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node{
        int x;
        int weight;
        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }
}
