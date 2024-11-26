package com.example.centrocomerciall

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

import com.example.centrocomerciall.adapter.TiendaAdapter
import com.example.centrocomerciall.clases.CCProvider
import com.example.centrocomerciall.clases.CCProvider.Companion.centrosList
import com.example.centrocomerciall.clases.CentrosComerciales
import com.example.centrocomerciall.clases.Tienda
import com.example.centrocomerciall.databinding.ActivityMain2Binding

//        var lista: List<Tienda> = listOf(Tienda("Zara", "La tienda de ropa"), Tienda("MediaMarkt", "Tienda tecno"))

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var boton: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val centros = intent.getIntExtra("Centros", -1)
//        val centros = intent.extras?.getSerializable("Centros") as CentrosComerciales
        Log.d("MainActivity2", "ID recibido: $centros")
        boton = findViewById(R.id.BotonAtras)
        cambiar(boton)
        var lista: List<Tienda> = listOf()
//        pasarInfo(centros.listaTiendas)
        if (centros != -1) {
            val centrosCom = CCProvider.centrosList.find { it.id == centros }

            if (centrosCom != null) {
                Log.d("MainActivity2", "Tiendas encontradas: ${lista.size}")

                lista = centrosCom.listaTiendas
                pasarInfo(lista)
            } else {
                Log.e("MainActivity2", "Centro no encontrado para ID: $centros")
                Toast.makeText(this, "No se recibió información del centro", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "No se recibió información del centro", Toast.LENGTH_SHORT).show()
            
        }
    }

    fun cambiar(boton: Button) {
        boton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    fun pasarInfo(tiendas: List<Tienda>) {
        val managerLayout = LinearLayoutManager(this)
        val recycler= findViewById<RecyclerView>(R.id.recyclerViewTienda)
        binding.recyclerViewTienda.layoutManager = managerLayout
        binding.recyclerViewTienda.adapter = TiendaAdapter(tiendas)
    }


}

