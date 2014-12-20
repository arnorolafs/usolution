package dk.cbs.android.usolution.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Project;

public class ApplyForProjectFragment extends Fragment {
	private Project mProject;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mProject = new Project();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_apply_for_project, parent, false);
		return v;
	}
}