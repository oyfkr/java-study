import java.util.Scanner;

public class Hexagon_counting {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int n = 1, m=1 ,past=0;
		while(true) {
			if(6*past+1 < num && num <=6*(n)+1) {
				System.out.println(m+1);
				break;
			}else if( num == 1) {
				System.out.println(1);
				break;
			}
			m++;
			past = n;
			n = n+m;
		}
	}
}
