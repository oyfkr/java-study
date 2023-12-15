package codingtest.baek5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(sb.nextToken());
        int M = Integer.parseInt(sb.nextToken());

        visit = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i = 0; i<=N;i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++) {
            sb = new StringTokenizer(br.readLine());
            int a_i = Integer.parseInt(sb.nextToken());
            int b_i = Integer.parseInt(sb.nextToken());
            int c_i = Integer.parseInt(sb.nextToken());

            nodes.get(a_i).add(new Node(b_i, c_i));
            nodes.get(b_i).add(new Node(a_i, c_i));
        }

        dijkstra();
        System.out.println(dist[N]);
    }

    private static void dijkstra() {

        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);

        p.add(new Node(1,0));
        dist[1] = 0;

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> nextNode = nodes.get(now.x);
                for(Node n : nextNode) {
                    if(!visit[n.x] && now.weight + n.weight < dist[n.x]) {
                        dist[n.x] = now.weight + n.weight;
                        p.add(new Node(n.x, now.weight + n.weight));
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
