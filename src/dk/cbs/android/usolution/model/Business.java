package dk.cbs.android.usolution.model;

import java.util.UUID;

public class Business {
	private UUID mId;
	
	private String mName;
	private String mContactPerson;
	private String mDescription;
	private String mWebsite;
	private String mEmail;
	private String mPassword;
	
	public Business() {
		setId(UUID.randomUUID());
	}

	public UUID getId() {
		return mId;
	}

	public void setId(UUID id) {
		mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public String getContactPerson() {
		return mContactPerson;
	}

	public void setContactPerson(String contactPerson) {
		mContactPerson = contactPerson;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String description) {
		mDescription = description;
	}

	public String getWebsite() {
		return mWebsite;
	}

	public void setWebsite(String website) {
		mWebsite = website;
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
	
	
}
