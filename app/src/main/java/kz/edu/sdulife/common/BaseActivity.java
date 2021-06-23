package kz.edu.sdulife.common;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.Toast;

import kz.edu.sdulife.R;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void openFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
                //fragmentTransaction.addToBackStack("youfragment");
        fragmentTransaction.commit();
    }






    public void showMessage(String s){
        Toast.makeText(this, s ,Toast.LENGTH_SHORT).show();
    }


    public void openActivity(Class className){

        Intent intent = new Intent(this ,className);
        startActivity(intent);finish();

//        getFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_layout,fragment)
//                .commit();
    }
}
