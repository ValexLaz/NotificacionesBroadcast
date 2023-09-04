package com.example.notificacionesbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.TextView;

public class NetworkReceiver extends BroadcastReceiver {
    private TextView textView;

    public NetworkReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

            if (activeNetworkInfo != null && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                textView.setText("Conectado a una red Wi-Fi");
            } else {
                textView.setText("No conectado a una red Wi-Fi");
            }
        }
    }
}
