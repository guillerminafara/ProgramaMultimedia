package com.example.practica3.PrefHelper

import android.content.Context
import java.util.prefs.Preferences

class PrefHelper(val context: Context) {
    val SHARED_NAME= "mydatabase"
    val SHARED_USER= "user"
    private val sharedPreferences=context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    fun guardarString(key:String, values:String){
        sharedPreferences.edit().putString(key,values).apply()
    }
    fun getStrings(key: String, default:String):String{
        return sharedPreferences.getString(key, default) ?: default
    }

    fun limpiar(){
        sharedPreferences.edit().clear().apply()
    }
}