package assignments;
import java.util.Scanner;

/*
@author QuanTH17
*/

public class BT7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhap vao chuoi: ");
		String s = scan.nextLine();
		
		String reverse = new StringBuilder(s).reverse().toString();
		System.out.println(reverse);
		
		System.out.println(s.toUpperCase());
		
		System.out.println(s.toLowerCase());
			
		System.out.println();
		System.out.print("Nhap vao m: " );
		int m = scan.nextInt();
		System.out.print("Nhap vao n: ");
		int n = scan.nextInt();
		scan.close();
		System.out.println(s.substring(m, n));
		
		demKitu(s);
	}

	private static void demKitu(String s) {
		int[] dem = new int[255];
		for (int i = 0; i < s.length(); i++) {
			dem[s.charAt(i)]++;
		}
		for (int i = 0; i < dem.length; i++) {
			if(dem[i]!=0) {
				System.out.println( (char)i + ":" + dem[i]);
			}
		}
		
	}
	
	

}
