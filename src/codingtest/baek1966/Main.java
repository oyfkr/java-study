package codingtest.baek1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<Node> q = new LinkedList<>();
            for(int j = 0; j<N;j++) {
                int importance = Integer.parseInt(st.nextToken());
                if(j == M) {
                    q.add(new Node(importance, true));
                } else {
                    q.add(new Node(importance, false));
                }
            }


            int cnt = 0;
            while (true) {
                int max = 0;
                for (Node node : q) {
                    max = Math.max(max, node.x);
                }

                Node poll;
                while (true) {
                    poll = q.poll();
                    if(poll.x != max) {
                        q.add(poll);
                    } else {
                        cnt++;
                        break;
                    }
                }
                if(poll.flag) {
                    System.out.println(cnt);
                    break;
                }
            }


        }
    }

    static class Node{
        int x;
        boolean flag;

        public Node(int x, boolean flag) {
            this.x = x;
            this.flag = flag;
        }
    }
}
