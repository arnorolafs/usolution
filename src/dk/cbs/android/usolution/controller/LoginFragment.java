package dk.cbs.android.usolution.controller;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import dk.cbs.android.usolution.model.User;
import dk.cbs.android.usolution.model.UserDatabase;

public class LoginFragment extends Fragment {
	private static final String KEY_USER_ARRAY = "user array";

	private EditText mEmailField;
	private EditText mPasswordField;
	private Button mLoginButton;
	private TextView mNewAccount;
	
	private User mUser;
	private ArrayList<User> mUsers;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mUser = new User();
		mUsers = UserDatabase.get(getActivity()).getUsers();
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
				mUser.setEmail(c.toString());
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
				mUser.setPassword(c.toString());
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
		
		// Create new fragment and transaction					
		Fragment newFragment = new NewAccountFragment();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		
		// Replace whatever is in the fragment_container view with this fragment,
		// and add the transaction to the back stack
		transaction.replace(R.id.fragmentContainer, newFragment);
		transaction.addToBackStack(null);
						
		// Commit the transaction
		transaction.commit();
	}
	
	private void login() {
		if (UserDatabase.checkUser(mUser)) {
			// Start HomeActivity
			Intent i = new Intent(getActivity(), HomeActivity.class);
			startActivity(i);
		}
		else {
			Toast.makeText(getActivity().getApplicationContext(), R.string.incorrect_login_toast, Toast.LENGTH_SHORT).show();
		}
	}
}