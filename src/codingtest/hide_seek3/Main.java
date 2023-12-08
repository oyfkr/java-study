package codingtest.hide_seek3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        times = new int[100000+1];

        dijkstra(N);
        System.out.println(times[K]);

    }

    private static void dijkstra(int N) {

        Arrays.fill(times, 100000);
        times[N] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if(times[now.x] < now.time) {
                continue;
            }

            int minusOne = now.x -1;
            if(valid(minusOne) && times[minusOne] > now.time + 1) {
                times[minusOne] = now.time + 1;
                q.add(new Node(minusOne, now.time + 1));
            }
            int plusOne = now.x + 1;
            if(valid(plusOne) && times[plusOne] > now.time + 1) {
                times[plusOne] = now.time + 1;
                q.add(new Node(plusOne, now.time + 1));
            }
            int xTwo = now.x * 2;
            if(valid(xTwo) && times[xTwo] > now.time) {
                times[xTwo] = now.time;
                q.add(new Node(xTwo, now.time));
            }

        }
    }

    private static boolean valid(int check) {
        return 0 <= check && check <= 100000;
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
