package com.example.displayjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    public static final String INTENT_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView mjokeTextView = (TextView)findViewById(R.id.jokeTextview);
        String joke = getIntent().getStringExtra(INTENT_JOKE);
        if(joke!=null){
            mjokeTextView.setText(joke);
            Log.d(INTENT_JOKE,joke);
        }
    }
}
