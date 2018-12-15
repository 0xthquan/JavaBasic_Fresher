package assignments;
import java.util.Scanner;

/*
@author QuanTH17
*/

public class BT9 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Nhap vao m: ");
		int m = s.nextInt();
		System.out.print("\nNhap vao n: ");
		int n = s.nextInt();
		int[][] matrix = new int[m][n];
		int x,y;
		for (int i = 0; i < m; i++) {
			x = i+1;
			for (int j = 0; j < n; j++) {
				y = j+1;
				System.out.print("\nNhap phan tu vi tri [" + x + "][" + y + "]: ");
				matrix[i][j] = s.nextInt();
			}
		}
		
		System.out.println("Tich cac so la boi so cua 3 nam tren dong dau tien: " + multi(matrix));
		createArrayX(matrix);
	}

	private static void createArrayX(int[][] matrix) {
		int x[] = new int[matrix.length];
		for (int i = 0; i < x.length; i++) {
			x[i] = maxInRow(matrix[i]);
		}
		System.out.print("Mang X: ");
		for (int i : x) {
			System.out.print(i + " ");
		}
	}

	private static int maxInRow(int[] matrix) {
		int max = matrix[0];
		for (int i = 0; i < matrix.length; i++) {
			max = matrix[i]>max? matrix[i] : max;
		}
		return max;
	}

	private static int multi(int[][] matrix) {
		int p = 1;
		for (int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i]%3==0) {
				p*=matrix[0][i];
			}
		}
		return p;
	}
	
	
	
}
