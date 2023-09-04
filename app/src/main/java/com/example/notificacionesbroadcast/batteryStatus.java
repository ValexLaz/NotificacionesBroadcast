package com.example.notificacionesbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class batteryStatus extends AppCompatActivity {
    private TextView txtBateria;
    private BatteryReceiver batteryReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_status);
        txtBateria = findViewById(R.id.txtBateria);
        batteryReceiver= new BatteryReceiver(txtBateria);

        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, filter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, filter);
    }
    @Override
    protected void onStop(){
        super.onStop();
        unregisterReceiver(batteryReceiver);
    }
}