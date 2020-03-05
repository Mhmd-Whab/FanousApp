package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button login ;
    TextView forgot_password;
    TextView sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlist();
            }
        });
        forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPassword();
            }
        });
        sign_up = findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

    }
    public  void openlist(){
        Intent main_list = new Intent(this, DevicesList.class);
        startActivity(main_list);
    }
    public void openForgotPassword(){
        Intent main_forgot_password = new Intent(this,ForgotPassword.class);
        startActivity(main_forgot_password);
    }
    public void openSignUp(){
        Intent main_SignUp = new Intent(this,SignUp.class);
        startActivity(main_SignUp);
    }
}
