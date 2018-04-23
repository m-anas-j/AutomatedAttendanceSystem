package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    //Method to go to transfer id screen

    public void gotoTransferringStudentId(View view) {
        Intent transferringStudId = new Intent(this, TransferringStudentID.class);
        startActivity(transferringStudId);
    }
}
