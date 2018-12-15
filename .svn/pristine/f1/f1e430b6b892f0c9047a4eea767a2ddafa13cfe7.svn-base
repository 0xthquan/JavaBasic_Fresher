package assignments;
import java.util.Scanner;

/*
@author QuanTH17
*/

public class BT5 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("a: ");
		int a = s.nextInt();
		System.out.print("b: ");
		int b = s.nextInt();
		s.close();
		System.out.println("UCLN: " + ucln(a, b));
		System.out.println("BCNN: " + bcnn(a, b));
	}

	private static int bcnn(int a, int b) {
		return a*b/ucln(a,b);
	}

	private static int ucln(int a, int b) {
		if (a == b)
			return a;
		else if (a > b) {
			return ucln(a-b, b);
		} else return ucln(a, b-a);

	}
}
