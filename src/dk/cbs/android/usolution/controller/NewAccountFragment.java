package dk.cbs.android.usolution.controller;

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
import dk.cbs.android.usolution.model.User;
import dk.cbs.android.usolution.model.UserDatabase;

public class NewAccountFragment extends Fragment {
	
	private EditText mAccountFirstName;
	private EditText mAccountLastName;
	private EditText mAccountEmail;
	private EditText mAccountPassword;
	private Button mAccountNewAccount;
	
	private User mUser;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mUser = new User();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_new_account, parent, false);
		
		mAccountFirstName = (EditText)v.findViewById(R.id.account_firstName);
		mAccountFirstName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mAccountFirstName.setHint(null);
			}
		});
		
		mAccountFirstName.addTextChangedListener(new TextWatcher() {
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
		
		mAccountLastName = (EditText)v.findViewById(R.id.account_lastName);
		mAccountLastName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mAccountLastName.setHint(null);
			}
		});
		
		mAccountLastName.addTextChangedListener(new TextWatcher() {
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
		
		mAccountEmail = (EditText)v.findViewById(R.id.account_email);
		mAccountEmail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mAccountEmail.setHint(null);
			}
		});
		
		mAccountEmail.addTextChangedListener(new TextWatcher() {
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
		
		mAccountPassword = (EditText)v.findViewById(R.id.account_password);
		mAccountPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mAccountPassword.setHint(null);
			}
		});
		
		mAccountPassword.addTextChangedListener(new TextWatcher() {
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
		
		mAccountNewAccount = (Button)v.findViewById(R.id.account_newAccount);
		mAccountNewAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (UserDatabase.checkUser(mUser)) {
					UserDatabase.addUser(mUser);
					Toast.makeText(getActivity().getApplicationContext(), R.string.new_account_created_toast, Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		return v;
	}
}