package kz.edu.sdulife.view.home;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import kz.edu.sdulife.R;
import kz.edu.sdulife.view.home.main.MainFragment;
import kz.edu.sdulife.view.home.news.NewsFragment;
import kz.edu.sdulife.view.home.profile.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Bottom nav - start
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        //Bottom nav - end

        //Setting Home Fragment as a main fragment - start
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,
                        new MainFragment()).commit();
        //Setting Home Fragment as a main fragment - start

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

//                        case R.id.nav_create:
//                            openFragment(new CreateFragment());
//                            break;
//
//                        case R.id.nav_message:
//                            openFragment(new MessagesFragment());
//                            break;

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
}