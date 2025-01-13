package com.example.foodly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.foodly.Pantallas.Login
import com.example.foodly.Pantallas.Registro
import com.example.foodly.ViewModel.ViewModelLogin

private val viewModel:ViewModelLogin= ViewModelLogin()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            com.example.foodly.Pantallas.Login(viewModel)
                Login(viewModel)
        }
    }
}
