package com.example.centroscomerciales

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.centroscomerciales.adapters.TiendaAdapter
import com.example.centroscomerciales.clases.Provider
import com.example.centroscomerciales.clases.Tienda
import com.example.centroscomerciales.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var boton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val centros = intent.getIntExtra("Centros", -1)
        var lista: List<Tienda> = listOf()
//        pasarInfo(Provider.centrosList.)
        if (centros != -1) {
            val centrosCom = Provider.centrosList.find { it.id == centros }
            Toast.makeText(this, "aaa $centros",Toast.LENGTH_SHORT ).show()
            if (centrosCom != null) {
                Log.d("MainActivity2", "Tiendas encontradas: ${lista.size}")

                lista = centrosCom.listaTiendas
                pasarInfo(lista)

            } else {
                Log.e("MainActivity2", "Centro no encontrado para ID: $centros")
                Toast.makeText(this, "No se recibió información del centro", Toast.LENGTH_SHORT)
                    .show()
            }
        }else{
            Toast.makeText(this, "No se recibió información del centro", Toast.LENGTH_SHORT)
                .show()
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