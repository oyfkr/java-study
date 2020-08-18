import java.util.Scanner;

public class hotel_guest {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] num = new int[T];
		for(int i = 0; i<T; i++) {
			int H = scan.nextInt();
			int W = scan.nextInt();
			int N = scan.nextInt();
		
			int floor= N%H, room = N/H+1;
			if(N%H == 0) {
				room = N/H;
				floor = H;
			}
			num[i] = floor*100 + room;
		}
		for(int i = 0; i<T; i++) {
			System.out.println(num[i]);
		}
	}
}
