/*
@author QuanTH17
*/
package manageCandidate;

import java.util.Date;


public class Fresher extends Candidate {
	private Date graduation_Date;
	private String graduation_Rank;
	private String education;
	
	
	
	public Fresher() {
	}


	public Fresher(Date graduation_Date, String graduation_Rank, String education) {
		super();
		this.graduation_Date = graduation_Date;
		this.graduation_Rank = graduation_Rank;
		this.education = education;
	}


	public Date getGraduation_Date() {
		return graduation_Date;
	}


	public void setGraduation_Date(Date graduation_Date) {
		this.graduation_Date = graduation_Date;
	}


	public String getGraduation_Rank() {
		return graduation_Rank;
	}


	public void setGraduation_Rank(String graduation_Rank) {
		this.graduation_Rank = graduation_Rank;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Thoi gian tot nghiep: " + getGraduation_Date().toString());
		System.out.println("Xep loai tot nghiep: " + getGraduation_Rank());
		System.out.println("Truong to nghiep: " + getEducation());
	}

	
}
