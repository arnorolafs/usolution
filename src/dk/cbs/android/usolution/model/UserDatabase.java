package dk.cbs.android.usolution.model;

import java.util.ArrayList;
import java.util.UUID;


import android.content.Context;

public class UserDatabase {
	private static ArrayList<User> mUsers;
	
	private static UserDatabase sUserDatabase;
	private Context mAppContext;
	
	private UserDatabase(Context appContext) {
		mAppContext = appContext;
		mUsers = new ArrayList<User>();
		
		// make one user and set email/password
		User c = new User();
		c.setEmail("admin");
		c.setPassword("admin");
		// add a user to an array
		mUsers.add(c);
	}
	
	public static UserDatabase get(Context c) {
		if (getUserDatabase() == null) {
			setUserDatabase(new UserDatabase(c.getApplicationContext()));
		}
		return getUserDatabase();
	}
	
	public static void addUser(User user) {
		mUsers.add(user);
	}

	public ArrayList<User> getUsers() {
		return mUsers;
	}
	
	public User getUsers(UUID id) {
		for (User c : mUsers) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}

	public static UserDatabase getUserDatabase() {
		return sUserDatabase;
	}

	public static void setUserDatabase(UserDatabase userDatabase) {
		sUserDatabase = userDatabase;
	}
	
	public static boolean checkUser(User user) {
		for (int i = 0; i < mUsers.size(); i++) {
			if (user.getEmail().equals(mUsers.get(i).getEmail()) && user.getPassword().equals(mUsers.get(i).getPassword())) {
				return true;
			}
		}
		return false;
	}
}