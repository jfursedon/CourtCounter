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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void reset(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}

