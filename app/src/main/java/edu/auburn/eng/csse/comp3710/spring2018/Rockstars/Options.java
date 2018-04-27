package edu.auburn.eng.csse.comp3710.spring2018.Rockstars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        Button enableSound;
        enableSound = (Button) findViewById(R.id.enableSound);
        enableSound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg) {

                MainMenu.soundOn = true;
                if (!MainMenu.ring.isPlaying()) {
                    MainMenu.ring.start();
                } else {
                    MainMenu.ring.pause();
                }
            }
        });

        Button disableSound;
        disableSound = (Button) findViewById(R.id.disableSound);
        disableSound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg) {

                MainMenu.soundOn = false;
                if (MainMenu.ring.isPlaying()) {
                    MainMenu.ring.pause();
                } else {
                    MainMenu.ring.start();
                }
            }
        });
        
        Button save;
        save = (Button) findViewById(R.id.SaveOptions);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }

    public void onOptionSelected(View v) {

        boolean selected;
        selected = ((RadioButton) v).isChecked();
        switch (v.getId()) {
            case R.id.Easy:
                if (selected) {
                    MainActivity.difficulty = 2;
                    break;
                }
            case R.id.Medium:
                if (selected) {
                    MainActivity.difficulty = 3;
                    break;
                }
            case R.id.Hard:
                if (selected) {
                    MainActivity.difficulty = 4;
                    break;
                }
        }
    }
}

