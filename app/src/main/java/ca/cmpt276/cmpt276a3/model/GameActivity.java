package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import ca.cmpt276.cmpt276a3.MenuActivity;
import ca.cmpt276.cmpt276a3.R;

// Image from:
// https://www.pngwing.com/ko/free-png-idbew mines
// https://www.freepik.com/premium-vector/congratulations-lettering-message-vector-greeting_3049381.htm#page=1&query=congratulations&position=43 congratulations


// Code found at:
// https://www.youtube.com/watch?v=4MFzuP1F-xQ Dynamic buttons


public class GameActivity extends AppCompatActivity {

    String board_size;
    int mines;
    int rows, cols;

    ArrayList<Integer> a1;
    int[][] random;
    Button[][] buttons;

    int found = 0;
    int scan = 0;
    int played = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        board_size = "4 x 6";
        mines = 6; rows = 4; cols = 6;

        extractDataFromOptions();
        setBoardSize();
        
        buttons = new Button[rows][cols];

        shuffleMines();
        populateButtons();
        textSettings();
    }

    private void setMessage() {
        FragmentManager manager = getSupportFragmentManager();
        MessageFragment dialog = new MessageFragment();
        dialog.show(manager, "MessageDialog");


    }

    private void shuffleMines() {
        a1 = new ArrayList<>();
        for (int i = 0; i < mines; i++) {
            a1.add(0);
        } for (int i = mines; i < rows * cols; i++) {
            a1.add(1);
        }
        // Shuffles the location of the mines
        Collections.shuffle(a1);

        random = new int [rows][cols];

        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                random[i][j] = a1.get(k);
                k++;
            }
        }
    }

    private void setBoardSize() {
        if (board_size.equals("5 x 10")) {
            rows = 5; cols = 10;
        } if (board_size.equals("6 x 15")) {
            rows = 6; cols = 15;
        }
    }

    private void populateButtons() {
        TableLayout table = (TableLayout) findViewById(R.id.table);
        for (int row = 0; row < rows; row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col = 0; col < cols; col++) {
                final int FINAL_ROW = row;
                final int FINAL_COL = col;
                Button btn = new Button (this);
                btn.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                // Make text not clip on small buttons
                btn.setPadding(0,0,0,0);

                btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        gridButtonClicked(FINAL_ROW, FINAL_COL);
                    }
                });

                tableRow.addView(btn);
                buttons[row][col] = btn;
            }
        }
    }

    private void gridButtonClicked(int row, int col) {
        Button btn = buttons[row][col];

        // Lock Button Sizes:
        lockButtonSizes();

        // Scale image to button
        int newWidth = btn.getWidth();
        int newHeight = btn.getHeight();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mines);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
        Resources resource = getResources();

        if (random[row][col] == 0) { // has mine
            btn.setBackground(new BitmapDrawable(resource, scaledBitmap));
            found++;
            scan++;
            textSettings();
            random[row][col] = -2;

            if (found == mines) {
                played++;
                setMessage();
                Intent intent = MenuActivity.makeIntent(GameActivity.this);
                startActivity(intent);
            }

            for (int i = 0; i < rows; i++) {  // updates number of hidden mines
                if (random[i][col] == -1) {
                    String text = buttons[i][col].getText().toString();
                    int num = Integer.parseInt(text);
                    int count = num - 1;
                    buttons[i][col].setText("" + count);
                }
            } for (int j = 0; j < cols; j++) {
                if (random[row][j] == -1) {
                    String text = buttons[row][j].getText().toString();
                    int num = Integer.parseInt(text);
                    int count = num - 1;
                    buttons[row][j].setText("" + count);
                }
            }
        }

        if (random[row][col] == 1) { // no mine
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (random[i][col] == 0) {
                    count++;
                }
            } for (int j = 0; j < cols; j++) {
                if (random[row][j] == 0) {
                    count++;
                }
            }

            btn.setText("" + count);
            random[row][col] = -1;
            scan++;
            textSettings();
        }
    }

    private void lockButtonSizes() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Button button = buttons[row][col];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }

    private void textSettings () {
        TextView foundMines = (TextView) findViewById(R.id.foundMines);
        String message1 = "Found " +  found + " of " + mines + " Mines";
        foundMines.setText(message1);

        TextView scansUsed = (TextView) findViewById(R.id.scans);
        String message2 = "# Scans used: " + scan;
        scansUsed.setText(message2);

        TextView numPlayed = (TextView) findViewById(R.id.timesPlayed);
        String message3 = "Times Played: " + played;
        numPlayed.setText(message3);
    }

    private void extractDataFromOptions() {
        board_size = OptionsActivity.getGroupBoard(this);
        mines = OptionsActivity.getNumMines(this);
    }

    public static Intent makeIntent(Context context) {
        // Switching activity from MenuActivity to GameActivity
        return new Intent (context, GameActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        extractDataFromOptions();
    }
}