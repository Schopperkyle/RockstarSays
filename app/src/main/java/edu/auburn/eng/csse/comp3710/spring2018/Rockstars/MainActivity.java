package edu.auburn.eng.csse.comp3710.spring2018.Rockstars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.os.CountDownTimer;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public static int difficulty = 3;
    public int level = 1;
    public int curLevel = level - 1;
    public int count = 0;
    public int initialCount = 0;
    public int highScore = 0;
    public int greatestScore = 0;
    public boolean delay1 = true;
    Random r = new Random();

    int [] gameLength = new int [1000];

    static final String HIGHSCORE = "";
    static final String GREATESTSCORE = "";
    static final String GAMELENGTH = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startOver = (Button) findViewById(R.id.StartOverButton);
        startOver.performClick();

    }

    // Handles pauses in the game

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(HIGHSCORE, highScore);
        savedInstanceState.putInt(GREATESTSCORE, greatestScore);
        savedInstanceState.putIntArray(GAMELENGTH, gameLength);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        highScore = savedInstanceState.getInt(HIGHSCORE);
        greatestScore = savedInstanceState.getInt(GREATESTSCORE);
        gameLength = savedInstanceState.getIntArray(GAMELENGTH);
    }

    // Starts game

    public void start(View v) {

        findViewById(R.id.StartOverButton).setVisibility(View.INVISIBLE);
        for (int i = 0; i < level - 1; i++) {
            gameLength[0] = r.nextInt(4) + 1;
        }
        nextLevel();
        Button red = ((Button) findViewById(R.id.redButton));
        Button blue = ((Button) findViewById(R.id.blueButton));
        Button yellow = ((Button) findViewById(R.id.yellowButton));
        Button green = ((Button) findViewById(R.id.greenButton));

        // Button listeners

        red.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gameLength[initialCount] == 1) {
                    initialCount++;
                    if (initialCount == curLevel) {
                        nextLevel();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    endGame();
                }
            }
        });

        blue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gameLength[initialCount] == 2) {
                    initialCount++;
                    if (initialCount == curLevel) {
                        nextLevel();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    endGame();
                }
            }
        });

        yellow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gameLength[initialCount] == 3) {
                    initialCount++;
                    if (initialCount == curLevel) {
                        nextLevel();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    endGame();
                }
            }
        });

        green.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gameLength[initialCount] == 4) {
                    initialCount++;
                    if (initialCount == curLevel) {
                        nextLevel();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    endGame();
                }
            }
        });
    }

    // Methods to highlight various buttons

    public void highlightRed() {
        ((Button) findViewById(R.id.redButton)).setPressed(true);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.redButton)).setPressed(false);
            }
        }, 1400/difficulty);
    }

    public void highlightBlue() {
        ((Button) findViewById(R.id.blueButton)).setPressed(true);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.blueButton)).setPressed(false);
            }
        }, 1400/difficulty);
    }

    public void highlightYellow() {
        ((Button) findViewById(R.id.yellowButton)).setPressed(true);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.yellowButton)).setPressed(false);
            }
        }, 1400/difficulty);
    }

    public void highlightGreen() {
        ((Button) findViewById(R.id.greenButton)).setPressed(true);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.greenButton)).setPressed(false);
            }
        }, 1400/difficulty);
    }

    // Determines highlighted button
    // Deactivates buttons
    // Determines score
    // Sets high score

    public void nextLevel() {

        gameLength[curLevel] = r.nextInt(4) + 1;

        curLevel++;
        count = 0;
        TextView turn = (TextView) findViewById(R.id.turnDisplay);
        turn.setText("Slash's Turn!");
        ((Button) findViewById(R.id.redButton)).setEnabled(false);
        ((Button) findViewById(R.id.blueButton)).setEnabled(false);
        ((Button) findViewById(R.id.yellowButton)).setEnabled(false);
        ((Button) findViewById(R.id.greenButton)).setEnabled(false);
        highlightAll();
        highScore++;
        if (highScore >= greatestScore) {
            greatestScore = highScore;
        }
        TextView scoreDisplay = (TextView) findViewById(R.id.score);
        scoreDisplay.setText("Score: " + (highScore - 1));

        TextView highScoreDisplay = (TextView) findViewById(R.id.highscore);
        highScoreDisplay.setText("High Score: " + (greatestScore - 1));

        if (curLevel == 6) {
            Toast toast = Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            endGame();
        }
    }

    // Terminates Game

    public void endGame() {

        Button startOver = (Button) findViewById(R.id.StartOverButton);
        startOver.setVisibility(View.VISIBLE);

        Toast toast = Toast.makeText(getApplicationContext(), "Score: " + (highScore - 1), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        initialCount = 0;
        for (int i = 0; i < curLevel; i++) {
            gameLength[i] = 0;
        }
        curLevel = level - 1;
        highScore = 0;
        ((Button) findViewById(R.id.redButton)).setEnabled(false);
        ((Button) findViewById(R.id.blueButton)).setEnabled(false);
        ((Button) findViewById(R.id.yellowButton)).setEnabled(false);
        ((Button) findViewById(R.id.greenButton)).setEnabled(false);
        findViewById(R.id.StartOverButton).setEnabled(true);
        TextView restart = (TextView) findViewById(R.id.turnDisplay);
        restart.setText("Click Start Over to Start New Game");
    }

    // Determines button to highlight

    public void highlightAll() {

        new CountDownTimer( (((1400/difficulty) + 1000/difficulty) * (curLevel + 2)), ((1400/difficulty) + 1000/difficulty)) {

            public void onTick(long time) {
                if (delay1) {
                    delay1 = false;
                }
                else if (gameLength[count] == 1) {
                    highlightRed();
                    count++;
                }
                else if (gameLength[count] == 2) {
                    highlightBlue();
                    count++;
                }
                else if (gameLength[count] == 3) {
                    highlightYellow();
                    count++;
                }
                else if (gameLength[count] == 4) {
                    highlightGreen();
                    count++;
                }
            }

            // Allows buttons to be selected

            public void onFinish() {

                count = 0;
                initialCount = 0;
                delay1 = true;
                ((Button) findViewById(R.id.redButton)).setEnabled(true);
                ((Button) findViewById(R.id.blueButton)).setEnabled(true);
                ((Button) findViewById(R.id.yellowButton)).setEnabled(true);
                ((Button) findViewById(R.id.greenButton)).setEnabled(true);
                TextView turn = (TextView) findViewById(R.id.turnDisplay);
                turn.setText("Your Turn!");
            }

        }.start();
    }
}
