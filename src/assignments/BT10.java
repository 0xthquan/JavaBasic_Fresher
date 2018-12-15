package assignments;
/*
@author QuanTH17
*/

public class BT10 {
	int b = 10;
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a);
		BT10 obj = new BT10();
		obj.change(a);
		System.out.println(a);
		obj.change(obj);
		System.out.println(obj.b);
		
	}
	
	
	/**
	 * pass by value
	 */
	public void change(int a) {
		a = a*a;
	}
	
	/**
	 * pass by reference
	 */
	public void change(BT10 obj) {
		obj.b = obj.b*obj.b;
	}
}
