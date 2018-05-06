package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {

    StudentDBHandler studentDBHandler = new StudentDBHandler(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    //Method to go to transfer id screen

    public void gotoTransferringStudentId(View view) {

        EditText useridEditText = (EditText) findViewById(R.id.userIdText);
        String userIdStr = useridEditText.getText().toString();

        EditText passwordEditText = (EditText) findViewById(R.id.userPasswordText);
        String passwordStr = passwordEditText.getText().toString();

        String password = studentDBHandler.searchPass(userIdStr);
        if(passwordStr.equals(password)) {
            Intent transferringStudId = new Intent(this, TransferringStudentID.class);
            startActivity(transferringStudId);
        }
        else{
            Toast.makeText(LoginScreenActivity.this, "Wrong Credentials!", Toast.LENGTH_LONG).show();
        }
    }
}
