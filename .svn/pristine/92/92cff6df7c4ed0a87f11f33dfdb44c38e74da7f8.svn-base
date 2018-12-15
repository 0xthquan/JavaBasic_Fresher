package assignments;
import java.util.Scanner;
import java.util.Stack;

import javax.naming.CommunicationException;

/*
@author QuanTH17
*/

public class BT8 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[10];
		int i = 0;
		
		System.out.println("Nhap tung phan tu cua a");
		while(true) {
			String str = s.nextLine();
			if(str.equals("q")) break;
			else arr[i++] = Integer.parseInt(str); 
		}

		
		while(true) {
			System.out.println("Chon option: \n"
					+ "1. Tong so dung le cua mang\n"
					+ "2. Tim phan tu k bat ki nhap tu ban phim\n"
					+ "3. Sap xep mang theo thu tu tang dan\n"
					+ "4. Chen vao mang mot phan tu dam bao van tang dan\n");
			int option = s.nextInt();
			switch (option) {
			case 1:
				System.out.println("Tong so duong le: " + sumOdd(arr));
				break;
			case 2:
				System.out.print("Nhap vao phan tu k: ");
				int k = s.nextInt();
				find(k, arr);
				break;
			case 3:
				arrange(arr);
				break;
			case 4:
				System.out.print("Nhap vao phan tu p: ");
				int p = s.nextInt();
				insert(p, arr);
				break;
			default:
				break;
			}
			
		}
		
		
	}

	private static void insert(int p, int[] arr) {
		for (int  i= 0;  i< arr.length;) {
			if(p>=i && p<=i+1) {
				int temp = 0;
				for (int j = arr.length-1; j < i; j++) {
					arr[j+1] = arr[j];
					temp = j;
				}
				arr[temp] = p;
			}
		}
	}

	private static void arrange(int[] arr) {
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.print("Cac phan tu trong mang sau khi sap xep");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void find(int k, int[] arr) {
		int i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while(i<arr.length) {
			if(arr[i]!=k) {
				i++;
				continue;
			}
			stack.push(i);
			i++;
		}
		if(stack.isEmpty()) System.out.println("Khong co phan tu" + k + "trong mang");
		else {
			System.out.print("Cac vi tri cua phan tu k: ");
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+1 + " ");
			}
			System.out.println();
		}
	}

	private static int sumOdd(int[] arr) {
		int i = 0;
		int sum = 0;
		while(i<arr.length) {
			if(arr[i]%2==0 || arr[i]<0) {
				i++;
				continue;
			}
			sum+= arr[i];
			i++;
		}
		return sum;
	}
}
