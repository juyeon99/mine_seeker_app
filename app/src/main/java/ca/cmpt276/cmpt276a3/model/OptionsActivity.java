package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import ca.cmpt276.cmpt276a3.R;

// Code found at:
// https://www.youtube.com/watch?v=NgFBaffNEOY Spinners
// https://www.youtube.com/watch?v=_yaP4etGKlU&feature=youtu.be Radio Buttons

public class OptionsActivity extends AppCompatActivity{ // implements AdapterView.OnItemSelectedListener {

//    Spinner boardSize, numOfMines;
//    ArrayList<String> arrList_Board;
//    ArrayAdapter<String> arrAdapter_Board;
//
//    ArrayList<String> arrList_Mines;
//    ArrayAdapter<String> arrAdapter_Mines;
//
//    String board_size;
//    int mines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        createRadioBtn1();
        createRadioBtn2();



//        boardSize = (Spinner) findViewById(R.id.spnBoardSize);
//        numOfMines = (Spinner) findViewById(R.id.spnNumOfMines);
//
//        arrList_Board = new ArrayList<>();
//        arrList_Board.add("4 x 6");
//        arrList_Board.add("5 x 10");
//        arrList_Board.add("6 x 15");
//
//        arrAdapter_Board = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrList_Board);
//        boardSize.setAdapter(arrAdapter_Board);
//
//        boardSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                board_size = parent.getItemAtPosition(position).toString();
//                // Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                board_size = parent.getItemAtPosition(1).toString();
//            }
//        });
//
//        arrList_Mines = new ArrayList<>();
//        arrList_Mines.add("6");
//        arrList_Mines.add("10");
//        arrList_Mines.add("15");
//        arrList_Mines.add("20");
//
//        arrAdapter_Mines = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrList_Mines);
//        numOfMines.setAdapter(arrAdapter_Mines);
//
//        numOfMines.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String text = parent.getItemAtPosition(position).toString();
//                mines = Integer.parseInt(text);
//                // Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                String text = parent.getItemAtPosition(1).toString();
//                mines = Integer.parseInt(text);
//            }
//        });


//        Intent saveIntent = GameActivity.makeIntent2(
//                OptionsActivity.this, board_size, mines);
//        startActivity(saveIntent);


//        Spinner boardSize = findViewById(R.id.spnBoardSize);
//        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
//                this,
//                R.array.boardSize,
//                android.R.layout.simple_spinner_item);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        boardSize.setAdapter(adapter1);
//        boardSize.setOnItemSelectedListener(this);
//
//        Spinner numOfMines = findViewById(R.id.spnNumOfMines);
//        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
//                this,
//                R.array.numOfMines,
//                android.R.layout.simple_spinner_item);
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        numOfMines.setAdapter(adapter2);
//        numOfMines.setOnItemSelectedListener(this);

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
            String board_size = boardSize[i];

            RadioButton btn = new RadioButton(this);
            btn.setText(board_size);

            //Add to radio group:
            group.addView(btn);
        }
    }

    private void createRadioBtn2() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroupMines);
        int[] numMines = getResources().getIntArray(R.array.numOfMines);

        //Create the buttons:
        for (int i = 0; i < numMines.length; i++) {
            int board_size = numMines[i];

            RadioButton btn = new RadioButton(this);
            btn.setText("" + board_size);

            //Add to radio group:
            group.addView(btn);
        }
    }

    /*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        // Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String text = parent.getItemAtPosition(1).toString();
    }
*/
}