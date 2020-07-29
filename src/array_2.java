import java.util.Scanner;

public class array_2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int[] a = new int[9];
		for(int i = 0; i<9; i++) {
			a[i] = scan.nextInt();
		}
		int max = a[0];
		int seq  = 1;
		for(int i =0; i<9; i++) {
			if(max < a[i]) {
				max = a[i];
				seq = i+1;
			}
		}
		System.out.println(max);
		System.out.println(seq);
	}
}
