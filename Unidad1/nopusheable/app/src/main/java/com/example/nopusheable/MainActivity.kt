package com.example.nopusheable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var b1 : Button = findViewById<Button>(R.id.b1)
        b1.setOnClickListener{
            //Toast
            val intent= Intent(this, MainActivity::class.java)// poner la segunda clase 
            startActivity(intent)
        }
    }
}