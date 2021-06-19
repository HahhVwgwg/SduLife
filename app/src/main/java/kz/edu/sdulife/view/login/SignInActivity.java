package kz.edu.sdulife.view.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kz.edu.sdulife.R;
import kz.edu.sdulife.common.BaseActivity;
import kz.edu.sdulife.view.home.HomeActivity;

public class SignInActivity extends BaseActivity {

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
                openActivity(HomeActivity.class);finish();
            }
        });

    }
}