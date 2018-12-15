/*
@author QuanTH17
*/
package manageCandidate;

import java.util.Date;


public abstract class Candidate {
	private String candidateID;
	private String fullName;
	private Date birthday;
	private String phone;
	private String email;
	private int candidate_Type;
	public static int candidate_Count = 0;

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDay() {
		return birthday;
	}

	public void setBirthDay(Date birthDay) {
		this.birthday = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCandidate_Type() {
		return candidate_Type;
	}

	public void setCandidate_Type(int candidate_Type) {
		this.candidate_Type = candidate_Type;
	}

	public void showInfo() {
		System.out.println("THONG TIN UNG VIEN");
		System.out.print("Candidate ID: " + getCandidateID());
		System.out.println("FullName: " + getFullName());
		System.out.println("BirthDay: " + getBirthDay());
		System.out.println("Email: " + getEmail());
		String candidateType = getCandidate_Type() == 0 ? "Experience"
				: (getCandidate_Type() == 1 ? "Fresher" : "Intern");
		System.out.println("Candidate type: " + candidateType);
	}

}
