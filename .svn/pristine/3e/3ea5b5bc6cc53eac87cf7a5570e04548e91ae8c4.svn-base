/*
@author QuanTH17
*/
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.ImportException;

public class Testing {
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException {
		return SQLServerConnection.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner s = new Scanner(System.in);
		
		
		Pattern pattern = Pattern.compile("[0-9]{10}");
		System.out.println(pattern.matcher("0905353024").matches());
		System.out.println(s.nextLine().matches("[0-9]{10}"));
		System.out.print("Nhap bat cu thu gi: ");
		if(s.nextLine().isEmpty()){
			try {
				throw new ImportException("Chua nhap gi ca");
			} catch (ImportException e) {                            
				e.getMessage();
			}
		} 
		
		
		
		
		
		
		
		s.close();
//		System.out.println("Get connection ... ");
//
//		// Lấy ra đối tượng Connection kết nối vào database.
//		Connection conn = ConnectionUtils.getMyConnection();
//		
//		
//		System.out.println("Get connection " + conn);
//
//		System.out.println("Done!");
//		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		System.out.println("done");
	}
	
	public static void nhap() {
		Scanner s = new Scanner(System.in);
		try {
			throw new ImportException("Nhap sai");
		} catch (ImportException e) {
			nhap();
		}
	}
}
