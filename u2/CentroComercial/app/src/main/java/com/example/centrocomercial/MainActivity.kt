package com.example.centrocomercial

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var mplayer: MediaPlayer?=null
    private var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


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