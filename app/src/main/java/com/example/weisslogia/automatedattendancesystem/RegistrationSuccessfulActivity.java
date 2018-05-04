package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationSuccessfulActivity extends AppCompatActivity {

    private TextView newUserName, newUserId, newUserPassword;

    Student newStudent;
    String userPassword;
    StudentDBHandler studentDBHandler;

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

        newStudent = new Student(userId, userName, userPassword);
        studentDBHandler = new StudentDBHandler(this,null,null,1);

        addTheNewStudent(newStudent);

        newUserName.setText(getNewlyCreatedStudentInfo(userId).getStudentName());
        newUserId.setText(getNewlyCreatedStudentInfo(userId).getStudentId());
    }

    public void addTheNewStudent(Student newStudent)
    {
        studentDBHandler.addNewStudent(newStudent);
        Toast.makeText(this,"Successfully added new Student",Toast.LENGTH_LONG).show();
    }

    public Student getNewlyCreatedStudentInfo(String newStudentId)
    {
        Student studentInfo;
        studentInfo = studentDBHandler.getNewlyCreatedStudentInfo(newStudentId);
        return studentInfo;
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
