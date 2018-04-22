package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;
import java.util.Date;

import android.transition.Transition;
import android.view.View;
import android.widget.TextView;

public class Courses extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Date currentTime = Calendar.getInstance().getTime();
        String date = currentTime.toString();
        date = date.substring(0, Math.min(date.length(), 10));  //Math.min returns the lesser value of the two.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        TextView dateTime = (TextView)findViewById(R.id.dateTime);
        dateTime.setText(date);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/productsans/Product Sans Regular.ttf");
        dateTime.setTypeface(face);
    }

    public void onCourseButtonClicked(View view)
    {
        Intent i = new Intent(this,WaitingForStudentID.class);
        Transition newTransition;

        startActivity(i);
    }

}
