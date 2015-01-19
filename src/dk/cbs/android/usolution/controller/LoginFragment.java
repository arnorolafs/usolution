package dk.cbs.android.usolution.controller;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Business;
import dk.cbs.android.usolution.model.Student;
import dk.cbs.android.usolution.model.UserDatabase;

public class LoginFragment extends Fragment {
	private static final String KEY_USER_ARRAY = "user array";

	private EditText mEmailField;
	private EditText mPasswordField;
	private Button mLoginButton;
	private TextView mNewAccount;
	
	private Student mStudent;
	private ArrayList<Student> mStudents;
	
	private Business mBusiness;
	private ArrayList<Business> mBusinesses;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mStudent = new Student();
		mStudents = UserDatabase.get(getActivity()).getStudents();
		
		mBusiness = new Business();
		mBusinesses = UserDatabase.get(getActivity()).getBusinesses();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_login, parent, false);
		
		mEmailField = (EditText)v.findViewById(R.id.email_field);
		mEmailField.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mEmailField.setText(null);
			}
		});
		
		mEmailField.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mStudent.setEmail(c.toString());
				mBusiness.setEmail(c.toString());
			}
				
			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mPasswordField = (EditText)v.findViewById(R.id.password_field);
		mPasswordField.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPasswordField.setText(null);
			}
		});
		
		mPasswordField.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mStudent.setPassword(c.toString());
				mBusiness.setPassword(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
        mLoginButton = (Button)v.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				login();	
			}
		});
        
        mNewAccount = (TextView)v.findViewById(R.id.new_account);
        mNewAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				newAccount();
			}
		});
        
		
		return v;
	}
	
	private void newAccount() {
		Intent i = new Intent(getActivity(), StudentOrBusinessActivity.class);
		startActivity(i);
	}
	
	private void login() {
		if (UserDatabase.checkStudentUser(mStudent)) {
			// Start HomeActivity
			Intent i = new Intent(getActivity(), StudentHomeActivity.class);
			startActivity(i);
		}
		else if (UserDatabase.checkBusinessUser(mBusiness)) {
			// Start HomeActivity
			Intent i = new Intent(getActivity(), BusinessHomeActivity.class);
			startActivity(i);
		}
		else {
			Toast.makeText(getActivity().getApplicationContext(), R.string.incorrect_login_toast, Toast.LENGTH_SHORT).show();
		}
	}
}