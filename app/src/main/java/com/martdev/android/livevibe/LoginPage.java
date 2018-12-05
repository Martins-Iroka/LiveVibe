package com.martdev.android.livevibe;

import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    private LinearLayout mLayout1, mLayout2;
    private Animation animation;
    private EditText mEmail, mPassword;
    private Button mSignUpButton;
    private TextView mFacebookText, mRegisterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_login_page);

        mEmail = findViewById(R.id.email);

        mPassword = findViewById(R.id.password);
        mPassword.getText();

        mSignUpButton = findViewById(R.id.sign_up_button);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.FL), "Welcome " + mEmail.getText().toString(), Snackbar.LENGTH_SHORT);
                snackbar.show();
                mEmail.setEnabled(false);
                mPassword.setEnabled(false);
            }
        });

        mFacebookText = findViewById(R.id.facebook);
        mFacebookText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.FL), "Facebook connected", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        mRegisterText = findViewById(R.id.register);
        mRegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.FL), "Registration successful", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
        startAnimation();
    }

    private void startAnimation() {
        mLayout1 = findViewById(R.id.layout1);
        animation = AnimationUtils.loadAnimation(LoginPage.this, R.anim.splash_screen_anim);
        mLayout1.startAnimation(animation);

        mLayout2 = findViewById(R.id.layout2);
        animation = AnimationUtils.loadAnimation(LoginPage.this, R.anim.content_move_up);
        mLayout2.startAnimation(animation);
    }
}
