package com.example.brianr.keuanganhimasif;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView judul;
    Typeface tf1;
    EditText username, password;
    CheckBox hintpass;
    Button login;
    RelativeLayout layout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        judul = (TextView) findViewById(R.id.judul);
        tf1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        judul.setTypeface(tf1);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        hintpass = (CheckBox) findViewById(R.id.hintpass);
        username.setTypeface(tf1);
        password.setTypeface(tf1);
        hintpass.setTypeface(tf1);
        hintpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked) {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });
        layout = (RelativeLayout) findViewById(R.id.layout);
        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }
}
