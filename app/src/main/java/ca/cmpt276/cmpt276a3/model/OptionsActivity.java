package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import ca.cmpt276.cmpt276a3.R;

// Code found at:
// https://www.youtube.com/watch?v=_yaP4etGKlU&feature=youtu.be Radio Buttons
// https://www.youtube.com/watch?v=m_ZiP0U_zRA&feature=youtu.be Shared Preferences

public class OptionsActivity extends AppCompatActivity{ // implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        createRadioBtn1();
        createRadioBtn2();

        String savedBoardSize = getGroupBoard(this);

    }

    public static Intent makeIntent(Context context) {
        // Switching activity from MenuActivity to OptionsActivity
        return new Intent (context, OptionsActivity.class);
    }

    private void createRadioBtn1() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroupBoardSize);
        String[] boardSize = getResources().getStringArray(R.array.boardSize);

        //Create the buttons:
        for (int i = 0; i < boardSize.length; i++) {
            final String board_size = boardSize[i];

            RadioButton btn = new RadioButton(this);
            btn.setText(board_size);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveGroupBoard(board_size);
                }
            });

            //Add to radio group:
            group.addView(btn);

            if (board_size.equals(getGroupBoard(this))) {
                btn.setChecked(true);
            }
        }
    }

    private void saveGroupBoard (String board_size) {
        SharedPreferences prefs = this.getSharedPreferences("AppPrefs1", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Board Size", board_size);
        editor.apply();
    }

    static public String getGroupBoard(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("AppPrefs1", MODE_PRIVATE);
        String defaultGroupBoard = context.getResources().getString(R.string.default_board_size);
        return prefs.getString("Board Size", defaultGroupBoard);
    }

    private void createRadioBtn2() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroupMines);
        int[] numMines = getResources().getIntArray(R.array.numOfMines);

        //Create the buttons:
        for (int i = 0; i < numMines.length; i++) {
            final int mine = numMines[i];

            RadioButton btn = new RadioButton(this);
            btn.setText("" + mine);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveNumMines(mine);
                }
            });

            //Add to radio group:
            group.addView(btn);

            if (mine == getNumMines(this)) {
                btn.setChecked(true);
            }
        }
    }

    private void saveNumMines (int mine) {
        SharedPreferences prefs = this.getSharedPreferences("AppPrefs2", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Mines", mine);
        editor.apply();
    }

    static public int getNumMines (Context context) {
        SharedPreferences prefs = context.getSharedPreferences("AppPrefs2", MODE_PRIVATE);
        int defaultMines = context.getResources().getInteger(R.integer.default_num_mines);
        return prefs.getInt("Mines", defaultMines);
    }
}