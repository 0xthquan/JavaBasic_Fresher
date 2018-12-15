/*
@author QuanTH17
*/
package manageCandidate;


public class Experience extends Candidate {
	private int expInYear;
	private String proSkill;
	
	public Experience(int expInYear, String proSkill) {
		super();
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}


	public Experience() {
		// TODO Auto-generated constructor stub
	}


	public int getExpInYear() {
		return expInYear;
	}


	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}


	public String getProSkill() {
		return proSkill;
	}


	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}


	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Nam kinh nghiep: " + getExpInYear());
		System.out.println("Ky nang chuyen mom: " + getProSkill());
	}
	

}
