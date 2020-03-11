package com.example.course_deatil_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.course_deatil_app.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    static String [] Course_content;
    static  String [] Practical_content;
    static  String [] Course_credit;
    ArrayList<String>list_of_course=new ArrayList<String>(Arrays.asList(new String[]{"MAD","CLOUD","CI"}));
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
        for (int i=0;i<list_of_course.size();i++){
           System.out.println(list_of_course.get(i));

            if (list_of_course.get(i).equals(item)){
                String prefix_course="course_";
                String prefix_practical="practical_";
                String prefix_exam="exam_";
                Course_content = getResources().getStringArray(getResources().getIdentifier(prefix_course+item,"array",getApplicationContext().getPackageName()));
                Practical_content = getResources().getStringArray(getResources().getIdentifier(prefix_practical+item,"array",getApplicationContext().getPackageName()));
                Course_credit=getResources().getStringArray(getResources().getIdentifier(prefix_exam+item,"array",getApplicationContext().getPackageName()));
                break;
            }
        }
//        String prefix_course="course_";
//        String prefix_practical="practical_";
//        Course_content = getResources().getStringArray(getResources().getIdentifier(prefix_course+item,"array",getApplicationContext().getPackageName()));
        System.out.println("-------------- From MAin ACtivity _________________-");
        System.out.println(Course_content);

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