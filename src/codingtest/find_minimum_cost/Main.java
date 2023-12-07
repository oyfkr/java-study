package codingtest.find_minimum_cost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] dijkstra;
    static boolean[] visit;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());

        dijkstra = new int[nodeCnt+1];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        visit = new boolean[nodeCnt+1];

        for(int i = 0; i<=nodeCnt; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<edgeCnt; i++) {
            StringTokenizer d = new StringTokenizer(br.readLine());
            int departNode = Integer.parseInt(d.nextToken());
            int arrivalNode = Integer.parseInt(d.nextToken());
            int weight = Integer.parseInt(d.nextToken());

            nodes.get(departNode).add(new Node(arrivalNode, weight));
        }

        StringTokenizer d = new StringTokenizer(br.readLine());
        int departNode = Integer.parseInt(d.nextToken());
        int arrivalNode = Integer.parseInt(d.nextToken());

        dijkstra[departNode] = 0;
        dijkstra(departNode);

        System.out.println(dijkstra[arrivalNode]);
    }

    private static void dijkstra(int departNode) {

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        q.add(new Node(departNode, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();

            if(!visit[now.v]) {
                visit[now.v] = true;
                List<Node> connectNodes = nodes.get(now.v);
                for(Node next : connectNodes) {
                    if(!visit[next.v] && dijkstra[next.v] > dijkstra[now.v] + next.cost) {
                        dijkstra[next.v] = dijkstra[now.v] + next.cost;
                        q.add(new Node(next.v, dijkstra[next.v]));
                    }
                }
            }
        }

    }


    static class Node{

        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

    }
}
