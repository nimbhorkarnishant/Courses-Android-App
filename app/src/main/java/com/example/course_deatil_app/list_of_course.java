package com.example.course_deatil_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.course_deatil_app.MainActivity.reff1;

public class list_of_course extends AppCompatActivity {
    DatabaseReference reff_new;
    ArrayList <String> course_of_list=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_course);
        final ListView list_view = findViewById(R.id.list_of_course);
        final String[] list_of_course = getResources().getStringArray(getResources().getIdentifier("list_of_course","array",getPackageName()));
         arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list_of_course);
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
        registerForContextMenu(list_view);

        reff_new= FirebaseDatabase.getInstance().getReference().child("course_list");
        reff_new.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("----------------------- From list of coorsees activity--------------------");
                int count = (int) dataSnapshot.getChildrenCount();
                System.out.println(count);
                System.out.println(dataSnapshot.getValue());
                //arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });





    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);

    }
}
