package com.example.handphoneapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.handphoneapp.data.HandPhoneRepository
import com.example.handphoneapp.model.OrderHandphone
import com.example.handphoneapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: HandPhoneRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderHandphone>> = MutableStateFlow(
        UiState.Loading
    )
    val uiState: StateFlow<UiState<OrderHandphone>> get() = _uiState

    fun getItemById(id: String){
        viewModelScope.launch {
            _uiState.value=UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderHandPhoneById(id))
        }
    }

}