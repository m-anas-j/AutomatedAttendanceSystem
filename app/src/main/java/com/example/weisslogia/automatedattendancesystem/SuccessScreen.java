package com.example.weisslogia.automatedattendancesystem;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;


public class SuccessScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_screen);

        Bundle receivedID = getIntent().getExtras();
        String id = receivedID.getString("Received id");
        TextView successText = (TextView)findViewById(R.id.successText);
        successText.setText(successText.getText().toString()+id);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Intent intent = getIntent();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);

            NdefMessage message = (NdefMessage) rawMessages[0]; // only one message transferred
            TextView mTextView = (TextView) findViewById(R.id.successText);
            mTextView.setText(new String(message.getRecords()[0].getPayload()));

        }

    }

}