package codingtest.baek4637;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        boolean[] arr = new boolean[10001];

        for(int i = 1; i<10001;i++) {
            int d = d(i);
            if(d < 10001) {
                arr[d] = true;
            }
        }

        for(int j = 1; j<10001;j++) {
            if(!arr[j]) {
                System.out.println(j);
            }
        }
    }

    private static int d(int n) {
        int sum = n;

        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }
}
