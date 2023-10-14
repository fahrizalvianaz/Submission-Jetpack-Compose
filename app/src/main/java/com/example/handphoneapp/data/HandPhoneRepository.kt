package com.example.handphoneapp.data


import com.example.handphoneapp.model.HandPhoneDataSource
import com.example.handphoneapp.model.OrderHandphone
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HandPhoneRepository {
    private val orderHandPhone = mutableListOf<OrderHandphone>()

    init {
        if (orderHandPhone.isEmpty()) {
            HandPhoneDataSource.handPhone.forEach {
                orderHandPhone.add(
                    OrderHandphone(it, 0)
                )
            }
        }
    }
    fun getAllHandPhone(): Flow<List<OrderHandphone>> {
        return flowOf(orderHandPhone)
    }

    fun getOrderHandPhoneById(handPhoneId: String): OrderHandphone {
        return orderHandPhone.first {
            it.handPhone.id == handPhoneId
        }
    }

    companion object {
        @Volatile
        private var instance: HandPhoneRepository? = null

        fun getInstance(): HandPhoneRepository =
            instance ?: synchronized(this) {
                HandPhoneRepository().apply {
                    instance = this
                }
            }
    }
}