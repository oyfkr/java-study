import java.util.Scanner;

public class Find_Prime_Number {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a = 0;
		for(int i =0; i< N; i++) {
			int num = scan.nextInt();
			int remain = 0;
			for(int j = 1; j <= num; j++) {
				int remainer = num % j;
				if(remainer == 0) {
					remain++;
				}
			}
			if(remain == 2) {
				a++;
			}
		}
		System.out.println(a);
	}
}
