package dk.cbs.android.usolution.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import dk.cbs.android.usolution.R;

public class StudentOrBusinessFragment extends Fragment {
	private Button mBusinessAccount;
	private Button mStudentAccount;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_choose_account_type, parent, false);
		
		mBusinessAccount = (Button)v.findViewById(R.id.businessAccount);
		mBusinessAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), CreateNewBusinessAccountActivity.class);
				startActivity(i);
			}
		});
		
		mStudentAccount = (Button)v.findViewById(R.id.studentAccount);
		mStudentAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Starting intent for creating a new business user	
				Intent i = new Intent(getActivity(), CreateNewStudentAccountActivity.class);
				startActivity(i);
			}
		});
		
		return v;
	}
}
