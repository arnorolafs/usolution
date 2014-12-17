package dk.cbs.android.usolution.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

// CrimeActivity class that extends the custom class SingleFrameActivity
public class LoginActivity extends SingleFragmentActivity {
	
	// creates a fragment
	@Override
    protected Fragment createFragment() {
    	return new LoginFragment();
    }
}