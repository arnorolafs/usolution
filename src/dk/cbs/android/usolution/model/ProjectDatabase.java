package dk.cbs.android.usolution.model;

import java.util.ArrayList;
import java.util.UUID;


import android.content.Context;

public class ProjectDatabase {
	private static ArrayList<Project> mProjects;
	
	private static ProjectDatabase sProjectDatabase;
	private Context mAppContext;
	
	private ProjectDatabase(Context appContext) {
		mAppContext = appContext;
		mProjects = new ArrayList<Project>();
		
		// create a test project
		Project test = new Project();
		
		// set pre-defined parameters
		test.setBusinessName("Temp-Team A/S");
		test.setProjectName("Technological Infrastructure");
		test.setProjectDescription
		("We are dissatisfied with what we are getting out of our current technological " +
		 "setup and are therefore contemplating changing platforms. Before we do so, " +
		 "we are extremely interested in having our technological infrastructure analyzed " +
		 "from an outside source. Main focus should first and foremost be on improving profitability. " +
		 "In case that this analysis proves that the best/only course of action is to make change, " +
		 "we would appreciate it if the report had recommendation for different it-solutions.");
		
		// add user to Database
		mProjects.add(test);
	}
	
	public static ProjectDatabase get(Context c) {
		if (getProjectDatabase() == null) {
			setProjectDatabase(new ProjectDatabase(c.getApplicationContext()));
		}
		return getProjectDatabase();
	}
	
	public static void addProject(Project project) {
		mProjects.add(project);
	}

	public ArrayList<Project> getProjects() {
		return mProjects;
	}
	
	public Project getProject(UUID id) {
		for (Project c : mProjects) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}

	public static ProjectDatabase getProjectDatabase() {
		return sProjectDatabase;
	}

	public static void setProjectDatabase(ProjectDatabase projectDatabase) {
		sProjectDatabase = projectDatabase;
	}
}