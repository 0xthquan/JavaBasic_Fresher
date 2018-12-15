package assignments;
import java.util.Scanner;

/*
@author QuanTH17
*/

public class BT2 {
	public static void main(String[] args) {
		System.out.print("n: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		System.out.println(sumBT2(n));
	}
	
	public static double sumBT2(int n) {
		double s = 1.0/n;
		if(n==1) return 1;
		else return sumBT2(n-1) + s;
	}
}
