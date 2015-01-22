package dk.cbs.android.usolution.model;

import android.provider.BaseColumns;

public class DbContract {
	// empty constructor to prevent instantiation
	public DbContract() {}
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	public static final String SQL_CREATE_ENTRIES =
					"CREATE TABLE " + Student.TABLE_NAME + " (" +
					Student._ID + " INTEGER PRIMARY KEY," +
				    Student.COLUMN_NAME_STUDENT_FIRSTNAME + TEXT_TYPE + COMMA_SEP +
				    Student.COLUMN_NAME_STUDENT_LASTNAME + TEXT_TYPE + COMMA_SEP +
					Student.COLUMN_NAME_LINKEDIN_PROFILE + TEXT_TYPE + COMMA_SEP +
					Student.COLUMN_NAME_STUDENT_EMAIL + TEXT_TYPE + COMMA_SEP +
					Student.COLUMN_NAME_STUDENT_PASSWORD + TEXT_TYPE + COMMA_SEP +
				
					"CREATE TABLE " + Business.TABLE_NAME + " (" +
					Business._ID + " INTEGER PRIMARY KEY," +
				    Business.COLUMN_NAME_BUSINESS_NAME + TEXT_TYPE + COMMA_SEP +
				    Business.COLUMN_NAME_CONTACTPERSON + TEXT_TYPE + COMMA_SEP +
					Business.COLUMN_NAME_BUSINESS_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
					Business.COLUMN_NAME_WEBSITE + TEXT_TYPE + COMMA_SEP +
					Business.COLUMN_NAME_BUSINESS_PASSWORD + TEXT_TYPE + COMMA_SEP +
					Business.COLUMN_NAME_BUSINESS_PASSWORD + TEXT_TYPE + COMMA_SEP +
			
					"CREATE TABLE " + Project.TABLE_NAME + " (" +
					Project._ID + " INTEGER PRIMARY KEY," +
				    Project.COLUMN_NAME_PROJECT_NAME + TEXT_TYPE + COMMA_SEP +
				    Project.COLUMN_NAME_BUSINESS_NAME + TEXT_TYPE + COMMA_SEP +
				    Project.COLUMN_NAME_PROJECT_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
				    Project.COLUMN_NAME_BUSINESS_LOGO + TEXT_TYPE + COMMA_SEP +
				    " )";
	
	public static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + Student.TABLE_NAME +
			"DROP TABLE IF EXISTS " + Business.TABLE_NAME +
			"DROP TABLE IF EXISTS " + Project.TABLE_NAME;
	

	/* Inner class that defines table contents */
	public static abstract class Student implements BaseColumns {
		public static final String TABLE_NAME = "student";
		public static final String COLUMN_NAME_STUDENT_FIRSTNAME = "firstname";
		public static final String COLUMN_NAME_STUDENT_LASTNAME = "lastname";
		public static final String COLUMN_NAME_LINKEDIN_PROFILE = "linkedinprofile";
		public static final String COLUMN_NAME_STUDENT_EMAIL= "email";
		public static final String COLUMN_NAME_STUDENT_PASSWORD = "password";
	}
	
	public static abstract class Business implements BaseColumns {
		public static final String TABLE_NAME = "business";
		public static final String COLUMN_NAME_BUSINESS_NAME = "businessname";
		public static final String COLUMN_NAME_CONTACTPERSON = "contactperson";
		public static final String COLUMN_NAME_BUSINESS_DESCRIPTION = "businessdescription";
		public static final String COLUMN_NAME_WEBSITE = "website";
		public static final String COLUMN_NAME_BUSINESS_EMAIL= "email";
		public static final String COLUMN_NAME_BUSINESS_PASSWORD = "password";
	}
	
	public static abstract class Project implements BaseColumns {
		public static final String TABLE_NAME = "project";
		public static final String COLUMN_NAME_PROJECT_NAME = "projectname";
		public static final String COLUMN_NAME_BUSINESS_NAME = "businessname";
		public static final String COLUMN_NAME_PROJECT_DESCRIPTION = "projectdescription";
		public static final String COLUMN_NAME_BUSINESS_LOGO = "businesslogo";
	}
}
