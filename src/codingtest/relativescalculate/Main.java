package codingtest.relativescalculate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] check;

    static int a;
    static int b;

    static int answer;
    static Queue<Integer> queue = new LinkedList<>();
    static int n;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        check = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[q][w] = 1;
            map[w][q] = 1;
        }

        bfs();
        if(!flag) {
            answer = -1;
        }

        System.out.println(answer);
    }

    private static void bfs() {

        List<Integer> list;
        queue.add(a);
        check[a] = true;

        while(!queue.isEmpty()) {
            list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll == b) {
                    flag = true;
                    return;
                }
                for(int i = 0; i<n+1; i++) {
                    if(!check[i] && map[poll][i] == 1) {
                        list.add(i);
                        check[i] = true;
                    }
                }
            }
            answer++;
            queue.addAll(list);
        }

    }
}
