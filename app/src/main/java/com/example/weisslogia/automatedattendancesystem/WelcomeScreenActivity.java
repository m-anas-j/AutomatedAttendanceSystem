package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }


    public void gotoLoginScreen(View view) {
        Intent loginIntent = new Intent(this, LoginScreenActivity.class);
        startActivity(loginIntent);
    }

    public void gotoSignupScreen(View view) {
        Intent signUpIntent = new Intent(this, SignupScreenActivity.class);
        startActivity(signUpIntent);
    }

    public void adminModeClicked(View view)
    {
        Toast.makeText(this,"Welcome, Master.",Toast.LENGTH_LONG).show();
    }

}
