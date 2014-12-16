package dk.cbs.android.usolution.model;

import java.util.UUID;

public class Project {
	private UUID mId;
	
	private String mProjectName;
	private String mBusinessName;
	private String mLogo;
	
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
	
	public String getLogo() {
		return mLogo;
	}
	
	public void setLogo(String logo) {
		mLogo = logo;
	}
}