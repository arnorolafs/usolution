package dk.cbs.android.usolution.controller;

import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Student;
import dk.cbs.android.usolution.model.UserDatabase;

public class StudentHomeFragment extends Fragment {
	private Button mViewProjects;
	private Button mViewProfile;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_student_home, parent, false);
		
		mViewProjects = (Button)v.findViewById(R.id.viewProjects);
		mViewProjects.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ProjectListActivity.class);
				startActivity(i);
			}
		});
		
		mViewProfile = (Button)v.findViewById(R.id.viewStudentProfile);
		mViewProfile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Starting intent for creating a new business user	
				Intent i = new Intent(getActivity(), StudentProfileActivity.class);
				startActivity(i);
			}
		});
		
		return v;
	}
}
