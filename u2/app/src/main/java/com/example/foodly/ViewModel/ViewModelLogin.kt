package com.example.foodly.ViewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLogin: ViewModel() {
 val _user= MutableLiveData<String>()
    val user :LiveData<String> = _user

    val _pass= MutableLiveData<String>()
    val pass :LiveData<String> = _pass

    val _comprobar= MutableLiveData<Boolean>()
    val comprobar :LiveData<Boolean> = _comprobar

    fun validaUser(user: String, pass: String) {
        _user.value=user
        _pass.value=pass
        val bandera = Patterns.EMAIL_ADDRESS.matcher(user).matches() && pass.length >= 8
        _comprobar.value=bandera

    }
}