package com.austry.espressotest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    private static final String LOGIN = "login";
    private static final String WRONG_PASSWORD = "wrong_password";
    private static final String PASSWORD = "password";

    @Rule
    public IntentsTestRule<MainActivity> mIntentsRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.austry.espressotest", appContext.getPackageName());
    }

    @Test
    public void wrongLoginMessage() {
        tryWrongLogin();
        onView(withId(R.id.tvErrorText))
                .check(matches(withText("Wrong login/password")));
    }

    @Test
    public void changeScreenOnLogin() {
        login();
        intended(hasComponent(hasShortClassName(".InnerActivity")));
    }

    private void login() {
        typeAccountInfoAndClickLoginButton(LOGIN, PASSWORD);
    }


    private void tryWrongLogin() {
        typeAccountInfoAndClickLoginButton(LOGIN, WRONG_PASSWORD);
    }

    private void typeAccountInfoAndClickLoginButton(String login, String password) {
        onView(withId(R.id.etLogin))
                .perform(typeText(login));
        onView(withId(R.id.etPassword))
                .perform(typeText(password));

        onView(withId(R.id.btnLogin))
                .perform(click());
    }
}
