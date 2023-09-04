package com.example.notificacionesbroadcast;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.TextView;

public class ConnectivityReceiver extends android.content.BroadcastReceiver {
    private TextView txt;
    public ConnectivityReceiver(TextView txt ){
        this.txt=txt;
    }
    @Override
    public void onReceive(Context context, Intent intent){

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
            );
            if(noConnectivity){
                txt.setText("Desconectados");
                //Toast.makeText(context, "Desconectados", Toast.LENGTH_SHORT).show();
            }else{
                txt.setText("Conectados");
                //Toast.makeText(context, "Conectados", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
