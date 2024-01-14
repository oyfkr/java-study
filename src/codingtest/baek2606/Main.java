package codingtest.baek2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] visit;
    static List<List<Integer>> lists = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];

        for(int i = 0; i<=n;i++) {
            lists.add(new ArrayList<>());
        }

        int t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i<t; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lists.get(start).add(end);
            lists.get(end).add(start);
        }

        visit[1] = true;
        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int i) {
        List<Integer> integers = lists.get(i);

        for(Integer a : integers) {
            if(!visit[a]) {
                cnt++;
                visit[a] = true;
                dfs(a);
            }
        }

    }
}
