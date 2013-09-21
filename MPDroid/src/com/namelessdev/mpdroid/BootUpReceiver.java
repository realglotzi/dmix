package com.namelessdev.mpdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class BootUpReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
        Log.d("BootUpReceiver", "onReceive: " + intent);
        
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            if (prefs != null && prefs.getBoolean("runOnBoot", false)) {
            	Log.d("BootUpReceiver", "onReceive: runOnBoot enabled");
            	Intent i = new Intent(context, MainMenuActivity.class);  
	            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	            context.startActivity(i);  
            }
        }		
	}

}
