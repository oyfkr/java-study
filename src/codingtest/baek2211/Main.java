package codingtest.baek2211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visit;
    static int[] dist;
    static int[] ago;
    static HashSet<String> resultSet = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ago = new int[N+1];

        for(int i = 0; i<=N;i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i  = 0; i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            nodes.get(A).add(new Node(B,C));
            nodes.get(B).add(new Node(A,C));
        }

        dijkstra(N);

        System.out.println(resultSet.size());
        for(String str : resultSet) {
            System.out.println(str);
        }
    }

    private static void dijkstra(int N) {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);

        p.add(new Node(1,0));

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> nextNodes = nodes.get(now.x);
                for(Node n : nextNodes) {
                    if(!visit[n.x] && n.weight + now.weight < dist[n.x]) {
                        dist[n.x] = n.weight + now.weight;
                        ago[n.x] = now.x;
                        p.add(new Node(n.x, n.weight + now.weight));
                    }
                }
            }
        }

        for(int i = 2; i<=N;i++) {
            int end = i;
            while(ago[end] != 0) {
                resultSet.add(new String(end + " " + ago[end]));
                end = ago[end];
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
