package com.example.centrocomerciall

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.centrocomerciall.databinding.ActivityMain2Binding
import com.example.centrocomerciall.clases.CentrosComerciales
import com.example.centrocomerciall.clases.Tienda

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val centros = intent.getIntExtra("das", -1)

    }

    private fun getCentrosPorId(id: Int): CentrosComerciales? {
        return CentrosComerciales(1, "", "", "", listOf(Tienda("", "")))
    }
}