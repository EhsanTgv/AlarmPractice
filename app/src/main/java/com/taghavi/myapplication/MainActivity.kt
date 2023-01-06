package com.taghavi.myapplication

import android.R.attr.tag
import android.app.AlarmManager
import android.app.AlarmManager.OnAlarmListener
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAlarm()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setAlarm(){
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)
        intent.putExtra("any_data", 123)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 11)

        cal.set(Calendar.MINUTE, 39)

        cal.set(Calendar.SECOND, 0)

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            cal.timeInMillis,
            pendingIntent
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun localAlarm(){
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)
        intent.putExtra("any_data", 123)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 11)

        cal.set(Calendar.MINUTE, 39)

        cal.set(Calendar.SECOND, 0)

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.timeInMillis, "",
            OnAlarmListener {
                Toast.makeText(
                    this,
                    "AlarmManager.OnAlarmListener",
                    Toast.LENGTH_LONG
                ).show()
            }, null
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun cancelAlarm(){
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        alarmManager.cancel(pendingIntent)
    }
}