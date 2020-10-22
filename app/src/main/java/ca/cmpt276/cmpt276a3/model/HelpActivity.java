package ca.cmpt276.cmpt276a3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

import ca.cmpt276.cmpt276a3.R;

// Code found at:
// https://www.youtube.com/watch?v=6rz4fgZ2qP0 ScrollView
// https://www.youtube.com/watch?v=aQIqQ2-lyO8&feature=share hyperlink

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        // Link to the site
        TextView text = (TextView) findViewById(R.id.link);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        TextView helpMessage = (TextView) findViewById(R.id.helpDescription);

        String message = "  Mine Seeker is a game that the user have to find all the mines." +
                "User can choose the number of mines and board size by choosing from the Options." +
                "If the user clicks the grid, it will show either mine or a number." +
                "The number here represents the number of hidden mines across the row and column." +
                "If the user finds all the mines, then it's done!" +
                "\n\n cr.  https://unsplash.com/photos/EfhCUc_fjrU\n" +
                "https://www.youtube.com/watch?v=nlPtfncjOWA\n" +
                "https://www.youtube.com/watch?v=y6StJRn-Y-A&feature=youtu.be\n" +
                "https://www.youtube.com/watch?v=BU49KDMR1AY\n" +
                "https://www.youtube.com/watch?v=gwCvv4W6mGY \n" +
                "https://www.youtube.com/watch?v=JLIFqqnSNmg \n" +
                "https://www.youtube.com/watch?v=B1oaE0Odqes&feature=youtu.be\n" +
                "https://www.pngwing.com/ko/free-png-idbew\n" +
                "https://www.freepik.com/premium-vector/congratulations-lettering-message-vector- greeting_3049381.htm#page=1&query=congratulations&position=43 congratulations\n" +
                "https://www.youtube.com/watch?v=4MFzuP1F-xQ\n" +
                "https://www.youtube.com/watch?v=_yaP4etGKlU&feature=youtu.be\n" +
                "https://www.youtube.com/watch?v=m_ZiP0U_zRA&feature=youtu.be\n" +
                "https://www.youtube.com/watch?v=6rz4fgZ2qP0";
        helpMessage.setText(message);
    }

    public static Intent makeIntent(Context context) {
        return new Intent (context, HelpActivity.class);
    }
}