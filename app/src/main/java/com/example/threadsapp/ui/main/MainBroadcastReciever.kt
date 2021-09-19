package com.example.threadsapp.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainBroadcastReceiver :BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        StringBuilder().apply{
            append("Сообщение от системы\n")
            append("Action: ${intent?.action}")
            toString().also {
                Toast.makeText(context, it,Toast.LENGTH_LONG).show()
            }
        }
    }

}