package com.example.practica3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica3.Clases.NoticiaProvider
import com.example.practica3.PrefHelper.PrefHelper
import com.example.practica3.adapter.NoticiasAdapter
import com.example.practica3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var prefHelper: PrefHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val atras = binding.atras
        recyclerV()
        binding.atras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
//            finish()
            // Finaliza la actividad actual para evitar pantallas acumuladas
        }

    }

    fun recyclerV() {
        val linearLayout = LinearLayoutManager(this)
        binding.recyclerMain2.layoutManager = linearLayout
        binding.recyclerMain2.adapter = NoticiasAdapter(NoticiaProvider.listaNoticias)
        { noticia ->

            val uri: Uri = Uri.parse(noticia.enlace)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }
    }

    fun atras(atras:ImageView) {
        atras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}