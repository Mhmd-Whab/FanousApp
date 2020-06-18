package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ChooseType extends AppCompatActivity {
    Button moslsal;
    Button program;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type);
        moslsal = findViewById(R.id.Mosl);
        program = findViewById(R.id.Prog);
        moslsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moslsal.setEnabled(false);
                openMoslslat();
                moslsal.setEnabled(true);
            }
        });

        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                program.setEnabled(false);
                openPrograms();
                program.setEnabled(true);
            }
        });
    }

    private void openPrograms() {
        Intent ProgramsList = new Intent(this, Programs.class);
        startActivity(ProgramsList);
    }

    private void openMoslslat() {
        Intent MoslslatList = new Intent(this, Moslslat1.class);
        startActivity(MoslslatList);
    }
}
