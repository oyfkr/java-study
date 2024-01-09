package codingtest.baek16118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> nodes = new ArrayList<>();
    static long[] foxDist;
    static long[][] wolfDist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        InputReader in = new InputReader(System.in);
        int N = in.readInt();
        int M = in.readInt();

        foxDist = new long[N+1];
        wolfDist = new long[2][N+1]; // 0이면 다음은 빠르게, 1이면 다음은 느리게
        visit = new boolean[N+1];
        for(int i = 0; i<=N;i++) {
            foxDist[i] = Integer.MAX_VALUE;
            wolfDist[0][i] = Integer.MAX_VALUE;
            wolfDist[1][i] = Integer.MAX_VALUE;
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i<M;i++) {
//            st = new StringTokenizer(br.readLine());
            int start = in.readInt();
            int end = in.readInt();
            int weight = in.readInt();

            nodes.get(start).add(new Node(end, weight));
            nodes.get(end).add(new Node(start, weight));
        }

        dijkstraForFox();

        dijkstraForWolf();

        int answer = 0;

        for(int i =2; i<=N;i++) {
            if(foxDist[i] < Math.min(wolfDist[0][i], wolfDist[1][i])) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dijkstraForFox() {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> Math.toIntExact(o1.weight - o2.weight));

        p.add(new Node(1,0));
        foxDist[1] = 0;

        while (!p.isEmpty()) {
            Node now = p.poll();

            if(!visit[now.x]) {
                visit[now.x] = true;
                List<Node> connectedNodes = nodes.get(now.x);
                for(Node c : connectedNodes) {
                    if(!visit[c.x] && c.weight * 2 + now.weight < foxDist[c.x]) {
                        foxDist[c.x] = c.weight * 2 + now.weight;
                        p.add(new Node(c.x, c.weight * 2 + now.weight));
                    }
                }
            }
        }
    }

    private static void dijkstraForWolf() {
        PriorityQueue<Node> p = new PriorityQueue<>((o1,o2) -> Math.toIntExact(o1.weight - o2.weight));

        // 0일때 다음꺼 빠르게, 1일때 다음꺼 느리게 / fast : 다음꺼를 빠르게 간다 = 이번에 늦게 들어왔다
        p.add(new Node(1,0,0));
        wolfDist[0][1] = 0;

        while (!p.isEmpty()) {
            Node now = p.poll();

            int end = now.x;
            long nowTime = now.weight;

            if(wolfDist[now.state][now.x] < nowTime) {
                continue;
            }

            List<Node> connectedNodes = nodes.get(end);
            for(Node c : connectedNodes) {
                int state = 1 - now.state;
                long cost = wolfDist[now.state][now.x] + ((now.state == 0) ? c.weight : c.weight * 4L);
                if(cost < wolfDist[state][c.x]) {
                    wolfDist[state][c.x] = cost;
                    p.add(new Node(c.x, cost, state));
                }
            }
        }
    }

    static class Node {
        int x;
        long weight;
        int state;
        public Node(int x, long weight) {
            this.x = x;
            this.weight = weight;
        }

        public Node(int x, long weight, int state) {
            this.x = x;
            this.weight = weight;
            this.state = state;
        }
    }

    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
