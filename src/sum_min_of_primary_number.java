import java.util.Scanner;

public class sum_min_of_primary_number {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		int[] a = new int[50];
		int sum = 0;
		int min = 100000;
		int cnt1 = 0;
		
		//M부터 N까지 반복하는 for문
		for(int i = M; i<=N; i++) {
			int cnt = 0;
			//소수인지 아닌지만 판별하는 for문
			for(int j = 1; j <= i; j++) {
				int remain = i % j;
				if(remain == 0) {
					cnt++;
				}
			}
			//cnt가 2이면 소수
			if(cnt == 2) {
				sum = sum + i;
				if(min > i) {
					min = i;
				}
				cnt1++;
				//a[cnt1 - 1] = i;
			}
		}
		/*
		for(int i=0; i<cnt1; i++) {
			sum = sum + a[i];
		}*/
		if(cnt1 == 0) {
			System.out.println(-1);
		}else {
		System.out.println(sum);
		System.out.println(min);
		}
	}
}
