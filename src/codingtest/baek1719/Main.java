package codingtest.baek1719;

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
    static int[] history;
    static String[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new String[n+1][n+1];

        for(int i = 0; i<=n; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(start).add(new Node(end, weight));
            nodes.get(end).add(new Node(start, weight));
        }

        for(int i = 1; i<=n;i++) {
            history = new int[n+1];
            dist = new int[n+1];
            visit = new boolean[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i);
            for(int j = 1; j<=n;j++) {
                if(i == j) {
                    list[i][j] = "-";
                } else {
                    list[i][j] = String.valueOf(getFirst(i,j));
                }
            }
        }

        for(int i = 1; i<=n;i++) {
            for(int j = 1; j<=n;j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getFirst(int start, int end) {

        while (history[end] != start) {
            end = history[end];
        }

        return end;
    }

    private static void dijkstra(int i) {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);

        p.add(new Node(i,0));

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                List<Node> nextNodes = nodes.get(now.x);
                for(Node n : nextNodes) {
                    if(!visit[n.x] && n.weight + now.weight < dist[n.x]) {
                        dist[n.x] = n.weight + now.weight;
                        p.add(new Node(n.x, n.weight + now.weight));
                        history[n.x] = now.x;
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int weight;

        public Node (int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }
}
