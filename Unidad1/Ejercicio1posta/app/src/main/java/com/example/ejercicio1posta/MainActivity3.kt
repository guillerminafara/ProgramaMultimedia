package com.example.ejercicio1posta

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        var cantidad : Int=1
        var b1 : Button = findViewById(R.id.boton3)

        b1.setOnClickListener{

            if(cantidad>1){
                b1.text= String.format("Has presionado %d veces", cantidad )
                Toast.makeText(this, String.format("Has presionado %d veces", cantidad ), Toast.LENGTH_SHORT).show()
            }else{
                b1.text= String.format("Has presionado %d vez", cantidad )
                Toast.makeText(this, String.format("Has presionado %d vez", cantidad ), Toast.LENGTH_SHORT).show()
            }

            cantidad++
        }
    }
}