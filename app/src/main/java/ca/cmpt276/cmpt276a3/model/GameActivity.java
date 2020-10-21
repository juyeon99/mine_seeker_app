package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import ca.cmpt276.cmpt276a3.R;

public class GameActivity extends AppCompatActivity {

    String board_size;
    int mines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        board_size = "4 x 6";
        mines = 6;

        extractDataFromOptions();

        Toast.makeText(getApplicationContext(), "Board size: " + board_size, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Number of mines: " + mines, Toast.LENGTH_SHORT).show();
    }

    public static Intent makeIntent(Context context) {
        // Switching activity from MenuActivity to GameActivity
        return new Intent (context, GameActivity.class);
    }

    private void extractDataFromOptions() {
        board_size = OptionsActivity.getGroupBoard(this);
        mines = OptionsActivity.getNumMines(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        extractDataFromOptions();
    }
}