package com.example.consql

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.consql.Clases.NewsEntity
import com.example.consql.Clases.UserEntity
import com.example.consql.consultas.UserApplication
import com.example.consql.databinding.CreateNewsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity4News : AppCompatActivity() {
    private lateinit var binding: CreateNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        atras()
        val user=intent.getParcelableExtra<UserEntity>("USER")

        if (user != null) {
            Log.d("SecondActivity", "Usuario: ${user.user}, Contraseña: ${user.pass}, ID: ${user.id}")
        }
        binding.Boton.setOnClickListener {
            lifecycleScope.launch {
                agregarNoticia()
            }
        }
    }

    fun atras() {
        binding.atras.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun getData(): NewsEntity {
        val newsEntity = NewsEntity(
            titulo = binding.titleText.text.toString(),
            resumen = binding.bodyText.text.toString(),
            fecha = binding.dateText.text.toString(),
            imagen = binding.linkText.text.toString(),
            enlace = binding.linkNoticiaText.text.toString(),
            idUser = intent.getParcelableExtra<UserEntity>("USER")?.id  ?: 0
        )
        return newsEntity
    }

    fun agregarNoticia() {
        val news = getData()
        lifecycleScope.launch {
            val id = withContext(Dispatchers.IO) {
                Log.d("Hole","Holee${news.idUser}")
                UserApplication.database.newsDao().addNotice(news)

            }
            Log.d("Noticiaaaaa", "${id}")
            withContext(Dispatchers.Main) {
                if (id > 0) {
                    Log.d("Noticiaaaaa", "Noticia agregada correctamente")
                    Toast.makeText(this@MainActivity4News, "Noticia agregada correctamente", Toast.LENGTH_SHORT).show()
                    atras()
                } else {
                    Log.d("Noticiaaaaa", "Error al agregar la noticia")
                    Toast.makeText(
                        this@MainActivity4News, "Error al agregar la noticia", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}
