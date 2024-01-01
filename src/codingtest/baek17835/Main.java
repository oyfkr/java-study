package codingtest.baek17835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visit;
    static long[] dist;
    static int N;
    static PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> Math.toIntExact(o1.weight - o2.weight));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 거리 개수
        int K = Integer.parseInt(st.nextToken()); // 면접장 수

        for(int i = 0; i<N+1;i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(end).add(new Node(start, weight));
        }

        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        visit = new boolean[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<K;i++) {
            int index = Integer.parseInt(st.nextToken());
            p.add(new Node(index, 0));
            dist[index] = 0;
        }

        dijkstra();

        int answer1 = 0;
        long answer2 = 0;
        for(int i = 1; i<=N;i++) {
            if(answer2 < dist[i]) {
                answer2 = dist[i];
                answer1 = i;
            }
        }

        System.out.println(answer1);
        System.out.println(answer2);
    }

    private static void dijkstra() {

        while (!p.isEmpty()) {
            Node now = p.poll();
            if(!visit[now.x]) {
                visit[now.x] = true;

                List<Node> connectedNodes = nodes.get(now.x);
                for(Node c : connectedNodes) {
                    if(!visit[c.x] && dist[c.x] > now.weight + c.weight) {
                        dist[c.x] = now.weight + c.weight;
                        p.add(new Node(c.x, now.weight + c.weight));
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        long weight;

        public Node(int x, long weight) {
            this.x = x;
            this.weight = weight;
        }
    }
}
