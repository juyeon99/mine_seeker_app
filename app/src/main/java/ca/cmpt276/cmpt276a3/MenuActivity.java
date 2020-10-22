package ca.cmpt276.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import ca.cmpt276.cmpt276a3.model.GameActivity;
import ca.cmpt276.cmpt276a3.model.HelpActivity;
import ca.cmpt276.cmpt276a3.model.OptionsActivity;

// Photo from: https://unsplash.com/photos/EfhCUc_fjrU
// Code found at:
// https://www.youtube.com/watch?v=nlPtfncjOWA Customizing buttons

public class MenuActivity extends AppCompatActivity {

    Button btnPlay;
    Button btnOptions;
    Button btnHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            // Skips to main menu
            @Override
            public void onClick(View v) {
                Intent intent = GameActivity.makeIntent(MenuActivity.this);
                startActivity(intent);
            }
        });

        btnOptions = (Button) findViewById(R.id.btnOptions);
        btnOptions.setOnClickListener(new View.OnClickListener() {
            // Skips to main menu
            @Override
            public void onClick(View v) {
                Intent intent = OptionsActivity.makeIntent(MenuActivity.this);
                startActivity(intent);
            }
        });

        btnHelp = (Button) findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(new View.OnClickListener() {
            // Skips to main menu
            @Override
            public void onClick(View v) {
                Intent intent = HelpActivity.makeIntent(MenuActivity.this);
                startActivity(intent);
            }
        });
    }

    public static Intent makeIntent(Context context) {
        // Switching activity from MainActivity to MenuActivity
        return new Intent (context, MenuActivity.class);
    }

    public static Intent makeIntent() {
        return null;
    }
}