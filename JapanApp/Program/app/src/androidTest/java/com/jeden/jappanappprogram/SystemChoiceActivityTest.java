package com.jeden.jappanappprogram;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class SystemChoiceActivityTest {

    @Rule
    public ActivityTestRule<SystemChoiceActivity> myRule = new ActivityTestRule<SystemChoiceActivity>(SystemChoiceActivity.class);
    private SystemChoiceActivity mainActivity = null;


    @Before
    public void setUp() throws Exception {
        mainActivity = myRule.getActivity();


    }

    @Test
    public  void chechButtonIntentHiraganaDrawIt(){
        Intent intent = new Intent();
        intent.putExtra("mode","draw" );
        myRule.launchActivity(intent);

        assertNotNull(mainActivity.findViewById(R.id.btHiragana));
        onView(withId(R.id.btHiragana)).perform(click());
        Intent i = new Intent();
        myRule.launchActivity(i);
    }
    @Test
    public  void chechButtonIntentKatakanaDrawIt(){
        Intent intent = new Intent();
        intent.putExtra("mode","draw" );
        myRule.launchActivity(intent);

        assertNotNull(mainActivity.findViewById(R.id.btKatakana));
        onView(withId(R.id.btKatakana)).perform(click());
        Intent i = new Intent();
        myRule.launchActivity(i);
    }
    @Test
    public  void chechButtonIntentKanjiDrawIt(){
        Intent intent = new Intent();
        intent.putExtra("mode","draw" );
        myRule.launchActivity(intent);

        assertNotNull(mainActivity.findViewById(R.id.btKanji));
        onView(withId(R.id.btKanji)).perform(click());
        Intent i = new Intent();
        myRule.launchActivity(i);
    }
    @Test
    public  void chechButtonIntentHiraganaGuessIt(){
        Intent intent = new Intent();
        intent.putExtra("mode","guess" );
        myRule.launchActivity(intent);

        assertNotNull(mainActivity.findViewById(R.id.btHiragana));
        onView(withId(R.id.btHiragana)).perform(click());
        Intent i = new Intent();
        myRule.launchActivity(i);
    }
    @Test
    public  void chechButtonIntentKatakanaGuessIt(){
        Intent intent = new Intent();
        intent.putExtra("mode","guess" );
        myRule.launchActivity(intent);

        assertNotNull(mainActivity.findViewById(R.id.btKatakana));
        onView(withId(R.id.btKatakana)).perform(click());
        Intent i = new Intent();
        myRule.launchActivity(i);
    }
    @Test
    public  void chechButtonIntentKanjiGuessIt(){
        Intent intent = new Intent();
        intent.putExtra("mode","guess" );
        myRule.launchActivity(intent);

        assertNotNull(mainActivity.findViewById(R.id.btKanji));
        onView(withId(R.id.btKanji)).perform(click());
        Intent i = new Intent();
        myRule.launchActivity(i);
    }

}