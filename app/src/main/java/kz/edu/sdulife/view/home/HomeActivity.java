package kz.edu.sdulife.view.home;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import kz.edu.sdulife.R;
import kz.edu.sdulife.common.BaseActivity;
import kz.edu.sdulife.view.home.development.DevelopmentFragment;
import kz.edu.sdulife.view.home.main.MainFragment;
import kz.edu.sdulife.view.home.news.NewsFragment;
import kz.edu.sdulife.view.home.notifications.NotificationsFragment;
import kz.edu.sdulife.view.home.profile.ProfileFragment;

public class HomeActivity extends BaseActivity {
    private long backPressedTime;
    private Toast backToast;
    TextView custom_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Bottom nav - start
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        //Bottom nav - end

        //Setting Main Fragment as a main fragment - start
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,
                        new MainFragment()).commit();
        //Setting Main Fragment as a main fragment - start

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            openFragment(new MainFragment());
                            break;

                        case R.id.nav_news:
                            openFragment(new NewsFragment());
                            break;

                        case R.id.nav_developments:
                            openFragment(new DevelopmentFragment());
                            break;

                        case R.id.nav_notifications:
                            openFragment(new NotificationsFragment());
                            break;

                        case R.id.nav_profile:
                            openFragment(new ProfileFragment());
                            break;
                    }


                    return true;
                }
            };

    public void openFragment(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout,fragment)
                .commit();
    }
    @Override
    public void onBackPressed() {
        final Toast toast = new Toast(getApplicationContext());

        if (backPressedTime + 2000 > System.currentTimeMillis()) {

            super.onBackPressed();
            return;
        }else{
            LayoutInflater layoutInflater = getLayoutInflater();
            View layout = layoutInflater.inflate(R.layout.custom_toast_close_app,
                    (ViewGroup)findViewById(R.id.close_toast_layout));
            toast.setGravity(Gravity.BOTTOM,0,120);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}