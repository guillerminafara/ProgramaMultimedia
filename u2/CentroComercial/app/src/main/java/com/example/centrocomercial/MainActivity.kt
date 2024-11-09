package com.example.centrocomercial

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.centrocomercial.Clases.CCProvider
import com.example.centrocomercial.Clases.Tienda
import com.example.centrocomercial.Clases.centrosComerciales
import com.example.centrocomercial.adapter.CCAdapter

import com.example.centrocomercial.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var mplayer: MediaPlayer?=null
    private var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var url: String="https://www.lovevalencia.com/wp-content/uploads/2012/01/Nuevo-centro.jpg";
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imagen(binding.ImagenCentro1, url)
        imagen(binding.ImagenCentro2, "https://estaticos-cdn.prensaiberica.es/clip/d86ace57-dea1-4766-b6ac-f5e3ebffd012_16-9-discover-aspect-ratio_default_0.jpg")
        imagen(binding.ImagenCentro3, "https://brainsre.news/wp-content/uploads/2024/10/GALERIA_Centro-Comercial-Bonaire_arf_3399.jpg")
        imagen(binding.ImagenCentro4, "https://elmanar.es/wp-content/uploads/2021/04/IMG-0052-scaled-e1673259378339.jpg")
        cambioPantalla(binding.card1)


    }
    fun cambioPantalla(card:CardView){

        card.setOnClickListener{
            val intent= Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
    fun imagen(imagen: ImageView, linnk: String){
        Glide.with(this).load(linnk).into(imagen)

    }
    fun initRecyclerView(){
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerViewCentros)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=CCAdapter(CCProvider.centrosList)

    }
    override fun onStart(){
        super.onStart()
        mplayer = MediaPlayer.create(this,R.raw.vivelavida)

    }
    override fun onResume(){
        super.onResume()
        mplayer?.seekTo(position)
        mplayer?.start()
    }
    override fun onPause(){
        super.onPause()
        mplayer?.pause()
        if (mplayer !=null){
            position=mplayer!!.currentPosition
        }
    }

    override fun onStop() {
        super.onStop()
        mplayer?.stop()
        mplayer?.release()
        mplayer= null
    }

    override fun onRestart() {
        super.onRestart()

    }

    override fun onDestroy() {
        super.onDestroy()
    }


}