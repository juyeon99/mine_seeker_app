package ca.cmpt276.cmpt276a3.model;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

import ca.cmpt276.cmpt276a3.MainActivity;
import ca.cmpt276.cmpt276a3.MenuActivity;
import ca.cmpt276.cmpt276a3.R;

// Code found at:
// https://www.youtube.com/watch?v=y6StJRn-Y-A&feature=youtu.be

public class MessageFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Create the view to show
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.message_layout, null);

        // Create a button Listener
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
//                TextView tv = (TextView) getActivity().findViewById(R.id.message);
//                tv.setText("You've found all the mines!");
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Intent intent = MenuActivity.makeIntent();
                        startActivity(intent);
                        //finish();
                        break;
                }
            }
        };

        // Build the alert dialog
        return new AlertDialog.Builder(getActivity())
                .setTitle("Congratulations!")
                .setView(v)
                .setPositiveButton(android.R.string.ok, listener)
                .create();
    }

}
