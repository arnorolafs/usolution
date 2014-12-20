package dk.cbs.android.usolution.controller;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import dk.cbs.android.usolution.BuildConfig;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Project;
import dk.cbs.android.usolution.model.ProjectDatabase;

public class HomeFragment extends ListFragment {
	private ArrayList<Project> mProjects;
	
	public static String PACKAGE_NAME;
	
	private ImageView mBusinessLogo;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.project_title);
		mProjects = ProjectDatabase.get(getActivity()).getProjects();
		
		ProjectAdapter adapter = new ProjectAdapter(mProjects);
		setListAdapter(adapter);
		
		PACKAGE_NAME = getActivity().getApplicationContext().getPackageName();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		((ProjectAdapter)getListAdapter()).notifyDataSetChanged();
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
			
			
			String uri = "@drawable/temp_team";
			int imageResource = getResources().getIdentifier(uri, null, PACKAGE_NAME);

			mBusinessLogo = (ImageView)convertView.findViewById(R.id.project_list_item_businessLogoImageView);
			Drawable res = getResources().getDrawable(imageResource);
			mBusinessLogo.setImageDrawable(res);
			
			return convertView;
		}
	}
}