package codingtest.baek10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final String POP = "pop";
    static final String PUSH = "push";
    static final String EMPTY = "empty";
    static final String TOP = "top";
    static final String SIZE = "size";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<N;i++) {
            String s = br.readLine();
            String[] s1 = s.split(" ");

            if(Objects.equals(s1[0], PUSH)) {
                stack.push(Integer.parseInt(s1[1]));
            } else if(Objects.equals(s1[0], TOP)) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(stack.peek());
                }
            } else if(Objects.equals(s1[0], SIZE)) {
                System.out.println(stack.size());
            } else if(Objects.equals(s1[0], EMPTY)) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(Objects.equals(s1[0], POP)) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(stack.pop());
                }
            }
        }
    }
}
