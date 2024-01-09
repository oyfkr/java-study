package codingtest.baek17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                if(!stack.contains('<')) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }else if(c == '<') {
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    sb.append(pop);
                }
                stack.push(c);
            }else if(c == '>') {
                StringBuilder closeSb = new StringBuilder();
                while (true) {
                    Character pop = stack.pop();
                    closeSb.append(pop);
                    if(pop == '<') {
                        break;
                    }
                }
                sb.append(closeSb.reverse());
                sb.append(c);
            } else {
                stack.push(c);
            }
        }

        if(!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }

        System.out.println(sb);
    }
}
