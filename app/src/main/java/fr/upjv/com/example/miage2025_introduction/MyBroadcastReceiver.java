package fr.upjv.com.example.miage2025_introduction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bundleReceived = intent.getExtras();
        Toast.makeText(context, "MyBroadcastReceiver : event" + bundleReceived.getString("broadcast_data", "default"), Toast.LENGTH_SHORT).show();
    }
}