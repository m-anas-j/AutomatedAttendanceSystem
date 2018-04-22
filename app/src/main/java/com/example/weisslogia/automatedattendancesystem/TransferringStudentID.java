package com.example.weisslogia.automatedattendancesystem;

import android.graphics.Typeface;
import android.nfc.NfcEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//packages required for running nfc

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;

public class TransferringStudentID extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferring_student_id);

        String id = "154443";
        TextView transferringStudentID = (TextView)findViewById(R.id.transferringStudentId);
        transferringStudentID.setText(transferringStudentID.getText().toString()+id);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/productsans/Product Sans Regular.ttf");
        transferringStudentID.setTypeface(face);
        Toast.makeText(this,"Make sure your phone is touching the receiver",Toast.LENGTH_LONG).show();
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        nfcAdapter.setNdefPushMessageCallback(this,this);


    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent nfcEvent) {
        String message = "154443";
        NdefRecord ndefRecord = NdefRecord.createMime("text/plain", message.getBytes());
        NdefMessage ndefMessage = new NdefMessage(ndefRecord);
        return ndefMessage;
    }
}