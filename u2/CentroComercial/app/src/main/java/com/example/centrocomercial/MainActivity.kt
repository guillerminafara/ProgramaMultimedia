package com.example.centrocomercial

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

import com.example.centrocomercial.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var mplayer: MediaPlayer?=null
    private var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var url: String="https://www.lovevalencia.com/wp-content/uploads/2012/01/Nuevo-centro.jpg";
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        imagen(binding.ImagenCentro1, url)
        imagen(binding.ImagenCentro2, "https://estaticos-cdn.prensaiberica.es/clip/d86ace57-dea1-4766-b6ac-f5e3ebffd012_16-9-discover-aspect-ratio_default_0.jpg")


    }
    fun imagen(imagen: ImageView, linnk: String){
        Glide.with(this).load(linnk).into(imagen)
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