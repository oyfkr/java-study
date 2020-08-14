import java.util.Scanner;

public class break_even_point {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int fix = scan.nextInt();
		int flu = scan.nextInt();
		int price = scan.nextInt();
		int num = 0;
		
		if(flu >= price) {
			System.out.println(-1);
		}else {
			System.out.println(fix/(price-flu)+1);
		}
	}
}
