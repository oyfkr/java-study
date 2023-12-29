package codingtest.baek18223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visit;
    static int[] dist;
    static int[] history;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점
        int E = Integer.parseInt(st.nextToken()); // 간선
        int P = Integer.parseInt(st.nextToken()); // 건우의 위치

        visit = new boolean[V+1];
        dist = new int[V+1];
        history = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i<=V;i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(start).add(new Node(end,weight));
            nodes.get(end).add(new Node(start, weight));
        }

        dijkstra(1);
        int distV = dist[V];
        int distP = dist[P];

        visit = new boolean[V+1];
        dist = new int[V+1];
        history = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(P);

        int pTov = dist[V];

        if(distV == distP + pTov) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.weight-o2.weight);

        p.add(new Node(start,0));
        dist[start] = 0;

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> nextNodes = nodes.get(now.x);
                for(Node n : nextNodes) {
                    if(!visit[n.x] && dist[n.x] > now.weight + n.weight) {
                        dist[n.x] = now.weight + n.weight;
                        p.add(new Node(n.x, now.weight + n.weight));
                        history[n.x] = now.x;
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int weight;
        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }
}
