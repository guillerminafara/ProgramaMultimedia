package com.example.foodly.Pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodly.ViewModel.ViewModelLogin



@Composable
fun Registro(viewModel: ViewModelLogin) {
    val userR by viewModel.userR.observeAsState("")
    val passR by viewModel.passR.observeAsState("")


    Column (modifier = Modifier.fillMaxSize()
        .padding(20.dp)){
        Text("Registrar Usuario")

    }
}































