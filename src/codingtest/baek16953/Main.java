package codingtest.baek16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int answer = 0;
        while (true) {

            int b = B.charAt(B.length()-1) - '0';
            if(b != 1 && b % 2 == 1) {
                answer = -1;
                System.out.println(answer);
                break;
            } else if (b == 1) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<B.length()-1;i++) {
                    sb.append(B.charAt(i));
                }
                B = sb.toString();
                answer++;
            } else {
                B = String.valueOf(Integer.parseInt(B)/2);
                answer++;
            }

            if(Integer.parseInt(A) > Integer.parseInt(B)) {
                answer = -1;
                System.out.println(answer);
                break;
            }

            if(B.equals(A)) {
                System.out.println(answer+1);
                break;
            }
        }
    }
}
