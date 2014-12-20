package dk.cbs.android.usolution.controller;

import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Project;
import dk.cbs.android.usolution.model.ProjectDatabase;
import dk.cbs.android.usolution.model.UserDatabase;

public class ProjectFragment extends Fragment {
	// keys
	public static final String EXTRA_PROJECT_ID =
			"dk.cbs.android.usolution.controller.project_id";
	
	private EditText mProjectTitleField;
	private EditText mProjectDescriptionField;
	private Button mApplyButton;
	private Project mProject;
	
	public static ProjectFragment newInstance(UUID projectId) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_PROJECT_ID, projectId);
		
		ProjectFragment fragment = new ProjectFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID projectId = (UUID)getArguments().getSerializable(EXTRA_PROJECT_ID);
		
		mProject = ProjectDatabase.get(getActivity()).getProject(projectId);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_project, parent, false);
		
		mProjectTitleField = (EditText)v.findViewById(R.id.project_titleEditText);
		mProjectTitleField.setText(mProject.getProjectName());
		
		mProjectDescriptionField = (EditText)v.findViewById(R.id.project_descriptionEditText);
		mProjectDescriptionField.setText(mProject.getProjectDescription());
		
		mApplyButton = (Button)v.findViewById(R.id.project_applyButton);
		mApplyButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Start ApplyForProjectActivity
				Intent i = new Intent(getActivity(), ApplyForProjectActivity.class);
				startActivity(i);
			}
		});
		
		return v;
	}
}