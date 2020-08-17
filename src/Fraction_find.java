import java.util.Scanner;

public class Fraction_find {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int n=1,m=1, past =0,bun;
		int a=0,b=0;
		while(true) {
			if(past < num && num <=n) {
				bun = num-past;
				if(m%2 == 0) {
					for(int i = 1; i <= bun; i++) {
						a = i;
						b = m+1-a;
					}
					System.out.println(a + "/" + b);
					break;
				}else {
					for(int i = 1; i <=bun; i++) {
						a = m+1-i;
						b = i;
					}
					System.out.println(a + "/" + b);
					break;
				}
			}
			past = n;
			m++;
			n = n+m;
		}
	}
}
