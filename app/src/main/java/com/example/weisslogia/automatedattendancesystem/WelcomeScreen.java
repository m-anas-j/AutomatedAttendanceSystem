package com.example.weisslogia.automatedattendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

//packages required for running nfc

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.widget.Toast;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter==null)
        {
            Toast.makeText(this,"Sorry, your device doesn't support NFC",Toast.LENGTH_LONG).show();
            return;
        }
        if (!nfcAdapter.isEnabled())
        {
            Toast.makeText(this,"Please enable NFC from your device settings",Toast.LENGTH_LONG).show();
        }
    }

    public void onFacultyButtonClicked(View view)
    {
        Intent i = new Intent(this,Courses.class);
        startActivity(i);
    }

    public void onStudentButtonClicked(View view)
    {
        Intent i = new Intent(this, TransferringStudentID.class);
        startActivity(i);
    }

}
