package com.example.practica3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.practica3.PrefHelper.PrefHelper
import com.example.practica3.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var boton:Button= binding.boton
        cambioPantalla(binding.boton)
        var inputUser=binding.userText
        indetif2(inputUser)

    }
    fun indetif2(tiet: TextInputEditText){
        tiet.setOnClickListener{
            val prefs= PrefHelper(this)
            val user:String=tiet.text.toString().trim()
            prefs.guardarString("user",user  )

            val username= prefs.getStrings("user", "DEfaultuser")
            Toast.makeText(this, "$user", Toast.LENGTH_SHORT).show()
            Log.i("chared", "Hola $user")
        }


    }

    fun identif(tiet:TextInputEditText){
        tiet.setOnClickListener{
            val sharedPref= getSharedPreferences("SharedPrefs", MODE_PRIVATE)
//            val userText: String = binding.userText.text.toString()
            val editor= sharedPref.edit()
            editor.putString("user1", "ESte es el user 1")
            editor.apply()
            val userText: String = tiet.text.toString().trim()
            if (userText.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa un texto válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user= sharedPref.getString(userText, "default")
            Toast.makeText(this, user,Toast.LENGTH_SHORT).show()
            Log.i("chared", "Hola $user")

        }


    }
    fun cambioPantalla(boton:Button){
        boton.setOnClickListener{
            val intent=Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}