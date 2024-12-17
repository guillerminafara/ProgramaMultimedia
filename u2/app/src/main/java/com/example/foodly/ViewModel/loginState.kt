package com.example.foodly.ViewModel

import androidx.core.app.NotificationCompat.MessagingStyle.Message

sealed class loginState {
    object idle: loginState()
    object success:loginState()
    data class Error(val message:String):loginState()
}