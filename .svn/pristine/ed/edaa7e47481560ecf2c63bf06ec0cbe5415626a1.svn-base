/*
@author QuanTH17
*/
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerConnection {
	public static Connection getSQLServerConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "ManageCandidate";
		String user = "sa";
		String pass = "123qweqwe";
		return getSQLServerConnection(hostName, sqlInstanceName, database, user, pass);

	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database,
			String user, String pass) throws ClassNotFoundException, SQLException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		String connectionURL =  "jdbc:jtds:sqlserver://" + hostName + ":1433/"
	             + database + ";instance=" + sqlInstanceName;

		Connection conn = DriverManager.getConnection(connectionURL, user, pass);
		return conn;

	}

//	public static ResultSet getResultSet(String sql) throws ClassNotFoundException, SQLException {
//		return SQLServerConnection.getSQLServerConnection()
//				.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
//	}
	
	public static ResultSet getResultSet(String sql, Connection conn) throws ClassNotFoundException, SQLException {
		return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
	}
	
}
