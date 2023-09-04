package com.example.notificacionesbroadcast;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class Call extends AppCompatActivity {

    private static final int REQUEST_PHONE_STATE_PERMISSION = 1;
    private TextView txt;
    private CallReceiver callReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        callReceiver = new CallReceiver(txt);

        // Verifica si ya se concedió el permiso.
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Si no se ha concedido, solicita el permiso.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    REQUEST_PHONE_STATE_PERMISSION);
        } else {
            // El permiso ya se ha concedido, puedes registrar el receptor aquí.
            registerCallReceiver();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PHONE_STATE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, registra el receptor.
                registerCallReceiver();
            } else {
                Toast.makeText(this, "Se requiere permiso para leer el estado de la llamada.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void registerCallReceiver() {
        IntentFilter filter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        registerReceiver(callReceiver, filter);
    }
}