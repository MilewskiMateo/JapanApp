package com.jeden.jappanappprogram;

import android.content.Context;
import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class GuessItActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> myRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;


    @Before
    public void setUp() throws Exception {
        mainActivity = myRule.getActivity();
    }

    @Test
    public  void chechButtonIntentDraw(){
        assertNotNull(mainActivity.findViewById(R.id.btDraw));
        onView(withId(R.id.btDraw)).perform(click());

        Intent i = new Intent();
        myRule.launchActivity(i);
    }
    @Test
    public  void chechButtonIntentGuess(){
        assertNotNull(mainActivity.findViewById(R.id.btGuess));
        onView(withId(R.id.btGuess)).perform(click());

        Intent i = new Intent();
        myRule.launchActivity(i);
    }
    @Test
    public  void chechButtonIntentCredits(){
        assertNotNull(mainActivity.findViewById(R.id.btCredits));
        onView(withId(R.id.btCredits)).perform(click());

        Intent i = new Intent();
        myRule.launchActivity(i);
    }


}
