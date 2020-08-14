import java.util.Scanner;

public class sugar {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		int count = 0;
		
		while(true) {
			if(input % 5 ==0) {
				System.out.println(input/5 +count);
				break;
			}else if(input < 0) {
				System.out.println(-1);
				break;
			}
			input = input -3;
			count++;
		}
	}
}
