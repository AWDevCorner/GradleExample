package it.androidworld.devcorner.simpletestapp.test;

import android.test.ActivityInstrumentationTestCase2;
import it.androidworld.devcorner.simpletestapp.app.MainActivity;
import it.androidworld.devcorner.simpletestapp.app.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class TestActivity extends ActivityInstrumentationTestCase2<MainActivity> {

    @SuppressWarnings( "deprecation" )
    public TestActivity() {
        super("it.androidworld.devcorner.simpletestapp.app", MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testFirstClick(){

        onView(withId(R.id.btnCambiaTesto))
                .perform(click());

        onView(withId(R.id.txtCaption))
                .check(matches(withText(R.string.hello_world_2)));

    }
}
