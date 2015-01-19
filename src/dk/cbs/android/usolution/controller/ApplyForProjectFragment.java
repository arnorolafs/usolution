package dk.cbs.android.usolution.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Project;

public class ApplyForProjectFragment extends Fragment {
	private Project mProject;
	
	private Button mApplyButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mProject = new Project();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_apply_for_project, parent, false);
		
		mApplyButton = (Button)v.findViewById(R.id.applyForProjectButton);
        mApplyButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					
			}
		});
		
		return v;
	}
}