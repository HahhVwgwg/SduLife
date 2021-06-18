package kz.edu.sdulife.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
