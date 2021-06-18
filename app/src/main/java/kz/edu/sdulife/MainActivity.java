package kz.edu.sdulife;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import kz.edu.sdulife.view.login.SignInActivity;

public class MainActivity extends AppCompatActivity {
    ImageView img_splash;
    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_splash = findViewById(R.id.splash_anim);
        img_splash.animate().translationY(2000).setDuration(1000).setStartDelay(2500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);finish();

            }
        },SPLASH_TIME_OUT);
    }
}