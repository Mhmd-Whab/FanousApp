package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button login ;
    TextView forgot_password;
    TextView sign_up;
    EditText mail;
    EditText pass;
    ProgressBar progbar;
    FirebaseAuth maAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.editText);
        pass =findViewById(R.id.editText2);
        progbar = findViewById(R.id.progressBar2);
        forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setEnabled(true);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgot_password.setEnabled(false);
                openForgotPassword();
            }
        });
        sign_up = findViewById(R.id.sign_up);
        sign_up.setEnabled(true);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign_up.setEnabled(false);
                openSignUp();
                sign_up.setEnabled(true);
            }
        });
        maAuth = FirebaseAuth.getInstance();
        login=findViewById(R.id.login);
        login.setEnabled(true);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setEnabled(false);
                String Email = mail.getText().toString().trim();
                String Pass = pass.getText().toString().trim();

                progbar.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(MainActivity.this,"Please Enter your Email",Toast.LENGTH_SHORT).show();
                    pass.setText("", TextView.BufferType.EDITABLE);
                    progbar.setVisibility(View.INVISIBLE);
                    login.setEnabled(true);
                    return;
                }
                if(TextUtils.isEmpty(Pass)){
                    Toast.makeText(MainActivity.this,"Please Enter your Password",Toast.LENGTH_SHORT).show();
                    progbar.setVisibility(View.INVISIBLE);
                    login.setEnabled(true);
                    return;
                }
                if(Pass.length()<6){
                    Toast.makeText(MainActivity.this,"Password is at least 6 characters",Toast.LENGTH_SHORT).show();
                    pass.setText("", TextView.BufferType.EDITABLE);
                    progbar.setVisibility(View.INVISIBLE);
                    login.setEnabled(true);
                    return;
                }

                maAuth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                            progbar.setVisibility(View.INVISIBLE);
                            openlist();
                            login.setEnabled(true);
                        } else {
                            Toast.makeText(MainActivity.this,"Email or Password is incorrect !",Toast.LENGTH_SHORT).show();
                            pass.setText("", TextView.BufferType.EDITABLE);
                            progbar.setVisibility(View.INVISIBLE);
                            login.setEnabled(true);
                            return;
                        }
                    }
                });


            }
        });


    }

    public  void openlist(){
        Intent Choose = new Intent(this, ChooseType.class);
        startActivity(Choose);

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
