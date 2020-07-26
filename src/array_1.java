import java.util.Scanner;

public class array_1 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int[] b = new int[a];
		int min,max;
		
		for(int i = 0; i < a; i++) {
			b[i] = scan.nextInt();
		}
		min = b[0];
		max = b[0];
		for(int i = 0; i<a; i++) {
			if(min > b[i]) {
				min = b[i];
			}
			if(max < b[i]) {
				max = b[i];
			}
		}
		System.out.print(min + " ");
		System.out.println(max);
	}
}
