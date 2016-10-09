package com.sanath.joke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String INTENT_ARGS_JOKE = "joke";
    private TextView mTextViewJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        mTextViewJoke = (TextView) findViewById(R.id.textViewJoke);

        String joke = getIntent().getStringExtra(INTENT_ARGS_JOKE);
        if (joke != null) {
            mTextViewJoke.setText(joke);
        }
    }
}
