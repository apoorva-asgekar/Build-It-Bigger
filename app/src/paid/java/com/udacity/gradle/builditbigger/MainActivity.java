package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.displayjoke.ShowJokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity
        implements EndpointsAsyncTask.EndpointsTaskListener {

    private TextView mJokeInstructions;
    private Button mGetJokeButton;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJokeInstructions = (TextView) findViewById(R.id.instructions_text_view);
        mGetJokeButton = (Button) findViewById(R.id.get_joke_button);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showProgress() {
        mJokeInstructions.setVisibility(View.INVISIBLE);
        mGetJokeButton.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        mJokeInstructions.setVisibility(View.VISIBLE);
        mGetJokeButton.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    public void tellJoke(View view) {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(this);
        task.execute();

        showProgress();
    }

    @Override
    public void onComplete(String joke) {
        Log.d("EndpointsAsyncTask", "joke is: " + joke);
        Intent displayJokeActivityIntent = new Intent(this, ShowJokeActivity.class);
        Bundle extras = new Bundle();
        extras.putString("joke", joke);
        displayJokeActivityIntent.putExtras(extras);

        hideProgress();
        startActivity(displayJokeActivityIntent);
    }
}
