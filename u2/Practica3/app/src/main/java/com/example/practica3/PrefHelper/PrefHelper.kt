package com.example.practica3.PrefHelper

import android.content.Context

class PrefHelper(context: Context) {
    private val sharedPreferences=context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
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