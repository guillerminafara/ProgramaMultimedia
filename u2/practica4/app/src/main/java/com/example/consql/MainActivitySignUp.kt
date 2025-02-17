package com.example.consql

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.lifecycleScope
import com.example.consql.Clases.UserEntity
import com.example.consql.PrefHelper.PrefHelper
import com.example.consql.consultas.UserApplication

import com.example.consql.databinding.ActivityMainSignInBinding

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivitySignUp : AppCompatActivity() {
    private lateinit var binding: ActivityMainSignInBinding
    private lateinit var prefHelper: PrefHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSignInBinding.inflate(layoutInflater)
        prefHelper = PrefHelper(this)
        setContentView(binding.root)
        back()
        binding.botonRegistrar.setOnClickListener {
            addUsers()
        }


    }


    fun checkMatches(passString: String, pass2String: String): Boolean {
        return passString.equals(pass2String)
    }

    fun addUsers() {
        val username = binding.userTextD
        val pass = binding.passTextD
        val pass2 = binding.passText2D
        if (username != null && pass != null && pass2 != null) {
            var username2 = username.text.toString()
            var passString = pass.text.toString()
            var pass2String = pass2.text.toString()

            if (checkMatches(passString, pass2String)) {
                val user = UserEntity(user = username2, pass = passString)
                lifecycleScope.launch {
                    UserApplication.database.userDao().addUser(user)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@MainActivitySignUp,
                            "Usuario agregado correctamente",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                cambioPantalla()
            } else {
                Toast.makeText(this, "Las contraseña debe coincidir", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun back() {
        binding.backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun cambioPantalla() {
        indetif2()
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun indetif2() {
        var user = binding.userTextD.text.toString()
        var pass = binding.passTextD.text.toString()

        prefHelper.guardarString("user", user)
        prefHelper.guardarString("pass", pass)
//        Toast.makeText(this, " $user, $pass", Toast.LENGTH_SHORT).show()
    }
}