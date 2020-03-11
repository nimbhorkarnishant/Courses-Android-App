package com.example.course_deatil_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class list_of_course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_course);
        final ListView list_view = findViewById(R.id.list_of_course);
        String[] list_of_course = getResources().getStringArray(getResources().getIdentifier("list_of_course","array",getPackageName()));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list_of_course);
        list_view.setAdapter(arrayAdapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list_view.getItemAtPosition(position);
                  Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                  intent.putExtra("course_name", clickedItem);
                  startActivity(intent);
                  Toast.makeText(getApplicationContext(),clickedItem,Toast.LENGTH_LONG).show();
            }

        });


    }
}
