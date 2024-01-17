package codingtest.baek1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int N,M,V;
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];

        for(int i = 0; i<=N;i++) {
            lists.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists.get(start).add(end);
            lists.get(end).add(start);
        }
        dfs(V);
        visit = new boolean[N+1];
        bfs(V);
    }

    private static void dfs(int v) {
        if(!visit[v]) {
            visit[v] = true;
            System.out.print(v + " ");
            List<Integer> integers = lists.get(v);
            List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
            for(int i : collect) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        System.out.println();

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if(!visit[now]) {
                System.out.print(now + " ");
                visit[now] = true;
                List<Integer> integers = lists.get(now);
                List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
                for(int i : collect) {
                    if(!visit[i]) {
                        queue.add(i);
                    }
                }
            }
        }
    }
}
