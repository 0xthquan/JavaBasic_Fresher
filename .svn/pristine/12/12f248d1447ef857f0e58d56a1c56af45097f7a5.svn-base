/*
@author QuanTH17
*/
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import manageCandidate.Candidate;
import manageCandidate.Intern;
import utils.SQLServerConnection;

public class InternDAO {
	public void insertInternToDB(Intern intern, Connection conn) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM INTERN";
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
		rs.moveToInsertRow();
		rs.updateString("CandidateID", intern.getCandidateID());
		rs.updateInt("Semester", intern.getSemester());
		rs.updateString("Major", intern.getMajors());
		rs.updateString("University_Name", intern.getUniversity_Name());
		rs.insertRow();
	}
	
	public void importIntern(Intern intern, Scanner scan) {
		System.out.print("\nImport Majors: ");
		intern.setMajors(scan.nextLine());
		System.out.print("\nImport Semester: ");
		intern.setSemester(Integer.parseInt(scan.nextLine()));
		System.out.print("\nImport University Name: ");
		intern.setUniversity_Name(scan.nextLine());
		
		Candidate.candidate_Count++;
	}
	
	public void deleteIntern(String candidateID) {
		
	}
	
	public void updateIntern(Candidate candidate, Connection conn, Scanner scan) throws ClassNotFoundException, SQLException {
		String sql = "SELECT CandidateID, Major, Semester, University_Name From INTERN where CandidateID = " + candidate.getCandidateID();
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
		rs.beforeFirst();
		rs.next();
		String dataModified = null;
		System.out.print("Import Major: ");
		dataModified = scan.nextLine();
		if(!dataModified.isEmpty()) {
			rs.updateString("Major", dataModified);
		}
		System.out.print("Import Semester: ");
		dataModified = scan.nextLine();
		if(!dataModified.isEmpty()) {
			rs.updateInt("Semester", Integer.parseInt(dataModified));
		}
		System.out.print("Import University Name: ");
		dataModified = scan.nextLine();
		if(!dataModified.isEmpty()) {
			rs.updateString("University_Name", dataModified);
		}
		rs.updateRow();
	}
	
	public Intern getIntern(String candidateID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT CandidateID, Major, Semester, University_Name FROM INTERN where CandidateID = " +  candidateID;
		ResultSet rs = SQLServerConnection.getSQLServerConnection().createStatement().executeQuery(sql);
		rs.next();
		String major = rs.getString("Major");
		int semester = rs.getInt("Semester");
		String universityName = rs.getString("University_Name");
		Intern intern = new Intern(major, semester, universityName);
		intern.setCandidateID(candidateID);
		return intern;
	}
	
	
}
