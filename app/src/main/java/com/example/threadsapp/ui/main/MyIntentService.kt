package com.example.threadsapp.ui.main

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.util.*
import java.util.concurrent.TimeUnit



class MyIntentService (name: String = "MyIntentService"): IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        val arg = intent?.extras?.getInt(DURATION) ?: 10
        Log.d("MyIntentService", "onHandleIntent start duration: " + arg)
        startCalculation(arg)
        Log.d("MyIntentService", "onHandleIntent finish")
    }

    private fun startCalculation(seconds: Int): CharSequence? {
        val date = Date()
        var diffInSecs: Long
        do {
            val currentDate = Date()
            val diffInMs: Long = currentDate.time - date.time
            diffInSecs = TimeUnit.MILLISECONDS.toSeconds(diffInMs)
        }while (diffInSecs<seconds)
        return diffInSecs.toString()
    }

}