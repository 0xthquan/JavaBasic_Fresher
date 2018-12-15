package assignments;
import java.util.Scanner;

/*
@author QuanTH17
*/

public class BT4 {
	public static void main(String[] args) {
		System.out.print("m: ");
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		s.close();
		System.out.println("S: " + sumBT4(m));
		System.out.println("P: " + multiBT4(m));
	}

	private static int multiBT4(int m) {
		int s = m%10;
		if(m<10) return m;
		return s*multiBT4(m/10);
	}

	private static int sumBT4(int m) {
		int s = m%10;
		if(m<10) return m;
		return s + sumBT4(m/10);
	}

}
