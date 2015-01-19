package dk.cbs.android.usolution.model;

import java.util.ArrayList;
import java.util.UUID;

public class Project {
	private UUID mId;
	
	private String mProjectName;
	private String mBusinessName;
	private String mProjectDescription;
	private String mLogo;
	
	private ArrayList<Student> mApplicants;
	
	public Project() {
		mId = UUID.randomUUID();
	}
	
	public UUID getId() {
		return mId;
	}
	
	public String getProjectName() {
		return mProjectName;
	}
	
	public void setProjectName(String projectName) {
		mProjectName = projectName;
	}
	
	public String getBusinessName() {
		return mBusinessName;
	}
	
	public void setBusinessName(String businessName) {
		mBusinessName = businessName;
	}
	
	public String getProjectDescription() {
		return mProjectDescription;
	}
	
	public void setProjectDescription(String projectDescription) {
		mProjectDescription = projectDescription;
	}
	
	public String getBusinessLogo() {
		return mLogo;
	}
	
	public void setBusinessLogo(String logo) {
		mLogo = logo;
	}
	
	public ArrayList<Student> getApplicants() {
		return mApplicants;
	}
	
	public void addApplicant(Student user) {
		mApplicants.add(user);
	}
}