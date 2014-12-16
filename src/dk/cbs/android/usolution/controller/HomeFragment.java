package dk.cbs.android.usolution.controller;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Project;
import dk.cbs.android.usolution.model.ProjectDatabase;

public class HomeFragment extends ListFragment {
	private static final String TAG = "list item was clicked";
	private ArrayList<Project> mProjects;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.projects_title);
		mProjects = ProjectDatabase.get(getActivity()).getProjects();
		
		ProjectAdapter adapter = new ProjectAdapter(mProjects);
		setListAdapter(adapter);
	}
	
	public void onListItemClick(ListView l, View v, int position, long id) {
		Project p = ((ProjectAdapter)getListAdapter()).getItem(position);
		Log.d(TAG, p.getProjectName() + " was clicked");
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
						.inflate(R.layout.fragment_home, null);
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