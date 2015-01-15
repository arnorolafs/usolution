package dk.cbs.android.usolution.model;

import java.util.ArrayList;
import java.util.UUID;


import android.content.Context;

public class UserDatabase {
	private static ArrayList<Student> mUsers;
	
	private static UserDatabase sUserDatabase;
	private Context mAppContext;
	
	private UserDatabase(Context appContext) {
		mAppContext = appContext;
		mUsers = new ArrayList<Student>();
		
		// make one user and set email/password
		Student c = new Student();
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
	
	public static void addUser(Student user) {
		mUsers.add(user);
	}

	public ArrayList<Student> getUsers() {
		return mUsers;
	}
	
	public Student getUsers(UUID id) {
		for (Student c : mUsers) {
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
	
	public static boolean checkUser(Student user) {
		for (int i = 0; i < mUsers.size(); i++) {
			if (user.getEmail().equals(mUsers.get(i).getEmail()) && user.getPassword().equals(mUsers.get(i).getPassword())) {
				return true;
			}
		}
		return false;
	}
}