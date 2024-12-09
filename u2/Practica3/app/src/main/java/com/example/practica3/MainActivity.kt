package com.example.practica3

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
    private lateinit var prefHelper: PrefHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cambioPantalla(binding.boton)
        val tiet = binding.userText
        val tietpass = binding.passText
        val til = binding.user
        val tipass = binding.pass
        prefHelper = PrefHelper(this)

        cargarText()

//        prefHelper.limpiar()
    }



    fun cambioPantalla(boton: Button) {
        boton.setOnClickListener {
            indetif2()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun indetif2() {
        val user: String = binding.userText.text.toString()
        val pass: String = binding.passText.text.toString()

        prefHelper.guardarString("user", user)
        prefHelper.guardarString("pass", pass)
        Toast.makeText(this, " $user, $pass", Toast.LENGTH_SHORT).show()
    }

    fun recordar(): String {

        val user = prefHelper.getStrings("user", "fail")
        return user
    }

    fun recordarPass(): String {
        val pass = prefHelper.getStrings("pass", "failpass")
        return pass
    }

    fun cargarText() {
        val user = recordar()
        val pass = recordarPass()
        binding.userText.setText(user)
        binding.passText.setText(pass)
    }
//función no utilizada para la practica
    fun identif(tiet: TextInputEditText) {
        tiet.setOnClickListener {
            val Pref = getPreferences(MODE_PRIVATE)
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


}