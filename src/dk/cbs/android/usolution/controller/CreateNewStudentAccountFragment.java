package dk.cbs.android.usolution.controller;

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
import android.widget.Toast;
import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Business;
import dk.cbs.android.usolution.model.Student;
import dk.cbs.android.usolution.model.UserDatabase;

public class CreateNewStudentAccountFragment extends Fragment {
	
	private EditText mFirstName;
	private EditText mLastName;
	private EditText mEmail;
	private EditText mPassword;
	private EditText mLinkedInProfile;
	private Button mNewStudentAccount;
	
	private Student mUser;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mUser = new Student();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_create_student_new_account, parent, false);
		
		mFirstName = (EditText)v.findViewById(R.id.account_firstName);
		mFirstName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mFirstName.setHint(null);
			}
		});
		
		mFirstName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setFirstName(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mLastName = (EditText)v.findViewById(R.id.account_lastName);
		mLastName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mLastName.setHint(null);
			}
		});
		
		mLastName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setLastName(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mEmail = (EditText)v.findViewById(R.id.account_email);
		mEmail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mEmail.setHint(null);
			}
		});
		
		mEmail.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setEmail(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mPassword = (EditText)v.findViewById(R.id.account_password);
		mPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mPassword.setHint(null);
			}
		});
		
		mPassword.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setPassword(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mLinkedInProfile = (EditText)v.findViewById(R.id.account_linkedInProfile);
		mLinkedInProfile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mLinkedInProfile.setHint(null);
			}
		});
		
		mLinkedInProfile.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setLinkedInProfile(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		
		mNewStudentAccount = (Button)v.findViewById(R.id.account_newStudentAccount);
		mNewStudentAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!UserDatabase.checkStudentUser(mUser)) {
					UserDatabase.addStudent(mUser);
					Toast.makeText(getActivity().getApplicationContext(), 
						       R.string.new_account_created_toast,
						       Toast.LENGTH_SHORT).show();

					Toast.makeText(getActivity().getApplicationContext(), 
							       "Welcome " + mUser.getFullName(), 
							       Toast.LENGTH_SHORT).show();
					
					// Start HomeActivity
					Intent i = new Intent(getActivity(), StudentHomeActivity.class);
					startActivity(i);
				}
				else {
					Toast.makeText(getActivity().getApplicationContext(), 
								   R.string.account_email_already_registered_toast, 
								   Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		return v;
	}
}