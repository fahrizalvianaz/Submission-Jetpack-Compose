package com.example.handphoneapp.model

import androidx.annotation.DrawableRes

data class HandPhone (
    val id: String,
    @DrawableRes val image: Int,
    val title: String,
    val description : String,
 )