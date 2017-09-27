package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.test.ApplicationTestCase;
import android.text.TextUtils;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by apoorva on 9/22/17.
 */
public class AsnycTaskTest extends ApplicationTestCase {

    String jokeFromTask = null;
    CountDownLatch signal = null;

    public AsnycTaskTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testEndpointsTask() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncTask.EndpointsTaskListener() {
            @Override
            public void onComplete(String joke) {
                jokeFromTask = joke;
                signal.countDown();
            }
        }).execute();
        signal.await(60, TimeUnit.SECONDS);

        assertFalse(TextUtils.isEmpty(jokeFromTask));
    }

}
