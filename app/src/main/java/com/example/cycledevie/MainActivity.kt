package com.example.cycledevie

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    public var run = false;
    public var secondes = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(findViewById(R.id.toolbar))
        Toast.makeText(applicationContext," onCreated",Toast.LENGTH_SHORT).show()
        Log.d("TAG", "message")
        print("onCreate2")
        running();
        }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"onStart ",Toast.LENGTH_SHORT).show()
        print("onStart2")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"onResume",Toast.LENGTH_SHORT).show()
        print("onResume2")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"onPause",Toast.LENGTH_SHORT).show()
        print("onPause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"onStop",Toast.LENGTH_SHORT).show()
        print("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext,"onRestart",Toast.LENGTH_SHORT).show()
        print("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext," onDestroy ",Toast.LENGTH_SHORT).show()
        print("onDestroy")
    }

    fun onStartCount(view: View?){
        run = true;
        Log.d("TAG", "messageStartCount")
    }

    fun onStopCount(view: View?){
        run = false;
    }

    fun onResetCount(view: View?){
        run = false;
        secondes = 0;
    }

    fun running(){
        var time = findViewById<TextView>(R.id.textview_principal)
        var progressBarMin: ProgressBar = findViewById(R.id.progress_bar_min);
        var progressBarSec: ProgressBar = findViewById(R.id.progress_bar_sec);
        var progressBarHeure: ProgressBar = findViewById(R.id.progress_bar_heure);
        val handler = Handler()
        handler.post(object : Runnable {
                override fun run() {
            var heure = secondes/3600;
            var min = secondes % 3600 / 60; //reste des secondes qui ne sont pas encore des heures
            val sec = secondes % 60;
            val newTime = String.format("%02d:%02d:%02d",heure, min, sec);

            progressBarSec.setProgress(sec);
            progressBarMin.setProgress(min);
            progressBarHeure.setProgress(heure);
            time.text = newTime;

            if (run == true){
                secondes++;
            }
                handler.postDelayed(this, 1000)
            }
        })
    }

    }
