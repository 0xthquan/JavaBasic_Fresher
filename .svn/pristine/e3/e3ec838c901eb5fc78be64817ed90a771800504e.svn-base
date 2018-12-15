package assignments;
import java.util.Scanner;

/*
@author QuanTH17
*/

public class BT3 {
	public static void main(String[] args) {
		System.out.print("n: ");
		Scanner s = new Scanner(System.in);
		int n = 2*s.nextInt() - 1;
		s.close();
		System.out.println("S = " + sumBT3(n));
	}

	private static double sumBT3(int n) {
		double s = 1.0/giaithua(n);
		if(n==1) return 1;
		else return sumBT3(n-2) + s;
	}

	private static int giaithua(int n) {
		if(n<=1) return 1;
		else return n*giaithua(n-1);
	}
	
	
	
	
}
