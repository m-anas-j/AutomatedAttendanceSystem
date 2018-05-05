package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Toast.makeText(this,"Welcome, Master.",Toast.LENGTH_LONG).show();
    }

    public void goToViewStudentDatabase(View view)
    {
        Intent i = new Intent(this,ViewStudentDatabase.class);
        startActivity(i);
    }

}
