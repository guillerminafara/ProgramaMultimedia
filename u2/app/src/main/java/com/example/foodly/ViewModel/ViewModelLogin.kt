package com.example.foodly.ViewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLogin : ViewModel() {
    private val _user = MutableLiveData<String>()
    val user: LiveData<String> = _user

    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String> = _pass

    private val _comprobar = MutableLiveData<Boolean>()
    val comprobar: LiveData<Boolean> = _comprobar

    private val _userR = MutableLiveData<String>()
    val userR: LiveData<String> = _userR

    private val _passR = MutableLiveData<String>()
    val passR:LiveData<String> = _passR

    fun validaUser(user: String, pass: String) {
        _user.value = user
        _pass.value = pass
        val bandera = Patterns.EMAIL_ADDRESS.matcher(user).matches() && pass.length >= 8
        _comprobar.value = bandera

    }
}