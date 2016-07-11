package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.example.displayjoke.JokeDisplayActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnJokeReceivedListener {
    private ProgressBar mSpinner;
    private String mJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);



        mSpinner = (ProgressBar) root.findViewById(R.id.progressBar);
        Button getJokeButton=(Button)root.findViewById(R.id.getjoke);

        getJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJoke();
            }
        });


        return root;
    }



    public void fetchJoke(){
        mSpinner.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(this);
    }

    private void startJokeActivity() {
        Intent intent = new Intent(getActivity(), JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.INTENT_JOKE, mJoke);
        startActivity(intent);
    }


    @Override
    public void onReceived(String joke) {
        mSpinner.setVisibility(View.INVISIBLE);
        mJoke = joke;
        Log.d(JokeDisplayActivity.INTENT_JOKE,joke);
            startJokeActivity();
    }
}
