package com.example.notificacionesbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class LanguageChange extends AppCompatActivity {
    private TextView txtLen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_change);

        txtLen= findViewById(R.id.txtLen);
        updateLanguageText();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Registra el receptor aquí para que esté activo cuando la actividad esté en primer plano.
        IntentFilter filter = new IntentFilter(Intent.ACTION_LOCALE_CHANGED);
        registerReceiver(new LanguageChangeReceiver(), filter);
    }

    public void updateLanguageText() {
        // Obtiene el idioma actual y lo muestra en el TextView.
        Configuration configuration = getResources().getConfiguration();
        String currentLanguage = configuration.locale.getLanguage();
        txtLen.setText("Idioma actual: " + currentLanguage);
    }
}