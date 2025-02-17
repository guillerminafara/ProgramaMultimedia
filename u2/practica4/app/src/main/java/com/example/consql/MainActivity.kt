package com.example.consql

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.consql.Clases.UserEntity
import com.example.consql.PrefHelper.PrefHelper
import com.example.consql.consultas.UserApplication
import com.example.consql.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var prefHelper: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton.setOnClickListener {
            var user = binding.userText.text.toString()
            var pass = binding.passText.text.toString()
            Log.d("DATABASEWWWWW", "Usuario: ${user}, Contraseña: ${pass}")
            lifecycleScope.launch {
                checkUser(user, pass)
            }
        }
        binding.botonqueseborra.setOnClickListener { listar2()}
        prefHelper = PrefHelper(this)
//        prefHelper.limpiar()
        cargarText()
        binding.boton2.setOnClickListener {
            cambioPantallaR()
        }


    }

    fun deleteUser() {
        lifecycleScope.launch {
            var id=2
            UserApplication.database.userDao().deleteUser(getData(id))

        }
    }
    fun getData(id:Int):UserEntity{
        var user=UserEntity()
        lifecycleScope.launch {
           user= UserApplication.database.userDao().getUserById(id)!!
            if (user != null) {
                Log.d("USERR", "Usuario: ${user.user}, Contraseña: ${user.pass}, id ${user.id}")
            }else{
                Log.d("USERR", "EMPTY")
            }
        }
        return user
    }
    fun listar() {
        var a = "HOOLAAAA"
        lifecycleScope.launch {
            val users = UserApplication.database.userDao().getAllUsers()
            for (user in users) {
                Log.d("DATABASE", "Usuario: ${user.user}, Contraseña: ${user.pass}, id ${user.id}")
            }
        }
        binding.textView.setText(a)
    }

    fun listar2() {
        var a = "HOOLAAAA"
        lifecycleScope.launch {
            val news = UserApplication.database.newsDao().getAllNotice()
            for (new in news) {
                Log.d("Noticiaaaaa", "noticia: ${new.titulo}, id: ${new.id}")
            }
        }
        binding.textView.setText(a)
    }

    suspend fun checkUser(user: String, pass: String) {
        return withContext(Dispatchers.IO) {
            lifecycleScope.launch {
                val users = UserApplication.database.userDao().getUser(user)
                if (users != null) {
                    if (users.user.equals(user) && users.pass.equals(pass)) {
                        Log.d("DATABASEEEEEEE", "Usuario: ${users.user}, Contraseña: ${users.pass}")
                        message(flag = true)
                        cambioPantalla(users.id, users.user, users.pass)
                    } else {
                        Log.d("DATABASEEEEEEE", "No user")
                        message(flag = false)
                    }
                } else {
                    Log.d("DATABASEEEEEEE", "No user")
                    message(flag = false)
                }

            }
        }
    }

    fun message(flag: Boolean) {
        if (flag) {
            Toast.makeText(this, "Bievenido", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "La contraseña y/o mail no coinciden", Toast.LENGTH_SHORT).show()
        }
    }

    fun cambioPantallaR() {
        indetif2()
        val intent = Intent(this, MainActivitySignUp::class.java)

        startActivity(intent)
    }

    fun cambioPantalla(id:Int, username: String, password: String) {
        indetif2()
        val userr = UserEntity(id = id, user = username, pass = password)
        val intent = Intent(this, MainActivity2::class.java)

        intent.putExtra("USER", userr)
        startActivity(intent)
    }

    fun indetif2() {
        var user = binding.userText.text.toString()
        var pass = binding.passText.text.toString()

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


