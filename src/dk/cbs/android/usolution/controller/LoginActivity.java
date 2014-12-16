package dk.cbs.android.usolution.controller;

import android.support.v4.app.Fragment;

// CrimeActivity class that extends the custom class SingleFrameActivity
public class LoginActivity extends SingleFragmentActivity {

	// creates a fragment
	@Override
    protected Fragment createFragment() {
    	return new LoginFragment();
    }    
}