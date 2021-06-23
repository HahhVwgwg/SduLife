package kz.edu.sdulife.view.home.notifications.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kz.edu.sdulife.R;
import kz.edu.sdulife.common.BaseActivity;
import kz.edu.sdulife.view.home.HomeActivity;
import kz.edu.sdulife.view.home.main.MainFragment;
import kz.edu.sdulife.view.home.notifications.NotificationsFragment;

public class CalendarActivity extends BaseActivity {
    TextView toolbar;
    ImageView back_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        toolbar = findViewById(R.id.toolbar_title);
        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbar.setText("Calendar");

    }

    public void onBackPressed () {
        super.onBackPressed();
        Intent i=new Intent(Intent.ACTION_MAIN);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();

    }

}