import java.util.Scanner;

public class for_1 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a,b;
		a = scan.nextInt();
		b = scan.nextInt();
		
		int[] c = new int[a];
		
		for(int i = 0; i < a; i++) {
			c[i] = scan.nextInt();
		}
		scan.close();
		for(int i = 0; i<a; i++) {
			if(b > c[i]) {
				System.out.print(c[i] + " ");
			}
		}
	}
}
