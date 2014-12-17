package dk.cbs.android.usolution.controller;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Project;
import dk.cbs.android.usolution.model.ProjectDatabase;

public class ProjectFragment extends Fragment {
	// keys
	public static final String EXTRA_PROJECT_ID =
			"dk.cbs.android.usolution.controller.project_id";
	
	private EditText mProjectTitleField;
	private EditText mProjectDescriptionField;
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
		
		return v;
	}
}