package com.example.android.displayjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    private TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        mJokeTextView = (TextView) findViewById(R.id.tv_joke_text);

        if(getIntent().hasExtra("joke")) {
            Bundle jokeBundle = getIntent().getExtras();
            String joke = jokeBundle.getString("joke");
            mJokeTextView.setText(joke);
        } else {
            mJokeTextView.setText(R.string.not_found);
        }
    }
}
