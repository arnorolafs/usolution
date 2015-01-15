package dk.cbs.android.usolution.controller;

import android.support.v4.app.Fragment;

public class CreateNewBusinessAccountActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new CreateNewBusinessAccountFragment();
	}

}
