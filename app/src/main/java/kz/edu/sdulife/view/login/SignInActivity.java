package kz.edu.sdulife.view.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kz.edu.sdulife.R;

public class SignInActivity extends AppCompatActivity {

    Button btn_sign_in;
    TextView forgot_psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        forgot_psw = findViewById(R.id.txt_forgot_psw);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Everything is working", Toast.LENGTH_SHORT).show();
            }
        });

    }
}