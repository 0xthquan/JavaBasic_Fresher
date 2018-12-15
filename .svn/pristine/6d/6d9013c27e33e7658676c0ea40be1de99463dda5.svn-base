/*
@author QuanTH17
*/
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import exception.ImportException;
import manageCandidate.Candidate;
import manageCandidate.Experience;
import manageCandidate.Fresher;
import manageCandidate.Intern;
import utils.SQLServerConnection;

public class CandidateDAO {
	public void insertCandidateToDB(Candidate candidate, Connection conn)
			throws ClassNotFoundException, SQLException, ParseException {
		String sql = "SELECT CandidateID, FullName, BirthDay, Email, Phone, Candidate_Type FROM CANDIDATE";
		ResultSet rs = SQLServerConnection.getResultSet(sql, conn);

		rs.moveToInsertRow();
		rs.updateString("CandidateID", candidate.getCandidateID());
		rs.updateString("FullName", candidate.getFullName());
		rs.updateString("Phone", candidate.getPhone());
		rs.updateDate("BirthDay", new java.sql.Date(candidate.getBirthDay().getTime()));
		rs.updateString("Email", candidate.getEmail());
		rs.updateInt("Candidate_Type", candidate.getCandidate_Type());
		rs.insertRow();
	}

	public Candidate importCandidate(Scanner scan) throws ParseException {
		System.out.println("======IMPORT NEW CANDIDATE=======");
		System.out.print("\nImport Candidate Type(0.Experience | 1.Fresher | 2.Intern): ");
		int candidateType = Integer.parseInt(scan.nextLine());
		Candidate candidate = null;
		switch (candidateType) {
		case 0:
			candidate = new Experience();
			break;
		case 1:
			candidate = new Fresher();
			break;
		case 2:
			candidate = new Intern();
			break;
		default:
			break;
		}
		candidate.setCandidate_Type(candidateType);
		System.out.print("Candidate ID: ");
		candidate.setCandidateID(scan.nextLine());
		System.out.print("Full Name: ");
		candidate.setFullName(scan.nextLine());
		System.out.print("Birthday: ");
		candidate.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine()));
		System.out.print("Email: ");
		candidate.setEmail(scan.nextLine());
		candidate.setPhone(importPhone(scan));

		return candidate;
	}

	public void updateCandidate(Connection conn, Scanner scan)
			throws ClassNotFoundException, SQLException, ParseException {
		System.out.print("Please enter candidate ID will be modified: ");
		PreparedStatement checkCandidateIDExist = conn
				.prepareStatement("SELECT 1 FROM CANDIDATE WHERE CandidateID = ?");
		String candidateID = scan.nextLine();

		checkCandidateIDExist.setString(1, candidateID);
		if (checkCandidateIDExist.executeQuery().next()) {

			String sql = "SELECT * from CANDIDATE where CandidateID = " + candidateID;
			ResultSet rs = SQLServerConnection.getResultSet(sql, conn);
			rs.beforeFirst();
			String dataModified;
			rs.next();
			int candidateType = rs.getInt("Candidate_Type");
			System.out.println("-->Press Enter if you dont wanna modify any field<--");
			System.out.print("\nImport Full Name: " + rs.getString("FullName") + " --> ");
			dataModified = scan.nextLine();
			if (!dataModified.isEmpty()) {
				rs.updateString("FullName", dataModified);
			}
			System.out.print("\nImport Phone Number: ");
			dataModified = scan.nextLine();
			if (!dataModified.isEmpty()) {
				rs.updateString("Phone", dataModified);
			}
			System.out.print("\nImport Birthday: ");
			dataModified = scan.nextLine();
			if (!dataModified.isEmpty()) {
				rs.updateDate("BirthDay",
						new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(dataModified).getTime()));
			}
			System.out.print("\nImport Email: ");
			dataModified = scan.nextLine();
			if (!dataModified.isEmpty()) {
				rs.updateString("Email", dataModified);
			}
			System.out.print("\nImport Candidate Type: ");
			dataModified = scan.nextLine();
			if (dataModified.isEmpty() || dataModified.equals(Integer.toString(candidateType))) {
				dataModified = Integer.toString(rs.getInt("Candidate_Type"));
				switch (candidateType) {
				case 0:
					ExperienceDAO expDAO = new ExperienceDAO();
					Experience exp = expDAO.getExperience(candidateID);
					expDAO.updateExperience(exp, conn, scan);
					break;
				case 1:
					FresherDAO fresherDAO = new FresherDAO();
					Fresher fresher = fresherDAO.getFresher(candidateID);
					fresherDAO.updateFresher(fresher, conn, scan);
					break;
				case 2:
					InternDAO internDAO = new InternDAO();
					Intern intern = internDAO.getIntern(candidateID);
					internDAO.updateIntern(intern, conn, scan);
					break;
				default:
					break;
				}
			} else if (!dataModified.isEmpty() && !dataModified.equals(Integer.toString(candidateType))) {
				deleteCandidateType(rs.getInt("Candidate_Type"), candidateID, conn);
				rs.updateInt("Candidate_Type", Integer.parseInt(dataModified));
				rs.updateRow();
				switch (Integer.parseInt(dataModified)) {
				case 0:
					ExperienceDAO expDAO = new ExperienceDAO();
					Experience exp = new Experience();
					expDAO.importExperience(exp, scan);
					exp.setCandidateID(candidateID);
					expDAO.insertExperienceToDB(exp, conn);
					break;
				case 1:
					FresherDAO fresherDAO = new FresherDAO();
					Fresher fresher = new Fresher();
					fresherDAO.importFresher(fresher, scan);
					fresher.setCandidateID(candidateID);
					fresherDAO.insertFresherToDB(fresher, conn);
					break;
				case 2:
					InternDAO internDAO = new InternDAO();
					Intern intern = new Intern();
					internDAO.importIntern(intern, scan);
					intern.setCandidateID(candidateID);
					internDAO.insertInternToDB(intern, conn);
					break;
				}
			}
		} else {
			System.out.print("This Canddiate is not exist, Please enter other ");
			updateCandidate(conn, scan);
		}
	}

	public void deleteCandidateType(int candidateType, String candidateID, Connection conn) {
		String sql = null;
		try {
			switch (candidateType) {
			case 0:
				sql = "DELETE FROM EXPERIENCE WHERE CandidateID = " + candidateID;
				break;
			case 1:
				sql = "DELETE FROM FRESHER WHERE CandidateID = " + candidateID;
				break;
			case 2:
				sql = "DELETE FROM INTERN WHERE CandidateID = " + candidateID;
				break;
			default:
				break;
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String importPhone(Scanner scan) {
		System.out.print("Phone number: ");
		String phone = scan.nextLine();
		try {
			if (!phone.matches("[0-9]{10}")) {
				throw new ImportException("Input wrong phone number format! Please enter again");
			}		
		} catch (ImportException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			importPhone(scan);
		}
		return phone;

	}

}
