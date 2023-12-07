package codingtest.find_city_specific_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시

        dis = new int[n+1];

        for(int i = 0; i<=n; i++) {
            graph.add(new ArrayList<>());
            dis[i] = -1;
        }

        for(int i = 0; i < m; i++) {

            StringTokenizer d = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(d.nextToken());
            int r = Integer.parseInt(d.nextToken());

            graph.get(q).add(r);
        }

        dis[x] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while(!queue.isEmpty()) {
            Integer now = queue.poll();
            List<Integer> integers = graph.get(now);
            for(int i = 0; i<integers.size(); i++) {
                Integer next = integers.get(i);
                if(dis[next] == -1) {
                    dis[next] = dis[now] + 1;
                    queue.offer(next);
                }
            }
        }

        boolean flag = false;

        for(int i = 1; i< dis.length; i++) {
            if(dis[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if(!flag) {
            System.out.println(-1);
        }
    }
}
