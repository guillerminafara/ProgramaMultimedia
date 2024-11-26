package com.example.centroscomerciales


import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.centroscomerciales.adapters.CCAdapter
import com.example.centroscomerciales.clases.CentrosComerciales
import com.example.centroscomerciales.clases.Provider
import com.example.centroscomerciales.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mplayer: MediaPlayer? = null
    private var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pasarInfo()
    }

    fun pasarInfo() {
        val linearLayout = LinearLayoutManager(this)
        binding.recyclerViewCentros.layoutManager = linearLayout
        binding.recyclerViewCentros.adapter = CCAdapter(Provider.centrosList)
        { centro ->
            cambioPantalla(centro)
        }
    }

    fun cambioPantalla(centro: CentrosComerciales) {
        Log.d("MainActivity", "Cambiando a MainActivity2 con ID: ${centro.id}")
        val intent = Intent(this, MainActivity2::class.java)

        intent.putExtra("Centros", centro.id)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        mplayer = MediaPlayer.create(this, R.raw.vivelavida)
    }

    override fun onResume() {
        super.onResume()
        mplayer?.seekTo(position)
        mplayer?.start()
    }

    override fun onPause() {
        super.onPause()
        mplayer?.pause()
        if (mplayer != null) {
            position = mplayer!!.currentPosition
        }
    }

    override fun onStop() {
        super.onStop()
        mplayer?.stop()
        mplayer?.release()
        mplayer = null
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}