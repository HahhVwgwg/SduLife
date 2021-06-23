package kz.edu.sdulife;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import kz.edu.sdulife.common.BaseActivity;
import kz.edu.sdulife.view.login.SignInActivity;

public class MainActivity extends BaseActivity {
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
                openActivity(SignInActivity.class);

            }
        },SPLASH_TIME_OUT);
    }
}