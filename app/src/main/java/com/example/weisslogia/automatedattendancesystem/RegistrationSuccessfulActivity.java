package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistrationSuccessfulActivity extends AppCompatActivity {

    private TextView newUserName, newUserId, newUserPassword;
    String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_successful);

        Bundle dateFromSignUpScreen = getIntent().getExtras();
        String userName = dateFromSignUpScreen.getString("userName");
        String userId = dateFromSignUpScreen.getString("userId");
        userPassword = dateFromSignUpScreen.getString("userPassword");

        newUserName=findViewById(R.id.newUserName);
        newUserId=findViewById(R.id.newUserId);
        newUserPassword=findViewById(R.id.newUserPassword);
        newUserName.setText(userName);
        newUserId.setText(userId);
    }

    public void goToLoginScreen(View view)
    {
        Intent i = new Intent(this,LoginScreenActivity.class);
        startActivity(i);
    }

    public void viewPassword(View view)
    {
        newUserPassword.setText(userPassword);
    }

}
