package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import ca.cmpt276.cmpt276a3.MenuActivity;
import ca.cmpt276.cmpt276a3.R;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


    }

    public static Intent makeIntent(Context context) {
        // Switching activity from MenuActivity to OptionsActivity
        return new Intent (context, OptionsActivity.class);
    }
}