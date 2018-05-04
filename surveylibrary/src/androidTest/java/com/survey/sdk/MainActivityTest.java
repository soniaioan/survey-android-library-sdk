package com.survey.sdk;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.survey.sdk.ui.view.MainActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;



/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends SurveyUnitTest {
    protected SurveyTestWrapper survey;

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class, true, false);



    @Before
    public void setUp() throws Exception {
        super.setUp();
        startActivity();
    }

    @Test
    public void testTopAndBottomTitles() {
//        onWebView().check(webMatches(getCurrentUrl(), containsString("pollfish.com")));
        onView(withId(R.id.textViewTop)).check(matches(withText("title1")));
        onView(withId(R.id.textViewBottom)).check(matches(withText("title2")));

    }

    @Test
    public void testCloseButton() {
        onView(withId(R.id.imageButton))
                .check(matches(isDisplayed()))
                .perform(click());
        assertTrue(activityRule.getActivity().isFinishing());
    }

    private MainActivity startActivity() {
        return activityRule.launchActivity(null);
    }
}