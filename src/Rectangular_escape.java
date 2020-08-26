import java.util.Scanner;

public class Rectangular_escape {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		//x,y,w,h 입력받기
		int x = scan.nextInt();
		int y = scan.nextInt();
		int w = scan.nextInt();
		int h = scan.nextInt();
		int m = 0;
		int horizon = w-x;
		if(horizon >= x) {
			horizon = x;
		}
		int vertical = h-y;
		if(vertical >= y) {
			vertical = y;
		}
		
		if(horizon >= vertical) {
			System.out.println(vertical);
		}else {
			System.out.println(horizon);
		}
	}
}
