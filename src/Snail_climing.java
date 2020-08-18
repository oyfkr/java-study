import java.util.Scanner;

public class Snail_climing {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		long b = scan.nextInt();
		int v = scan.nextInt();
		
		long temp = ((v-b) / (a-b));
		if((v-b) % (a-b) !=0) {
			temp++;
		}
		System.out.println(temp);
	}
}
