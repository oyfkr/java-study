package codingtest.baek1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n,d;
    static int[] movedDistance; // 실제로 이동한 거리를 저장하는 배열
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        movedDistance = new int[d+1];
        node = new Node[n];
        Arrays.fill(movedDistance, Integer.MAX_VALUE);

        for(int i = 0; i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            node[i] = new Node(start, end, weight);
        }

        Arrays.sort(node);

        int nowDistance = 0; // 지금 현재 진행중인 거리
        int nowIndex = 0; // 지름길 순서
        movedDistance[0] = 0;

        while (nowDistance < d) {
            while (nowIndex < n) {
                if(node[nowIndex].start != nowDistance) {
                    break;
                }

                // 지름길 이동
                if(node[nowIndex].end <=d) {
                    int tmp = movedDistance[nowDistance] + node[nowIndex].weight;
                    if(tmp < movedDistance[node[nowIndex].end]) {
                        movedDistance[node[nowIndex].end] = tmp;
                    }
                }
                nowIndex++;
            }

            // 다음 배열에 +1한 값을 추가
            if(movedDistance[nowDistance] + 1 < movedDistance[nowDistance+1]) {
                movedDistance[nowDistance + 1] = movedDistance[nowDistance] + 1;
            }

            nowDistance++;
        }

        System.out.println(movedDistance[d]);
    }

    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            if(this.start < o.start) {
                return  -1;
            }
            return 1;
        }
    }
}
