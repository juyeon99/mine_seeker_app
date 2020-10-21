package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import ca.cmpt276.cmpt276a3.R;

// Code found at:
// https://www.youtube.com/watch?v=6rz4fgZ2qP0 ScrollView

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        TextView helpMessage = (TextView) findViewById(R.id.helpDescription);

        String message = "  Mine Seeker is a game that the user have to find all the mines" +
                "\n - Created by Juyeon Hong - " +
                "\n cr. https://opencoursehub.cs.sfu.ca/jackt/grav-cms/cmpt276-2/assignments/files/assignment_3.pdf" +
                "\n Photo from: https://unsplash.com/photos/EfhCUc_fjrU";
        helpMessage.setText(message);
    }

    public static Intent makeIntent(Context context) {
        return new Intent (context, HelpActivity.class);
    }
}