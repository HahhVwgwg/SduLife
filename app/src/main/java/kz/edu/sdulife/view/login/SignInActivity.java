package kz.edu.sdulife.view.login;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kz.edu.sdulife.R;
import kz.edu.sdulife.common.BaseActivity;
import kz.edu.sdulife.view.home.HomeActivity;

public class SignInActivity extends BaseActivity {
    private long backPressedTime;
    private Toast backToast;
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

    @Override
    public void onBackPressed() {
        final Toast toast = new Toast(getBaseContext());
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast_close_app,
                (ViewGroup)findViewById(R.id.close_toast_layout));
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            toast.cancel();
            super.onBackPressed();
            return;
        }else{
            toast.setGravity(Gravity.BOTTOM,0,40);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}