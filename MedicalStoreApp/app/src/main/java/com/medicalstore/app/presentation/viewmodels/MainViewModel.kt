package com.medicalstore.app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _cartItemCount = MutableStateFlow(0)
    val cartItemCount: StateFlow<Int> = _cartItemCount

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Idle)
    val uiState: StateFlow<MainUiState> = _uiState

    fun updateCartCount(count: Int) {
        _cartItemCount.value = count
    }

    fun setLoading(loading: Boolean) {
        _uiState.value = MainUiState.Loading(loading)
    }

    fun setError(message: String) {
        _uiState.value = MainUiState.Error(message)
    }

    sealed class MainUiState {
        object Idle : MainUiState()
        data class Loading(val isLoading: Boolean) : MainUiState()
        data class Error(val message: String) : MainUiState()
    }
}
