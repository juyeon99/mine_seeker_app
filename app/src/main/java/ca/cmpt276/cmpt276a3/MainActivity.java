package ca.cmpt276.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// Code found at:
// https://www.youtube.com/watch?v=BU49KDMR1AY forcing landscape mode
// https://www.youtube.com/watch?v=gwCvv4W6mGY welcome screen
// https://www.youtube.com/watch?v=JLIFqqnSNmg welcome screen animation
// https://www.youtube.com/watch?v=B1oaE0Odqes&feature=youtu.be switching activities



public class MainActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView title, author;
    Button btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE); // setting landscape screen
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); // removing the action bar

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.mine_seeker_gif);
        title = findViewById(R.id.title);
        author = findViewById(R.id.author);

        image.setAnimation(bottomAnim);
        title.setAnimation(topAnim);
        author.setAnimation(bottomAnim);

        new Handler().postDelayed (new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

        btnSkip = (Button) findViewById(R.id.skip);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            // Skips to main menu
            @Override
            public void onClick(View v) {
                Intent intent = MenuActivity.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });

    }
}