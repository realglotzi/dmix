package com.namelessdev.mpdroid.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkHelper {
	
	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		
		if (networkInfo == null)
			return false;
		else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI && networkInfo.isAvailable() && networkInfo.isConnected())
			return true;
		else if (networkInfo.isConnected())
			return true;
		
		return false;
	}

	public static Boolean isLocalNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm == null) {
			return false;
		}
		NetworkInfo netWorkinfo = cm.getActiveNetworkInfo();
		return (netWorkinfo != null
				&& (netWorkinfo.getType() == ConnectivityManager.TYPE_WIFI || netWorkinfo
						.getType() == ConnectivityManager.TYPE_ETHERNET) && netWorkinfo
					.isConnected());
	}
}
