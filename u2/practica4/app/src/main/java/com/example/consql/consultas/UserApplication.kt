package com.example.consql.consultas

import android.app.Application
import androidx.room.Room

class UserApplication:Application() {
    companion object{
        lateinit var database:Database
    }

    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this,
            Database::class.java,
            "UserDatabase")
            .build()
    }

}