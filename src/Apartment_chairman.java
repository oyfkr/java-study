import java.util.Scanner;

public class Apartment_chairman {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int i = 0; i < T; i++) {
			int k = scan.nextInt();
			int n = scan.nextInt();
			System.out.println(el(k,n));
		}
	}	
		private static int el(int k, int n) {
			if(n==0)
				return 0;
			else if(k == 0)
				return n;
			else {
				return el(k,n-1) + el(k-1,n);
			}
		}

}
