package com.example.centroscomerciales

import android.content.Context
import android.media.MediaPlayer

object Musica {
    var mplayer: MediaPlayer? = null
    var position: Int = 0

    fun initialize(context: Context) {
        if (mplayer == null) {
            mplayer = MediaPlayer.create(context, R.raw.nonkilliin6)
            mplayer?.isLooping = true
        }
    }

    fun start() {
        mplayer?.start()
    }

    fun pause() {
        mplayer?.pause()
        position = mplayer?.currentPosition ?: 0
    }

    fun stop() {
        mplayer?.stop()
        mplayer?.release()
        mplayer = null
    }

    fun resume() {
        mplayer?.seekTo(position)
        mplayer?.start()
    }
}
