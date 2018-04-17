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
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}
