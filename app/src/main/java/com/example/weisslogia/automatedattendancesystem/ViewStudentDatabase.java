package com.example.weisslogia.automatedattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

public class ViewStudentDatabase extends AppCompatActivity {

    StudentDBHandler studentDBHandler = new StudentDBHandler(this,null,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_database);

        //String [] student = new String[4];
        List<String> students = new ArrayList<>();
        String student;
        Cursor ret = studentDBHandler.viewAllStudents();
        ret.moveToFirst();
        while(!ret.isAfterLast())
        {
            student="";
            if (ret.getString(ret.getColumnIndex("student_id")) != null) {
                student += ret.getString(ret.getColumnIndex("student_id"));
                student += " ";
                student += ret.getString(ret.getColumnIndex("student_name"));
            }
            students.add(student);
            ret.moveToNext();
        }
        ret.close();
        //student[0] = studentDBHandler.viewAllStudents();



        ListAdapter myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,students);
        ListView studentListView = findViewById(R.id.studentListView);
        studentListView.setAdapter(myAdapter);
    }
}
