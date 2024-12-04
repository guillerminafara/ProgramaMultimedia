package com.example.practica3

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.practica3.PrefHelper.PrefHelper
import com.example.practica3.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var prefHelper: PrefHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var boton: Button = binding.boton
        cambioPantalla(binding.boton)
        val tiet = binding.userText
        val tietpass = binding.passText
        val til = binding.user
//        prefHelper = PrefHelper(this)

        indetif2(tiet, tietpass)
//        identif(tiet)
//        binding.userText.setOnClickListener {
//            val userText = binding.userText.text.toString()
//            prefHelper.guardarString("user1", userText)
//            Toast.makeText(this, "Datos guardados ", Toast.LENGTH_SHORT).show()
//        }

        cargarText()
//        prefHelper.limpiar()
    }
//
//    override fun onResume() {
//        super.onResume()
//        cargarText()
//    }


    fun indetif2(tiet: TextInputEditText, tietpass: TextInputEditText) {
        val prefs = PrefHelper(this)
        tiet.setOnClickListener {
            val user: String = tiet.text.toString()
            prefs.guardarString("user1", user)
            Toast.makeText(this, "$user", Toast.LENGTH_SHORT).show()
            Log.i("chared", "Hola $user")
        }
        tietpass.setOnClickListener {
            val pass: String = tiet.text.toString()
            prefs.guardarString("pass", pass)
        }


    }

    fun recordar(): String {
        val prefs = PrefHelper(this)
        val user = prefs.getStrings("user1", "fail")
        return user
    }

    fun recordarPass(): String {
        val prefs = PrefHelper(this)
        val pass = prefs.getStrings("pass", "failpass")
        return pass
    }

    fun cargarText() {
        val user = recordar()
        val pass = recordarPass()
        binding.userText.setText(user)
        binding.passText.setText(pass)
    }

    fun identif(tiet: TextInputEditText) {
        tiet.setOnClickListener {
            val Pref = getPreferences( MODE_PRIVATE)
//            val userText: String = binding.userText.text.toString()
            val editor = Pref.edit()
//            editor.putString()
            editor.apply()
            val userText: String = tiet.text.toString().trim()
            if (userText.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa un texto válido", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val user = Pref.getString(userText, "default")
            Toast.makeText(this, user, Toast.LENGTH_SHORT).show()
            Log.i("chared", "Hola $user")
        }
    }

    fun cargar2(){


    }

    fun cargarPass2(){

    }

    fun cambioPantalla(boton: Button) {
        boton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}