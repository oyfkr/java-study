import java.util.Scanner;

public class Bertrand_postulate {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = 1;
		
		
		while(true) {
			int cnt = 0;
			n = scan.nextInt();
			if(n == 0) {
				break;
			}
			else {
				int[] prime= new int[2*n + 1];
				for(int i = 0; i<=2*n; i++) {
					prime[i] = 0;
				}prime[1] = 1;
				
				for(int i = 2; i<=2*n; i++) {
					for(int j = 2; i*j <=2*n; j++) {
						prime[i*j] = 1;
					}
				}
				for(int i = n+1; i <= 2*n; i++) {
					if(prime[i] != 1) cnt++;
					
				}
				System.out.println(cnt);
			}
		}
	}
}
