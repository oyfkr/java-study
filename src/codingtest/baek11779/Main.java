package codingtest.baek11779;

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
    static int[] route;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];
        dist = new int[n+1];
        route = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i<=n;i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end =  Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);

        List<Integer> routes = new ArrayList<>();
        int current = end;
        while (current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());
        for(int i = routes.size()-1; i>=0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> p = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));

        p.add(new Node(start, 0));

        while(!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> connectedNode = nodes.get(now.x);
                for(Node n : connectedNode) {
                    if(!visit[n.x] && n.weight + now.weight < dist[n.x]) {
                        dist[n.x] = n.weight + now.weight;
                        p.add(new Node(n.x, n.weight + now.weight));
                        route[n.x] = now.x;
                    }
                }
            }
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
