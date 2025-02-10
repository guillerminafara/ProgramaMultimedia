package com.example.consql


import android.content.Intent
import android.net.Uri

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consql.Clases.NoticeProvider
import com.example.consql.PrefHelper.PrefHelper
import com.example.consql.adapter.NoticiasAdapter

import com.example.consql.databinding.ActivityMain2Binding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2:AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var prefHelper: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        prefHelper = PrefHelper(this)
        val atras = binding.atras
        recyclerV()
        atras(atras)
        noticia()
        agregarNoticia(binding.btnSave)
    }

    fun agregarNoticia(btnSave: FloatingActionButton){
        btnSave.setOnClickListener{
            val intent= Intent(this, MainActivity4Noticias::class.java)
            startActivity(intent)

        }
    }

    fun noticia() {
        val nombre = prefHelper.getStrings("ultimaNoticia", "")
        if (nombre != "") {
            Toast.makeText(this, "$nombre", Toast.LENGTH_SHORT).show()
        }

    }

    fun recyclerV() {
        val linearLayout = LinearLayoutManager(this)
        binding.recyclerMain2.layoutManager = linearLayout
        binding.recyclerMain2.adapter = NoticiasAdapter(NoticeProvider.listaNoticiaEntities)
        { noticia ->
            prefHelper.guardarString("ultimaNoticia", noticia.titulo)


            val uri: Uri = Uri.parse(noticia.enlace)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }
    }

    fun atras(atras: ImageView) {
        atras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}
