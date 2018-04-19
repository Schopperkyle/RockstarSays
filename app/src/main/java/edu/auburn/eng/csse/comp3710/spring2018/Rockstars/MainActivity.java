package edu.auburn.eng.csse.comp3710.spring2018.Rockstars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
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
    public boolean delay1 = true;
    Random r = new Random();

    int [] gameLength = new int [1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startOver = (Button) findViewById(R.id.StartOverButton);
        startOver.performClick();

    }

    public void start(View v) {

        findViewById(R.id.StartOverButton).setEnabled(false);
        for (int i = 0; i < level - 1; i++) {
            gameLength[0] = r.nextInt(4) + 1;
        }
        nextLevel();
        Button red = ((Button) findViewById(R.id.redButton));
        Button blue = ((Button) findViewById(R.id.blueButton));
        Button yellow = ((Button) findViewById(R.id.yellowButton));
        Button green = ((Button) findViewById(R.id.greenButton));

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
        TextView scoreDisplay = (TextView) findViewById(R.id.score);
        scoreDisplay.setText("Score: " + (highScore - 1));

    }

    public void endGame() {

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
