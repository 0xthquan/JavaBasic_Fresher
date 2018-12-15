/*
@author QuanTH17
*/
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import manageCandidate.Certificate;
import utils.SQLServerConnection;

public class CertificatedDAO {
	public void insertCertToDB(Certificate cert, String candidateID, Connection conn)
			throws ClassNotFoundException, SQLException, ParseException {
		String sql = "SELECT * FROM CERTIFICATED";
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
		
		rs.moveToInsertRow();
		rs.updateString("CertificatedID", cert.getCertificatedID());
		rs.updateString("Certificate_Name", cert.getCertificatedName());
		rs.updateString("Certificate_Rank", cert.getCertificatedRank());
		rs.updateDate("Certificated_Date", new java.sql.Date(cert.getCertificatedDate().getTime()));
		rs.updateString("CandidateID", candidateID);
		rs.insertRow();

	}

	public void importCert(Certificate cert, Scanner scan) throws ParseException {
		System.out.print("\n=====Import Certificated======");
		System.out.print("\nImport Certificate ID: ");
		cert.setCertificatedID(scan.nextLine());
		System.out.print("\nImport Certificate Name: ");
		cert.setCertificatedName(scan.nextLine());
		System.out.print("\nImport Certificate Rank: ");
		cert.setCertificatedRank(scan.nextLine());
		System.out.print("\nImport Certificate Date: ");
		cert.setCertificatedDate(new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine()));
	}
}
