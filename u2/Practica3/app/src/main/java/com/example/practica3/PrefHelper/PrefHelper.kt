package com.example.practica3.PrefHelper

import android.content.Context
import com.example.practica3.Clases.Noticia


class PrefHelper(val context: Context) {

    private val sharedPreferences=context.getSharedPreferences("shared", 0)
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