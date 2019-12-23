package com.example.moniteringserverstatus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    var startService : Button? = null
    var stopService : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startService = findViewById(R.id.buttonStartService)
        stopService = findViewById(R.id.buttonStopService)

        startService!!.setOnClickListener {
            startService()
        }

        stopService!!.setOnClickListener {
            stopService()
        }

    }

    private fun startService(){
        val startIntent = Intent(this, foregroundService :: class.java)
        startIntent.putExtra("inputExtra", "test")
        ContextCompat.startForegroundService(this, startIntent)
    }

    private fun stopService(){
        val stopIntent = Intent(this, foregroundService :: class.java)
        stopService(stopIntent)
    }


}
