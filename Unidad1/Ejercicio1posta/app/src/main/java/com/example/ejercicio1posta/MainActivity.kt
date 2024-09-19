package com.example.ejercicio1posta

import android.content.Intent
import android.os.Bundle
import android.text.Html.ImageGetter
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
        var b1 : Button = findViewById(R.id.b1)
        b1.setOnClickListener{
            //Toast
            val intent= Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        var b2 : Button = findViewById(R.id.b2)
        b2.setOnClickListener{
            val intent= Intent(this, MainActivity3::class.java)
            startActivity(intent)


        }
    }
}