package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
        extractDataFromIntent();

        Toast.makeText(getApplicationContext(), board_size, Toast.LENGTH_SHORT).show();
    }

    public static Intent makeIntent(Context context) {
        // Switching activity from MenuActivity to GameActivity
        return new Intent (context, GameActivity.class);
    }


    public static Intent makeIntent2(Context context, String board_size, int mines) {
        Intent intent = new Intent(context, GameActivity.class);
        intent.putExtra("board size", board_size);
        intent.putExtra("number of mines", mines);
        return intent;
    }

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        board_size = intent.getStringExtra("board size");
        mines = intent.getIntExtra("mines", 6);
        Toast.makeText(getApplicationContext(), board_size, Toast.LENGTH_SHORT).show();
    }
}