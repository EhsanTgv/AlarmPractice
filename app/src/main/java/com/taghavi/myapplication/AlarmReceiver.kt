package com.taghavi.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("TAGTAG", "onReceive: called")
        if ((Intent.ACTION_BOOT_COMPLETED) == intent?.action) {
            Log.i("TAGTAG", "onReceive: ACTION_BOOT_COMPLETED")
        } else {
            Log.i("TAGTAG", "onReceive: Notification")
        }
    }
}