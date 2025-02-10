package com.example.consql

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.consql.Clases.UserEntity
import com.example.consql.PrefHelper.PrefHelper
import com.example.consql.consultas.UserApplication
import com.example.consql.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var prefHelper: PrefHelper
    val dialog = Dialog(this)
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
//        binding.boton.setOnClickListener {
//            fullScreenDialog()
//            val user = binding.userText.text.toString()
//        }
        val signin= dialog.findViewById<Button>(R.id.botonRegistrar)
        signin.setOnClickListener{
            addUsers()
        }
    }


    fun fullScreenDialog() {

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_fullscreen)
        val closeButton = dialog.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            dialog.dismiss() // Close the dialog by pressing the button
        }

        dialog.show()
    }
    suspend fun addUsers(){
        val username= binding.userText.text.toString()
        val pass= binding.passText.text.toString()
        val user= UserEntity(user=username,pass=pass)

         
            UserApplication.database.userDao().addUser(user)

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
//        Toast.makeText(this, " $user, $pass", Toast.LENGTH_SHORT).show()
    }

    fun recordar(): String {

        val user = prefHelper.getStrings("user", "")
        return user
    }

    fun recordarPass(): String {
        val pass = prefHelper.getStrings("pass", "")
        return pass
    }

    fun cargarText() {
        val user = recordar()
        val pass = recordarPass()
        binding.userText.setText(user)
        binding.passText.setText(pass)
    }




}


