package com.example.course_deatil_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.course_deatil_app.ui.main.SectionsPagerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>list_of_course=new ArrayList<String>(Arrays.asList(new String[]{"MAD","CLOUD","CI"}));
    static DatabaseReference reff;
    static DatabaseReference reff1;
    static DatabaseReference reff2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent = getIntent();
        String item=intent.getStringExtra("course_name");
        TextView view=findViewById(R.id.title);
        String item1="Course Detail: "+item;
        System.out.println(item);
        view.setText(item1);
        reff=FirebaseDatabase.getInstance().getReference().child("ty_btech_courses").child("courses").child(item).child("Exam_credit");
        reff1=FirebaseDatabase.getInstance().getReference().child("ty_btech_courses").child("courses").child(item).child("Practical_content");
        reff2=FirebaseDatabase.getInstance().getReference().child("ty_btech_courses").child("courses").child(item).child("Theory_content");

        ViewPager viewPager = findViewById(R.id.view_pager);
        setAdapter(viewPager);


        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



//        FloatingActionButton fab = findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }
    private void setAdapter(ViewPager viewPager) {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(new Exam_course(),"Exam");
        sectionsPagerAdapter.addFragment(new content_course(),"Content");
        sectionsPagerAdapter.addFragment(new course_practical_data(),"Practical");
        viewPager.setAdapter(sectionsPagerAdapter);
    }
}