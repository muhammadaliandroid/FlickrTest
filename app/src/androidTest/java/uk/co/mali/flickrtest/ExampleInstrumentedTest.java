package uk.co.mali.flickrtest;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import uk.co.mali.flickrtest.view.activity.FlickrListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<FlickrListActivity> mActivityTestRule = new ActivityTestRule<>(FlickrListActivity.class);

    @Test
    public void testEditText() throws Exception{
    onView(withId(R.id.et_Search)).perform(typeText("Spain"));
    }


    @Test
    public void testClickButton() throws Exception{
        onView(withId(R.id.et_Search)).perform(typeText("Spain"));
        onView(withId(R.id.btn_Search)).perform(click());
        onView(withId(R.id.rv_ListFlickrImages)).perform(RecyclerViewActions.scrollToPosition(1));
    }

    @Test
    public void testClickRecyclerView() throws Exception{
        onView(withId(R.id.et_Search)).perform(typeText("Spain"));
        onView(withId(R.id.btn_Search)).perform(click());
        onView(withId(R.id.rv_ListFlickrImages)).perform(RecyclerViewActions.scrollToPosition(3)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
    //    onView(withId(R.id.rv_ListFlickrImages)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
    }

}
