package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Programs extends AppCompatActivity {
    String [] array = new String []{"Ramez Magnoun Rasmy","Beat the Sakka","Ma7adesh fahem 7aga"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moslslat1);
        final ListView list = (ListView) findViewById(R.id.list2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Programs.this,android.R.layout.simple_list_item_1, array);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(Programs.this,clickedItem,Toast.LENGTH_LONG).show();
                openPrograms(position);
            }
        });
    }

    public void openPrograms(int position){
        switch (position) {
            case 0:
                openRamez();
                return;
            case 1:
                openSakka();
                return;
            case 2:
                openMhdesh();
                return;
            default:
                return;
        }
    }

    private void openMhdesh() {
        Intent Mhdesh = new Intent(this, Ma7desh.class);
        startActivity(Mhdesh);
    }

    private void openSakka() {
        Intent sakka = new Intent(this, EghlebSakka.class);
        startActivity(sakka);
    }

    private void openRamez() {
        Intent ramez = new Intent(this, Ramez.class);
        startActivity(ramez);
    }

    public void onDestroy() {
        super.onDestroy();
        logout();
    }
    public void logout(){
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}

