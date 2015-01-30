package dk.cbs.android.usolution.controller;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Project;
import dk.cbs.android.usolution.model.ProjectDatabase;

public class ProjectListFragment extends ListFragment {
	private ArrayList<Project> mProjects;
	
	public static String PACKAGE_NAME;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getActivity().setTitle(R.string.project_title);
		mProjects = ProjectDatabase.get(getActivity()).getProjects();
		
		ProjectAdapter adapter = new ProjectAdapter(mProjects);
		setListAdapter(adapter);
		
		PACKAGE_NAME = getActivity().getApplicationContext().getPackageName();
	}
	
	public void onListItemClick(ListView l, View v, int position, long id) {
		// get the project from the adapter
		Project p = ((ProjectAdapter)getListAdapter()).getItem(position);
		
		// start specific ProjectActivity and shows the clocked-on item
		Intent i = new Intent(getActivity(), ProjectActivity.class);
		i.putExtra(ProjectFragment.EXTRA_PROJECT_ID, p.getId());
		startActivity(i);
	}
	
	private class ProjectAdapter extends ArrayAdapter<Project> {
		
		public ProjectAdapter(ArrayList<Project> projects) {
			super(getActivity(), 0, projects);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// if you weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_project_list, null);
			}
			
			// configure the view for this project
			Project p = getItem(position);
			
			TextView titleTextView =
					(TextView)convertView.findViewById(R.id.project_list_item_titleTextView);
			titleTextView.setText(p.getProjectName());
			
			TextView businessNameTextView =
					(TextView)convertView.findViewById(R.id.project_list_item_businessNameTextView);
			businessNameTextView.setText(p.getBusinessName());
			
			return convertView;
		}
	}
}