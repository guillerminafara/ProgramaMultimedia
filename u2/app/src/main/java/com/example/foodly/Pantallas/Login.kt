package com.example.foodly.Pantallas

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodly.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import org.intellij.lang.annotations.Pattern

@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Iniciar Sesión")
        Spacer(modifier = Modifier.padding(5.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                var user by rememberSaveable { mutableStateOf("") }
                var pass by rememberSaveable { mutableStateOf("") }
                var verificar by rememberSaveable { mutableStateOf(false) }
                var inicio by remember { mutableStateOf(false) }
                TextField(
                    value = user,
                    onValueChange = { valor -> user = valor; verificar = validaUser(valor, pass) },
                    label = { Text("example@mail.com", color = Color.Gray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Face,
                            "user",
                            tint = Color.Gray
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = pass,
                    onValueChange = { pass = it; verificar = validaUser(user, it) },
                    label = { Text("Password", color = Color.Gray) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_lock_outline_24),
                            "Password", tint = Color.Gray
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        val auth = FirebaseAuth.getInstance()
                        var devolver=false
                        Log.i("nicio","btnaction")
                        auth.signInWithEmailAndPassword(user, pass).addOnCompleteListener {
                            if (it.isSuccessful) {
                                devolver=true
                                Log.i("nicio","correct")

                            }else{
                                Log.i("nicio","incorrect")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = verificar
                ) {
                    Text("Sign In")
                }

            }
        }
    }
}

fun createSess(user:String, pass:String):Boolean {
    val auth = FirebaseAuth.getInstance()
    var devolver=false
    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener{
        if(it.isSuccessful) {
            devolver=true
        }
    }
    return devolver
}

fun inicioSEsion(user:String, pass:String) {
    val auth = FirebaseAuth.getInstance()
    var devolver=false
    auth.signInWithEmailAndPassword(user, pass).addOnCompleteListener {
        if (it.isSuccessful) {
            devolver=true
            Log.i("nicio","correct")

        }else{
            Log.i("nicio","incorrect")
        }
    }

}
fun validaUser(user: String, pass: String): Boolean {
    val bandera = Patterns.EMAIL_ADDRESS.matcher(user).matches() && pass.length >= 8

    return bandera
}
