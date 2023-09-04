package com.example.notificacionesbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LanguageChangeReceiver  extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Se llama cuando cambia el idioma del sistema.
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED)) {
            // Actualiza la interfaz de usuario para reflejar el nuevo idioma.
            ((LanguageChange) context).updateLanguageText();
        }
    }
}