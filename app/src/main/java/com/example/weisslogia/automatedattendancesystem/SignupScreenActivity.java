package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignupScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
    }


    public void gotoTransferringStudentId(View view) {
        Intent signinIntent = new Intent(this, TransferringStudentID.class);
        startActivity(signinIntent);
    }
}
