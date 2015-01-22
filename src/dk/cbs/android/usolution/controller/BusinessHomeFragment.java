package dk.cbs.android.usolution.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import dk.cbs.android.usolution.R;

public class BusinessHomeFragment extends Fragment {
	
	private Button mViewProjects;
	private Button mMyProject;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_business_home, parent, false);
		
		mViewProjects = (Button)v.findViewById(R.id.viewProjects);
		mViewProjects.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), ProjectListActivity.class);
				startActivity(i);
			}
		});
		
		mMyProject = (Button)v.findViewById(R.id.viewProjects);
		mMyProject.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), MyProjectActivity.class);
				startActivity(i);
			}
		});

		return v;
	}
}