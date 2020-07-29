import java.util.Scanner;

public class array_3 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int[] arrint = new int[a];
		String b = null;
		String[] arr;

		for(int i = 0; i < a; i++) {
			int tmp = 0, seq=0;
			b = scan.next();
			arr = b.split("");
			
			for(int j=0; j< b.length();j++) {
				if(arr[j].equals("O")) {
					seq++;
					tmp += seq;
				}else {
					seq = 0;
					tmp += seq;
				}
			}
			arrint[i] = tmp;
		}
		
		for(int i = 0; i<a; i++) {
			System.out.println(arrint[i]);
		}
	}
}
