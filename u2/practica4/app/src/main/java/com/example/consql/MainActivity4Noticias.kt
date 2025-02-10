package com.example.consql

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.consql.Clases.NoticeEntity
import com.example.consql.adapter.NoticiasAdapter
import com.example.consql.databinding.CrearNoticiasBinding

class MainActivity4Noticias : AppCompatActivity() {
    private lateinit var binding:CrearNoticiasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=CrearNoticiasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        atras()
    }
    fun atras(){
        binding.atras.setOnClickListener{
            val intent=Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
    fun getData(){
        var title=binding.titleText.text.toString().trim()
        var description=binding.bodyText.text.toString().trim()
        var date =binding.bodyText.text.toString().trim()
        var photo= binding.linkText.text.toString().trim()
        var linkNew= binding.linkNoticiaText.text.toString().trim()
    }
    fun agregarNoticia(){
        val noticiaEntity= NoticeEntity (titulo = binding.titleText.text.toString().trim())
        NoticiasAdapter.add(noticiaEntity)
    }
}