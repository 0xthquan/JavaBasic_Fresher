package assignments;
import java.util.ArrayList;
import java.util.Scanner;

/*
@author QuanTH17
*/

public class BT6 {
	public static void main(String[] args) {
		System.out.print("n: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		System.out.print("So nhi phan: ");
		toBinary(n);
	}

	private static void toBinary(int n) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		while(n!=0) {
			A.add(n%2);
			n /= 2;
		}
		for (int j = A.size()-1; j >= 0; j--) {
			System.out.print(A.get(j));
		}
	}
}
