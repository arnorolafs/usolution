package dk.cbs.android.usolution.controller;

import dk.cbs.android.usolution.R;
import dk.cbs.android.usolution.model.Business;
import dk.cbs.android.usolution.model.UserDatabase;
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

public class CreateNewBusinessAccountFragment extends Fragment {
	private Business mUser;
	
	private EditText mBusinessName;
	private EditText mContactPerson;
	private EditText mDescription;
	private EditText mWebsite;
	private EditText mEmail;
	private EditText mPassword;
	private Button mNewBusinessAccount;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mUser = new Business();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_create_business_new_account, parent, false);
		
		mBusinessName = (EditText)v.findViewById(R.id.account_businessName);
		mBusinessName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mBusinessName.setHint(null);
			}
		});
		
		mBusinessName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setName(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mContactPerson = (EditText)v.findViewById(R.id.account_businessContactPerson);
		mContactPerson.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mContactPerson.setHint(null);
			}
		});
		
		mContactPerson.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setContactPerson(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mDescription = (EditText)v.findViewById(R.id.account_businessDescription);
		mDescription.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mDescription.setHint(null);
			}
		});
		
		mDescription.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setDescription(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mWebsite = (EditText)v.findViewById(R.id.account_businessWebsite);
		mWebsite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mWebsite.setHint(null);
			}
		});
		
		mWebsite.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mUser.setWebsite(c.toString());
			}

			public void beforeTextChanged(CharSequence c, int start, int count, int after) {
				// action before the EditText field is changed
			}
			
			public void afterTextChanged(Editable c) {
				// action after the EditText field is changed
			}
		});
		
		mEmail = (EditText)v.findViewById(R.id.account_businessEmail);
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
		
		mPassword = (EditText)v.findViewById(R.id.account_businessPassword);
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
		
		mNewBusinessAccount = (Button)v.findViewById(R.id.account_newBusinessAccount);
		mNewBusinessAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!UserDatabase.checkForBusinessInformation(mUser)) {
					UserDatabase.addBusiness(mUser);
					Toast.makeText(getActivity().getApplicationContext(), 
						       R.string.new_account_created_toast,
						       Toast.LENGTH_SHORT).show();

					Toast.makeText(getActivity().getApplicationContext(), 
							       "Welcome " + mUser.getName(), 
							       Toast.LENGTH_SHORT).show();
					
					// Start HomeActivity
					Intent i = new Intent(getActivity(), BusinessHomeActivity.class);
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
