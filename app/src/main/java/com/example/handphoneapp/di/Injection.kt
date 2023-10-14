package com.example.handphoneapp.di

import com.example.handphoneapp.data.HandPhoneRepository

object Injection {
    fun provideRepository(): HandPhoneRepository {
        return HandPhoneRepository.getInstance()
    }
}