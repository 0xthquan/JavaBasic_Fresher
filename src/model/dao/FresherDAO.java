/*
@author QuanTH17
*/
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import manageCandidate.Candidate;
import manageCandidate.Fresher;
import utils.SQLServerConnection;

public class FresherDAO {

	public void insertFresherToDB(Fresher fresher, Connection conn) throws ParseException, ClassNotFoundException, SQLException {
		String sql = "SELECT CandidateID, Graduation_Rank, Education, Graduation_Date FROM FRESHER";
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
		rs.moveToInsertRow();
		rs.updateString("CandidateID", fresher.getCandidateID());
		rs.updateString("Graduation_Rank", fresher.getGraduation_Rank());
		rs.updateString("Education", fresher.getEducation());
		rs.updateDate("Graduation_Date", new java.sql.Date(fresher.getGraduation_Date().getTime()));
		rs.insertRow();

	}

	public void importFresher(Fresher fresher, Scanner scan) throws ParseException {
		System.out.print("\nImport Education: ");
		fresher.setEducation(scan.nextLine());
		System.out.print("\nImport Graduation Rank: ");
		fresher.setGraduation_Rank(scan.nextLine());
		System.out.print("\nImport Graduation Date: ");
		fresher.setGraduation_Date(new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine()));

		Candidate.candidate_Count++;
	}

	public void updateFresher(Candidate candidate, Connection conn, Scanner scan) throws ClassNotFoundException, SQLException, ParseException {
		String sql = "SELECT CandidateID, Education, Graduation_Rank, Graduation_Date FROM FRESHER where CandidateID = "
				+ candidate.getCandidateID();
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
		rs.beforeFirst();
		rs.next();
		String dataModified = null;
		System.out.print("Import Education: ");
		dataModified = scan.nextLine();
		if (!dataModified.isEmpty()) {
			rs.updateString("Education", dataModified);
		}
		System.out.print("Import Graduation Rank: ");
		dataModified = scan.nextLine();
		if (!dataModified.isEmpty()) {
			rs.updateString("Graduation_Rank", dataModified);
		}
		System.out.print("Import Graduation Date: ");
		dataModified = scan.nextLine();
		if (!dataModified.isEmpty()) {
			rs.updateDate("Graduation_Date",
					new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(dataModified).getTime()));
		}
		rs.updateRow();
	}

	public Fresher getFresher(String candidateID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT CandidateID, Education, Graduation_Rank, Graduation_Date FROM FRESHER where CandidateID = "
				+ candidateID;
		ResultSet rs = SQLServerConnection.getSQLServerConnection().createStatement().executeQuery(sql);
		rs.next();
		String education = rs.getString("Education");
		String graduationRank = rs.getString("Graduation_Rank");
		Date graduationDate = new Date(rs.getDate("Graduation_Date").getTime());
		Fresher fresher = new Fresher(graduationDate, graduationRank, education);
		fresher.setCandidateID(candidateID);
		return fresher;
	}
}
