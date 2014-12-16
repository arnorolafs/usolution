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

		for (int i = 0; i < 100; i++) {
			Project p = new Project();
			
			p.setProjectName("Company #" + i);
			// add user to Database
			mProjects.add(p);
		}
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
	
	public Project getProjects(UUID id) {
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