package com.sanath.builditbigger;

import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentationTest {

    @Rule
    public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testJokeFetchingAsyncTask() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        final String[] actual = new String[1];
        final JokeFetchingTask jokeFetchingTask = new JokeFetchingTask(activityTestRule.getActivity()) {
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                actual[0] = result;
                signal.countDown();
            }
        };

        uiThreadTestRule.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                jokeFetchingTask.execute();
            }
        });

        signal.await(30, TimeUnit.SECONDS);

        assertNotNull(actual[0]);
        assertTrue(actual[0].length() > 0);
    }
}