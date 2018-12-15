/*
@author QuanTH17
*/
package manageCandidate;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import model.dao.CandidateDAO;
import model.dao.CertificatedDAO;
import model.dao.ExperienceDAO;
import model.dao.FresherDAO;
import model.dao.InternDAO;
import utils.SQLServerConnection;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		Scanner scan = new Scanner(System.in);
		Connection conn = SQLServerConnection.getSQLServerConnection();
		while (true) {
			boolean flagOption = true;
			System.out.println("=====Select option=====" + "\n1. Import new Candidate" + "\n2. Show all candidate"
					+ "\n3. Update candidate" + "\n4. Import certificated");
			int optionMenu = Integer.parseInt(scan.nextLine());
			System.out.println("----->>>You have selected option " + optionMenu);
			switch (optionMenu) {
			case 1:
				while (flagOption) {
					CandidateDAO candidateDAO = new CandidateDAO();
					Candidate candidate = candidateDAO.importCandidate(scan);
					candidateDAO.insertCandidateToDB(candidate, conn);
					if (candidate instanceof Experience) {
						Experience exp = (Experience) candidate;
						ExperienceDAO expDAO = new ExperienceDAO();
						expDAO.importExperience(exp, scan);
						expDAO.insertExperienceToDB(exp, conn);
					} else if (candidate instanceof Fresher) {
						Fresher fresher = (Fresher) candidate;
						FresherDAO fresherDAO = new FresherDAO();
						fresherDAO.importFresher(fresher, scan);
						fresherDAO.insertFresherToDB(fresher, conn);
					} else if (candidate instanceof Intern) {
						Intern intern = (Intern) candidate;
						InternDAO internDAO = new InternDAO();
						internDAO.importIntern(intern, scan);
						internDAO.insertInternToDB(intern, conn);
					}
					System.out.println("Do you want to import certificated for this candidate? (Y/N)");
					boolean flagCert = "Y".equalsIgnoreCase(scan.nextLine()) ? true : false;
					while (flagCert) {
						Certificate cert = new Certificate();
						CertificatedDAO certDAO = new CertificatedDAO();
						certDAO.importCert(cert, scan);
						certDAO.insertCertToDB(cert, candidate.getCandidateID(), conn);
						System.out.println("Do you want to import more certificated for this candidate? (Y/N)");
						flagCert = "Y".equalsIgnoreCase(scan.nextLine()) ? true : false;
					}
					Candidate.candidate_Count++;
					System.out.println("Do you want to import more candidate (Y/N)");
					flagOption = "Y".equalsIgnoreCase(scan.nextLine()) ? true : false;

				}
				System.out.println("You have imported " + Candidate.candidate_Count);
				Candidate.candidate_Count = 0;
				break;
			case 2:
				
				
				break;
			case 3:
				CandidateDAO candidateDAO = new CandidateDAO();
				candidateDAO.updateCandidate(conn, scan);
				break;
			case 4:
				break;
			default:
				break;
			}
		}

	}
}
