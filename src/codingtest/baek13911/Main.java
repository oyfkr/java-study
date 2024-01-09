package codingtest.baek13911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> nodes = new ArrayList<>();
    static int[] dist;
    static boolean[] visit;
    static int[] mDist;
    static PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> o1.weight - o2.weight);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        for(int i = 0; i<=V; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<E;i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes.get(u).add(new Node(v,w));
            nodes.get(v).add(new Node(u,w));
        }

        st = new StringTokenizer(br.readLine());
        int mCnt = Integer.parseInt(st.nextToken());
        int mCondition = Integer.parseInt(st.nextToken());

        List<Integer> notHouse = new ArrayList<>();
        int[] mArr = new int[mCnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<mCnt; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            mArr[i] = tmp;
            notHouse.add(tmp);
        }

        st = new StringTokenizer(br.readLine());
        int sCnt = Integer.parseInt(st.nextToken());
        int sCondition = Integer.parseInt(st.nextToken());

        int[] sArr = new int[sCnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<sCnt; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sArr[i] = tmp;
            notHouse.add(tmp);
        }

        init(V);

        for(int i = 0;i<mCnt; i++) {
            p.add(new Node(mArr[i],0));
            dist[mArr[i]] = 0;
        }

        dijkstra();
        mDist = dist;

        init(V);
        for(int i = 0; i<sCnt; i++) {
            p.add(new Node(sArr[i],0));
            dist[sArr[i]] = 0;
        }

        dijkstra();

        System.out.println(findAnswer(sCondition, mCondition, notHouse));
    }

    private static void dijkstra() {

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> connectedNodes = nodes.get(now.x);
                for(Node c : connectedNodes) {
                    if(!visit[c.x] && c.weight + now.weight < dist[c.x]) {
                        dist[c.x] = c.weight + now.weight;
                        p.add(new Node(c.x, c.weight + now.weight));
                    }
                }
            }
        }
    }

    private static int findAnswer(int sCondition, int mCondition, List<Integer> notHouse) {
        int answer = -1;
        for(int i = 1; i<dist.length;i++) {
            if(!notHouse.contains(i)) {
                if(dist[i] <= sCondition && mDist[i] <= mCondition) {
                    int dis = dist[i] + mDist[i];
                    if(answer == -1) {
                        answer = dis;
                    } else {
                        answer = Math.min(answer, dis);
                    }
                }
            }
        }

        return answer;
    }

    private static void init(int V) {
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[V+1];
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
