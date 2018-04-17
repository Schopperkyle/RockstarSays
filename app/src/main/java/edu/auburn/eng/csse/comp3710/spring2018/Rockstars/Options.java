package edu.auburn.eng.csse.comp3710.spring2018.Rockstars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.app.Activity;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

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

