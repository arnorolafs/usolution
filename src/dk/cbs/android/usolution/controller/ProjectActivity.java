package dk.cbs.android.usolution.controller;

import java.util.UUID;

import android.support.v4.app.Fragment;

public class ProjectActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// sets a universally unique identifier equal to a particular Intent
    	UUID projectId = (UUID)getIntent().getSerializableExtra(ProjectFragment.EXTRA_PROJECT_ID);
    	
    	// returns a new ProjectFragment instance corresponding to a particular projectId/Intent
    	return ProjectFragment.newInstance(projectId);
	}
}
