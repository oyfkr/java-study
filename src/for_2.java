import java.util.Scanner;

public class for_2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		for(int i = 0; i< a; i++) {
			for(int j = 0; j < (a+1)/2; j++) {
				System.out.print("*" + " ");	
			}
			System.out.println();
			for(int h = 0; h < a/2; h++) {
				System.out.print(" "+"*");
			}
			System.out.println();
		}
	}
}
