import java.util.Scanner;

public class fly_me_to_the_Alpha_Centauri {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int i=0; i<T; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			int distance = y-x;
			
			int max = (int)Math.sqrt(distance);
			
			if(max == Math.sqrt(distance)) {
				System.out.println(max * 2 -1);
			}else if(distance <= max *max + max) {
				System.out.println(max * 2);
			}else {
				System.out.println(max * 2 + 1);
			}
		}
	}
}
