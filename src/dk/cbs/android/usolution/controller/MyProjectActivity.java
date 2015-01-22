package dk.cbs.android.usolution.controller;

import android.support.v4.app.Fragment;

public class MyProjectActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new MyProjectFragment();
	}

}
