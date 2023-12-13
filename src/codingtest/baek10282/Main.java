package codingtest.baek10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] dist;
    static boolean[] visit;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            visit = new boolean[n+1];
            nodes = new ArrayList<>();
            for(int j = 0; j<=n; j++) {
                nodes.add(new ArrayList<>());
            }

            for(int j = 0; j<d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 의존 하는 컴퓨터
                int b = Integer.parseInt(st.nextToken()); // 의존 받는 컴퓨터
                int s = Integer.parseInt(st.nextToken()); // s 초 후

                nodes.get(b).add(new Node(a,s));
            }

            dijkstra(c);
            // 방문한 노드 개수 및 방문한 애들 중에 최댓값
            int cnt = 0;
            int max = 0;
            for(int j = 1; j< n+1;j++) {
                if(dist[j] != Integer.MAX_VALUE) {
                    cnt++;
                    max = Math.max(max, dist[j]);
                }
            }
            System.out.println(cnt + " " + max);
        }
    }

    private static void dijkstra(int c) {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);

        p.add(new Node(c, 0));
        dist[c] = 0;

        while(!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> nextNodes = nodes.get(now.x);
                for(Node nextNode : nextNodes) {
                    if(!visit[nextNode.x] && nextNode.weight + now.weight < dist[nextNode.x]) {
                        dist[nextNode.x] = nextNode.weight + now.weight;
                        p.add(new Node(nextNode.x, nextNode.weight + now.weight));
                    }
                }
            }
        }
    }
    static class Node{
        int x;
        int weight;

        public Node(int x, int weight) {
            this.x=x;
            this.weight = weight;
        }
    }
}
