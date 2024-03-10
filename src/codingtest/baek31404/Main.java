package codingtest.baek31404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int[][] A;
    static int[][] B;
    static Node[][] visitA;
    static Node[][] visitB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map = new int[x][y];
        visit = new boolean[x][y];
        A = new int[x][y];
        B = new int[x][y];
        visitA = new Node[x][y];
        visitB = new Node[x][y];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i<x;i++) {
            String s = br.readLine();
            for(int j = 0; j<s.length(); j++) {
                A[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        for(int i = 0; i<x;i++) {
            String s = br.readLine();
            for(int j = 0; j<s.length(); j++) {
                B[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        while (true) {
            visit[startX][startY] = true;


        }

    }

    static class Node{
        boolean visit;
        String d;

        public Node(boolean visit, String d){
            this.visit = visit;
            this.d = d;
        }
    }
}
