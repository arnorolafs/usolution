package dk.cbs.android.usolution.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;

import com.robotium.solo.Solo;

import dk.cbs.android.usolution.R;

public class LoginFragment extends ActivityInstrumentationTestCase2 {
	
	private Solo solo;
	
	public LoginFragment() {
		super("dk.cbs.android.usolution.test", LoginFragment.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testLoginFragment() {
		solo.clickOnButton("Login");
		ImageView picture = (ImageView) getActivity().findViewById(R.id.usolution_logo);
	}
	
	protected void tearDown() throws Exception {
		try {
			solo.finalize();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		super.tearDown();
	}
}
