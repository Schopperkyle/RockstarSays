package edu.auburn.eng.csse.comp3710.spring2018.Rockstars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.media.MediaPlayer;

public class MainMenu extends AppCompatActivity {

    static MediaPlayer ring;
    public static boolean soundOn = true;
    boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Button start;
        Button options;

        start = (Button) findViewById(R.id.StartButton);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg) {
                Intent startGame = new Intent(MainMenu.this, MainActivity.class);
                startActivity(startGame);
                if (soundOn && !(playing)) {
                    playMusic(arg);
                    playing = true;
                }
            }
        });

        options = (Button) findViewById(R.id.OptionsButton);
        options.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg) {
                Intent optionsMenu = new Intent(MainMenu.this, Options.class);
                startActivity(optionsMenu);
            }
        });
    }

    // Starts music

    public void playMusic(View v) {

        ring = MediaPlayer.create(MainMenu.this,R.raw.ring);

        try {
            ring.start();
        }
        catch (Exception e) {
            Log.e("APP", "exception", e);
        }
    }
}