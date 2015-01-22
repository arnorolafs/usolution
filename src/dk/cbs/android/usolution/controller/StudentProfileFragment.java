package dk.cbs.android.usolution.controller;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Student;
import dk.cbs.android.usolution.model.UserDatabase;

public class StudentProfileFragment extends Fragment {
	
	private TextView mFirstName;
	
	private ArrayList<Student> mStudents;
	private Student mStudent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UserDatabase userDatabase = new UserDatabase(getActivity().getApplicationContext());
		mStudents = userDatabase.get(getActivity()).getStudents();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_view_student_profile, parent, false);
		
		mFirstName = (TextView)v.findViewById(R.id.student_firstName);
		mFirstName.setText(mStudent.getFirstName().toString());
		
		return v;
	}
}