package com.example.handphoneapp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.handphoneapp.data.HandPhoneRepository
import com.example.handphoneapp.model.OrderHandphone
import com.example.handphoneapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: HandPhoneRepository
    ) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<OrderHandphone>>> = MutableStateFlow(UiState.Loading)
    val uiState : StateFlow<UiState<List<OrderHandphone>>> get() = _uiState

    fun getAllHandPhone() {
        viewModelScope.launch {
            repository.getAllHandPhone()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{orderHandPhone ->
                    _uiState.value = UiState.Success(orderHandPhone)
                }
        }
    }
}