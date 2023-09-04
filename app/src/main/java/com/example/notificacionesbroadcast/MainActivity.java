package com.example.notificacionesbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private ConnectivityReceiver connectivityReceiver;
    //BatteryReceiver batteryReceiver = new BatteryReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        connectivityReceiver = new ConnectivityReceiver(txt);
    }

    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, filter);
    }
    @Override
    protected void onStop(){
        super.onStop();
        unregisterReceiver(connectivityReceiver);
    }
}