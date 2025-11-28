package com.example.a2lab;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void calculateWordCount_displaysCorrectResult() {
        onView(withId(R.id.txtInputText))
                .perform(replaceText("Hello world this is a test."), closeSoftKeyboard());
        onView(withId(R.id.spinnerMetricType)).perform(click());
        onView(withText("Zodziu skaicius")).perform(click());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("Zodziu skaicius: 6")));
    }

    @Test
    public void calculateSentenceCount_displaysCorrectResult() {
        onView(withId(R.id.txtInputText))
                .perform(replaceText("Hello world. Testing! Test passed?"), closeSoftKeyboard());
        onView(withId(R.id.spinnerMetricType)).perform(click());
        onView(withText("Sakiniu skaicius")).perform(click());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("Sakiniu skaicius: 3")));
    }

    @Test
    public void calculateSymbolCount_displaysCorrectResult() {
        onView(withId(R.id.txtInputText))
                .perform(replaceText("Hello, world."), closeSoftKeyboard());

        onView(withId(R.id.spinnerMetricType)).perform(click());
        onView(withText("Rasybos zenklu skaicius")).perform(click());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("Rasybos zenklu skaicius: 3")));
    }

    @Test
    public void calculateNumberCount_displaysCorrectResult() {
        onView(withId(R.id.txtInputText))
                .perform(replaceText("2 tests and 63 apps"), closeSoftKeyboard());

        onView(withId(R.id.spinnerMetricType)).perform(click());
        onView(withText("Skaiciu skaicius ( :D )")).perform(click());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("Skaiciu skaicius ( :D ): 2")));
    }

    @Test
    public void longText_doesNotCrash() {
        String longText = new String(new char[1000]).replace("\0", "word ");

        onView(withId(R.id.txtInputText))
                .perform(replaceText(longText), closeSoftKeyboard());

        onView(withId(R.id.spinnerMetricType)).perform(click());
        onView(withText("Zodziu skaicius")).perform(click());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText("Zodziu skaicius: 1000")));
    }


    @Test
    public void spacesOnly_keepsPlaceholder() {
        onView(withId(R.id.txtInputText))
                .perform(replaceText("            "), closeSoftKeyboard());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText(R.string.result_placeholder)));
    }


    @Test
    public void emptyInput_keepsPlaceholderText() {
        onView(withId(R.id.btnCalculate)).perform(click());
        onView(withId(R.id.txtResult))
                .check(matches(withText(R.string.result_placeholder)));
    }
}
