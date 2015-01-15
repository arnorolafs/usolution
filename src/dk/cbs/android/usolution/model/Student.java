package dk.cbs.android.usolution.model;

import java.util.UUID;

public class Student {
	private UUID mId;
	
	private String mFirstName;
	private String mLastName;
	private String mEmail;
	private String mPassword;
	private String mLinkedInProfile;
	
	public Student() {
		mId = UUID.randomUUID();
	}
	
	public UUID getId() {
		return mId;
	}
	
	public String getFirstName() {
		return mFirstName;
	}
	
	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}
	
	public String getLastName() {
		return mLastName;
	}
	
	public void setLastName(String lastName) {
		mLastName = lastName;
	}
	
	public String getFullName() {
		return mFirstName + " " + mLastName;
	}
	
	public String getEmail() {
		return mEmail;
	}
	
	public void setEmail(String email) {
		mEmail = email;
	}
	
	public String getPassword() {
		return mPassword;
	}
	
	public void setPassword(String password) {
		mPassword = password;
	}

	public String getLinkedInProfile() {
		return mLinkedInProfile;
	}

	public void setLinkedInProfile(String linkedInProfile) {
		mLinkedInProfile = linkedInProfile;
	}

}