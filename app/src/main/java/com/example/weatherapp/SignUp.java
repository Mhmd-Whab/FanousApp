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

public class SignUp extends AppCompatActivity {
    EditText email;
    EditText pass;
    EditText confpass;
    Button register;
    ProgressBar progbar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email =findViewById(R.id.Email);
        pass =findViewById(R.id.Password);
        confpass = findViewById(R.id.ConfPass);
        register =findViewById(R.id.Reg);
        register.setEnabled(true);
        progbar =findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            openDeviceList();
            finish();
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register.setEnabled(false);
                final String Email = email.getText().toString().trim();
                String Pass = pass.getText().toString().trim();
                String ConfPass= confpass.getText().toString().trim();

                progbar.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(Email)){
                    Toast.makeText(SignUp.this,"Please Enter your Email",Toast.LENGTH_SHORT).show();
                    pass.setText("", TextView.BufferType.EDITABLE);
                    confpass.setText("", TextView.BufferType.EDITABLE);
                    progbar.setVisibility(View.INVISIBLE);
                    register.setEnabled(true);
                    return;
                }
                if(TextUtils.isEmpty(Pass)){
                    Toast.makeText(SignUp.this,"Please Enter your Password",Toast.LENGTH_SHORT).show();
                    progbar.setVisibility(View.INVISIBLE);
                    register.setEnabled(true);
                    return;
                }
                if(TextUtils.isEmpty(ConfPass)){
                    Toast.makeText(SignUp.this,"Please Confirm your Password",Toast.LENGTH_SHORT).show();
                    progbar.setVisibility(View.INVISIBLE);
                    register.setEnabled(true);
                    return;
                }
                if(Pass.length()<6){
                    Toast.makeText(SignUp.this,"Password is at least 6 characters",Toast.LENGTH_SHORT).show();
                    pass.setText("", TextView.BufferType.EDITABLE);
                    confpass.setText("", TextView.BufferType.EDITABLE);
                    progbar.setVisibility(View.INVISIBLE);
                    register.setEnabled(true);
                    return;
                }
                if(!Pass.equals(ConfPass)){
                    Toast.makeText(SignUp.this,"Password is not confirmed correctly",Toast.LENGTH_SHORT).show();
                    pass.setText("", TextView.BufferType.EDITABLE);
                    confpass.setText("", TextView.BufferType.EDITABLE);
                    progbar.setVisibility(View.INVISIBLE);
                    register.setEnabled(true);
                    return;
                }
                mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(SignUp.this,"Account Created Successfully",Toast.LENGTH_SHORT).show();
                            progbar.setVisibility(View.INVISIBLE);
                            openDeviceList();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUp.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            email.setText("", TextView.BufferType.EDITABLE);
                            progbar.setVisibility(View.INVISIBLE);
                            return;
                        }
                    }
                });
            }
        });

    }


    public void openDeviceList() {
        Intent Choose = new Intent(this, ChooseType.class);
        startActivity(Choose);
    }

}
