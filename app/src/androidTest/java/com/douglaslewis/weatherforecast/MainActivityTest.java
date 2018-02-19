package com.douglaslewis.weatherforecast;


import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.douglaslewis.weatherforecast.Views.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {

	@Rule
	public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<> (MainActivity.class);

	public MainActivityTest () {
//		super(MainActivity.class);
	}


	@Test
	public void testStart () {
		onView (withId (R.id.day_card_fragment)).perform (click ());
		onView (withId (R.id.day_card_fragment)).check (matches (withEffectiveVisibility (ViewMatchers.Visibility.VISIBLE)));

	}

	@Test
	public void pullRefreshTest () {
		onView (withId (R.id.day_card_fragment)).perform (ViewActions.swipeDown ());
		onView (withId (R.id.week_cards_fragment)).check (matches (withEffectiveVisibility (ViewMatchers.Visibility.VISIBLE)));

	}

	@Test
	public void testFling () {
		onView (withId (R.id.week_cards_fragment)).perform (ViewActions.swipeRight ());
		onView (withId (R.id.week_cards_fragment)).check (matches (withEffectiveVisibility (ViewMatchers.Visibility.VISIBLE)));

	}
}
