package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.android.courtcounter.R.id.team_a_score;
import static com.example.android.courtcounter.R.id.team_b_score;

public class MainActivity extends AppCompatActivity {
int scoreTeamA = 0;
int scoreTeamB = 0;
private static final String state_scoreTeamA = "stateOfScoreTeamA";
private static final String state_scoreTeamB = "stateOfScoreTeamB";


    /**
     * When the app is opened or the orientation is changed display scores
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Save scores when the activity begins to stop.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(state_scoreTeamA, scoreTeamA);
        savedInstanceState.putInt(state_scoreTeamB, scoreTeamB);
    }

    /**
     * Restore scores from saved state and display
     */

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        scoreTeamA = savedInstanceState.getInt(state_scoreTeamA);
        scoreTeamB = savedInstanceState.getInt(state_scoreTeamB);

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase scores.
     */
    public void aPlusThree(View v){
        changeScore(3, "A");
    }
    public void aPlusTwo(View v){
        changeScore(2, "A");
    }
    public void aPlusOne(View v){
        changeScore(1, "A");
    }
    public void bPlusThree(View v){
        changeScore(3, "B");
    }
    public void bPlusTwo(View v){
        changeScore(2, "B");
    }
    public void bPlusOne(View v){
        changeScore(1, "B");
    }
    public void changeScore(int change, String team){

        if(team == "A"){
            scoreTeamA += change;
            displayForTeamA(scoreTeamA);
        }
        else if(team == "B") {
            scoreTeamB += change;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Reset scores when reset button is clicked.
     */
    public void reset(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}

