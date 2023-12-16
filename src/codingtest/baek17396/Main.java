package codingtest.baek17396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static long[] dist;
    static boolean[] visit;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++) {
            if(st.nextToken().equals("1") && i != N-1) {
                visit[i] = true;
                dist[i] = 0;
            }
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            nodes.get(a).add(new Node(b,t));
            nodes.get(b).add(new Node(a,t));
        }

        dijkstra();

        if(dist[N-1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[N - 1]);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> Math.toIntExact(
                o1.weight - o2.weight));

        p.add(new Node(0,0));
        dist[0] = 0;

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> nextNodes = nodes.get(now.x);
                for(Node n : nextNodes) {
                    if(!visit[n.x] && now.weight + n.weight < dist[n.x]) {
                        dist[n.x] = now.weight + n.weight;
                        p.add(new Node(n.x, now.weight + n.weight));
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        long weight;

        public Node(int x, long weight) {
            this.x = x;
            this.weight = weight;
        }
    }
}
