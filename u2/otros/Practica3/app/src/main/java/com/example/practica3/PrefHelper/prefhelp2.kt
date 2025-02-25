package com.example.practica3.PrefHelper

import android.content.Context

class prefhelp2 (val context:Context){
    val SHARED_NAME= "Mydatabase"
    val SHARED_USER= "user"
    val SHARED_CHECK= "check"
    val storage= context.getSharedPreferences(SHARED_NAME, 0)


    fun saveName(name:String){
        storage.edit().putString(SHARED_USER, name).apply()
    }

    fun saveCheck(check:Boolean){
        storage.edit().putBoolean(SHARED_CHECK,check).apply()
    }

    fun getName():String{
        return storage.getString(SHARED_NAME, "FAIL")!!
    }

    fun getCheck(){

    }
}