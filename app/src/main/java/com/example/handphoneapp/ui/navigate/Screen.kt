package com.example.handphoneapp.ui.navigate

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("home/{Id}"){
        fun createRoute(Id: String)= "home/$Id"
    }
}