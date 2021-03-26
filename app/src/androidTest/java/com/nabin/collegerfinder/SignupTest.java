package com.nabin.collegerfinder;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SignupTest {
    @Rule
    public ActivityTestRule<Register_activity> testRule = new ActivityTestRule<>(Register_activity.class);

    private String FirstName = "nabin";
    private String LastName = "nabin";
    private String Username = "nabin12";
    private String Password = "nabin";
    private String ConfirmPassword = "nabin";

    @Test
    public void TestUI() throws Exception
    {
        onView(withId(R.id.etFirstName)).perform(typeText(FirstName));
        closeSoftKeyboard();

        onView(withId(R.id.etLastName)).perform(typeText(LastName));
        closeSoftKeyboard();

        onView(withId(R.id.etSignUpUsername)).perform(typeText(Username));
        closeSoftKeyboard();

        onView(withId(R.id.etSignUpPassword)).perform(typeText(Password));
        closeSoftKeyboard();

        onView(withId(R.id.etConfirmPassword)).perform(typeText(ConfirmPassword));
        closeSoftKeyboard();


        onView(withId(R.id.btnSignup)).perform(click());
    }
}
