package com.example.notificacionesbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class Airplane extends AppCompatActivity {

    private TextView textViewAirplaneModeStatus;
    private AirplaneModeReceiver airplaneModeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airplane);

        textViewAirplaneModeStatus = findViewById(R.id.textViewAirplaneModeStatus);
        airplaneModeReceiver = new AirplaneModeReceiver(textViewAirplaneModeStatus);

        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiver, filter);
    }
}