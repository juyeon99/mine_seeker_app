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

        String message = "   Mine Seeker is a game where the player tries to " +
                "find a certain number of mines which are randomly " +
                "placed in cells on the game board. The player taps on a cell to inspect it. " +
                "If the cell contains a mine, then the mine is revealed. If there is no mine, then inspecting the cell triggers " +
                "a scan which shows the counts of hidden mines in the same row and column as the selected cell. " +
                "This information allows the player to make smart choices about which cells to inspect. " +
                "The goal is to find all of the mines using the minimum number of scans.\n" +
                "\n - App created by Juyeon Hong - " +
                "\n cr. https://opencoursehub.cs.sfu.ca/jackt/grav-cms/cmpt276-2/assignments/files/assignment_3.pdf";
        helpMessage.setText(message);
    }

    public static Intent makeIntent(Context context) {
        return new Intent (context, HelpActivity.class);
    }
}