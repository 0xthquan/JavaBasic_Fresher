/*
@author QuanTH17
*/
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import manageCandidate.Candidate;
import manageCandidate.Experience;
import utils.SQLServerConnection;

public class ExperienceDAO {
	
	public void insertExperienceToDB(Experience exp, Connection conn) throws ClassNotFoundException, SQLException {
		String sql = "SELECT CandidateID, ExpInYear, ProSkill FROM EXPERIENCE";
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
		rs.moveToInsertRow();
		rs.updateString("CandidateID", exp.getCandidateID());
		rs.updateInt("ExpInYear", exp.getExpInYear());
		rs.updateString("ProSkill", exp.getProSkill());
		rs.insertRow();
		
	}
	
	public void importExperience(Experience exp, Scanner scan) {
		System.out.print("\nImport Experience: ");
		exp.setExpInYear(Integer.parseInt(scan.nextLine()));
		System.out.print("\nImport ProSkill: ");
		exp.setProSkill(scan.nextLine());
	}
	
	public void updateExperience(Candidate candidate, Connection conn, Scanner scan) throws ClassNotFoundException, SQLException {
		String sql = "SELECT CandidateID, ExpInYear, ProSkill From Experience where CandidateID = " + candidate.getCandidateID();
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
		rs.beforeFirst();
		rs.next();
		String dataModified = null;
		System.out.print("Import ExpInYear: ");
		dataModified = scan.nextLine();
		if(!dataModified.isEmpty()) {
			rs.updateString("ExpInYear", dataModified);
		}
		System.out.print("Import ProSkill: ");
		dataModified = scan.nextLine();
		if(!dataModified.isEmpty()) {
			rs.updateString("ProSkill", dataModified);
		}
		rs.updateRow();
	}
	
	public void deleteExperience(String candidateID) {
		
	}
	
	public Experience getExperience(String candidateID) throws ClassNotFoundException, SQLException {
		String sql = "SELECT CandidateID, ExpInYear, ProSkill FROM EXPERIENCE where CandidateID = " +  candidateID;
		ResultSet rs = SQLServerConnection.getSQLServerConnection().createStatement().executeQuery(sql);
		rs.next();
		int expInYear = rs.getInt("ExpInYear");
		String proSkill = rs.getString("ProSkill");
		Experience exp = new Experience(expInYear, proSkill);
		exp.setCandidateID(candidateID);
		return exp;
	}
}
