package com.example.notificacionesbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class Network extends AppCompatActivity {
        private TextView textViewNetworkStatus;
        private NetworkReceiver networkReceiver;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_network);

            textViewNetworkStatus = findViewById(R.id.textViewNetworkStatus);
            networkReceiver = new NetworkReceiver(textViewNetworkStatus);

            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(networkReceiver, filter);
        }
    }