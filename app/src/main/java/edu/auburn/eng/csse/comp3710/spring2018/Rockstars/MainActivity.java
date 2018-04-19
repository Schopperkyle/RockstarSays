package edu.auburn.eng.csse.comp3710.spring2018.Rockstars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
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
