package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DevicesList extends AppCompatActivity {
    ListView list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_list);
        list = findViewById(R.id.list);
        String [] array = {"Android","iPhone","Windows","Blackberry","Linux"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.select_dialog_item, array);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(DevicesList.this,clickedItem,Toast.LENGTH_LONG).show();
                opendetails();
            }
        });
    }
    public void opendetails(){
        Intent List_Details= new Intent(this, DeviceDetail.class);
        startActivity(List_Details);
    }
}
