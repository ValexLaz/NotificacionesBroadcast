package com.example.notificacionesbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class CallReceiver extends BroadcastReceiver {

    private TextView txt;
    private String lastCallState = "";
    public CallReceiver() {
        // Constructor sin argumentos requerido por Android
    }
    public CallReceiver(TextView txt) {
        this.txt = txt;

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String callState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

            if (callState != null) {
                if (callState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    // Llamada entrante
                    String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    txt.setText("Llamada entrante de: " + incomingNumber);
                } else if (callState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                    // Llamada en curso
                    txt.setText("Llamada en curso");
                } else if (callState.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                    // Llamada finalizada
                    txt.setText("Llamada finalizada");
                } else if (callState.equals(TelephonyManager.EXTRA_STATE_IDLE) &&
                        lastCallState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    // Llamada perdida
                    txt.setText("Llamada perdida");
                }
                lastCallState = callState;
            }
        }
    }
}