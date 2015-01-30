package dk.cbs.android.usolution.model;

import java.util.ArrayList;
import java.util.UUID;

import dk.cbs.android.usolution.R;


import android.content.Context;
import android.widget.Toast;

public class UserDatabase {
	private static ArrayList<Student> mStudents;
	private static ArrayList<Business> mBusinesses;
	
	private static UserDatabase sUserDatabase;
	private Context mAppContext;
	
	public UserDatabase(Context appContext) {
		mAppContext = appContext;
		mStudents = new ArrayList<Student>();
		mBusinesses = new ArrayList<Business>();
		
		// make one user and set email/password
		Student c = new Student();
		c.setFirstName("student");
		c.setLastName("user");
		c.setEmail("student");
		c.setPassword("student");
		// add a user to an array
		mStudents.add(c);
		
		// make one user and set email/password
		Business b = new Business();
		b.setName("business name");
		b.setContactPerson("business contact person");
		b.setEmail("business");
		b.setPassword("business");
		// add a user to an array
		mBusinesses.add(b);
	}
	
	public static UserDatabase get(Context c) {
		if (getUserDatabase() == null) {
			setUserDatabase(new UserDatabase(c.getApplicationContext()));
		}
		return getUserDatabase();
	}
	
	public static UserDatabase getUserDatabase() {
		return sUserDatabase;
	}

	public static void setUserDatabase(UserDatabase userDatabase) {
		sUserDatabase = userDatabase;
	}
	
	public static void addStudent(Student user) {
		mStudents.add(user);
	}

	public ArrayList<Student> getStudents() {
		return mStudents;
	}
	
	public static Student getStudent(UUID id) {
		for (Student c : mStudents) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}
	
	public static void addBusiness(Business user) {
		mBusinesses.add(user);
	}

	public ArrayList<Business> getBusinesses() {
		return mBusinesses;
	}
	
	public Business getBusiness(UUID id) {
		for (Business b : mBusinesses) {
			if (b.getId().equals(id))
				return b;
		}
		return null;
	}
	
	public static int checkStudentLogin(Student studentUser) {
		for (int i = 0; i < mStudents.size(); i++) {
			if (studentUser.getEmail().equals(mStudents.get(i).getEmail()) && 
				studentUser.getPassword().equals(mStudents.get(i).getPassword())) {
				return i;
			}
		}
		return -1;
	}
	
	public static int checkBusinessLogin(Business businessUser) {
		for (int i = 0; i < mBusinesses.size(); i++) {
			if (businessUser.getEmail().equals(mBusinesses.get(i).getEmail()) && 
				businessUser.getPassword().equals(mBusinesses.get(i).getPassword())) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean checkForStudentInformation (Student studentUser) {
		for (int i = 0; i < mStudents.size(); i++) {
			if (studentUser.getEmail().equals(mStudents.get(i).getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkForBusinessInformation (Business businessUser) {
		for (int i = 0; i < mBusinesses.size(); i++) {
			if (businessUser.getEmail().equals(mBusinesses.get(i).getEmail())) {
				return true;
			}
		}
		return false;
	}
}