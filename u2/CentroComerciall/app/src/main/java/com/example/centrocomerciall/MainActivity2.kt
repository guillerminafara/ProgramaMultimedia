package com.example.centrocomerciall

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.centrocomerciall.adapter.TiendaAdapter
import com.example.centrocomerciall.clases.CCProvider
import com.example.centrocomerciall.clases.CentrosComerciales
import com.example.centrocomerciall.clases.Tienda

import com.example.centrocomerciall.databinding.ActivityMain3Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    lateinit var boton: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val centros = intent.getIntExtra("das", -1)
//        val centro:CentrosComerciales=CentrosComerciales.getCentrosPorId(centros)
        boton = findViewById(R.id.BotonAtras)
        cambiar(boton)
    }

    fun cambiar(boton: Button) {
        boton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getCentrosPorId(id: Int): CentrosComerciales? {
        return CentrosComerciales(1, "", "", "", "",listOf(Tienda("", "")))
    }


    fun pasarInfo(){
        val recyclerViewTienda=findViewById<RecyclerView>(R.id.recyclerViewTienda)
        binding.recyclerViewTienda.layoutManager= LinearLayoutManager(this)
        binding.recyclerViewTienda.adapter = TiendaAdapter(CCProvider.centrosList.){ tienda->
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("das",centro.id)
            startActivity(intent)
        }
    }
}