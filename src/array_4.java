import java.util.Scanner;

public class array_4 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int test_case, student=0, score, ave;
		
		
		test_case = scan.nextInt();
		
		double[] ave_num = new double[test_case];
		for(int i = 0; i < test_case; i++) {
			int ave_low = 0;
			int sum =0;
			student = scan.nextInt();
			int[] arr_score = new int[student];
			for(int j = 0; j < student; j++) {
				arr_score[j] = scan.nextInt();
				sum = sum + arr_score[j];
			}
			ave = sum / student;
			for(int j = 0; j < student; j++) {
				if(arr_score[j] > ave) {
					ave_low++;
				}
			}
			ave_num[i] = (double) ave_low / (double)student *100.0;
		}
		for(int i = 0; i< test_case; i++) {
			System.out.println(String.format("%.3f", ave_num[i])+"%");
		}
	}
}
