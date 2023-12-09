package codingtest.party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dist;
    static boolean[] visit;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visit = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i = 0; i<N+1;i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.get(x).add(new Node(y, w));
        }

        dijkstra(X);
        int[] nTo = new int[N+1];
        System.arraycopy(dist, 0, nTo, 0, dist.length);
        int[] toN = new int[N+1];

        for(int i = 1; i<=N;i++) {
            dist = new int[N+1];
            visit = new boolean[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            dijkstra(i);
            toN[i] = dist[X];
        }

        int max = 0;
        for (int i = 0; i< dist.length;i++) {
            int sum = nTo[i] + toN[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    private static void dijkstra(int X) {

        PriorityQueue<Node> p = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        dist[X] = 0;

        p.add(new Node(X, 0));

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.y]) {
                visit[now.y] = true;

                List<Node> nowConnectNode = nodes.get(now.y);
                for(Node node : nowConnectNode) {
                    if(!visit[node.y] && node.weight + now.weight < dist[node.y]) {
                        p.add(new Node(node.y, node.weight + now.weight));
                        dist[node.y] = node.weight + now.weight;
                    }
                }
            }
        }
    }

    static class Node{
        int y;
        int weight;

        public Node(int y, int weight) {
            this.y = y;
            this.weight = weight;
        }
    }
}
