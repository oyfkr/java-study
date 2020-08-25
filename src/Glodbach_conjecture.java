import java.util.Scanner;

public class Glodbach_conjecture {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int a,b;
		
		for(int i = 0; i< T; i++) {
			int n = scan.nextInt();
			for(a =n/2,b=n/2;; a++,b--) {
				n = a+b;
				if(check(a) && check(b)) {
					System.out.println(b+" "+a);
					break;
				}
			}
		}
	}
	public static boolean check(int n) {
		for(int i = 2; i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
