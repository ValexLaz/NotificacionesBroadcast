package com.example.notificacionesbroadcast;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.widget.TextView;

public class BatteryReceiver extends android.content.BroadcastReceiver {
    private TextView txtBateria;
    public BatteryReceiver(TextView txtBateria ){
        this.txtBateria=txtBateria;
    }
    @Override
    public void onReceive(Context context, Intent intent){

        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
            int carga = (level * 100) / scale;
            String batteryStatus;

            switch (status){
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    batteryStatus = "Carganding";
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    batteryStatus = "descarganding";
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    batteryStatus = "Bateria llena";
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                default:
                    batteryStatus = "Desconocido";
                    break;

            }
            if (carga <= 40){
                batteryStatus = "cargue el telefono";
            }
            txtBateria.setText(batteryStatus);
        }
    }
}
