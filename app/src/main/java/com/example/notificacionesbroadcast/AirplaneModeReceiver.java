package com.example.notificacionesbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.TextView;

public class AirplaneModeReceiver extends BroadcastReceiver {
    private TextView textView;

    public AirplaneModeReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = Settings.System.getInt(
                    context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

            String airplaneModeStatus = isAirplaneModeOn ? "Activado" : "Desactivado";

            textView.setText("Modo Avión: " + airplaneModeStatus);
        }
    }
}
