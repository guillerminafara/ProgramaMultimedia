package com.example.centroscomerciales

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder


class MusicService(): Service() {
    private var mplayer: MediaPlayer? = null
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (mplayer == null) {
            mplayer = MediaPlayer.create(this, R.raw.nonkilliin6)
            mplayer?.isLooping = true
        }
        mplayer?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mplayer?.stop()
        mplayer?.release()
        mplayer = null
    }
}
