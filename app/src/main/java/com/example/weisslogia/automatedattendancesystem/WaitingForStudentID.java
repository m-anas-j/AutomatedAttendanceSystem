package com.example.weisslogia.automatedattendancesystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//packages required for running nfc

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;

public class WaitingForStudentID extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_for_student_id);

        Toast.makeText(this,"Make sure your phone is touching the receiver",Toast.LENGTH_LONG).show();
        TextView touchYourPhoneToReceiver = (TextView)findViewById(R.id.touchPhoneToReceiver);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/productsans/Product Sans Regular.ttf");
        touchYourPhoneToReceiver.setTypeface(face);

    }

    /*@Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(i.getAction())) {
            Parcelable[] rawMessages = i.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage message = (NdefMessage) rawMessages[0]; // only one message transferred
            String id = new String(message.getRecords()[0].getPayload());
            Intent successIntent = new Intent(this,SuccessScreen.class);
            successIntent.putExtra("Received id",id);
            startActivity(successIntent);
            //Toast.makeText(this,"Student id "+id+" registered for attendance!",Toast.LENGTH_LONG).show();
        }
    }*/
}
