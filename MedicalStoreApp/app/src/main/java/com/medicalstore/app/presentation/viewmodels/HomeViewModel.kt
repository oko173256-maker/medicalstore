package com.medicalstore.app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    private val _specialOffers = MutableStateFlow<List<Any>>(emptyList())
    val specialOffers: StateFlow<List<Any>> = _specialOffers

    private val _recommendedProducts = MutableStateFlow<List<Any>>(emptyList())
    val recommendedProducts: StateFlow<List<Any>> = _recommendedProducts

    private val _categories = MutableStateFlow<List<Any>>(emptyList())
    val categories: StateFlow<List<Any>> = _categories

    init {
        loadHomeData()
    }

    fun loadHomeData() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                // Simulate loading data
                kotlinx.coroutines.delay(1000)
                
                _uiState.value = HomeUiState.Success(
                    HomeData(
                        specialOffers = emptyList(),
                        recommendedProducts = emptyList(),
                        categories = emptyList()
                    )
                )
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(
                    message = e.message ?: "Failed to load home data",
                    retryAction = { loadHomeData() }
                )
            }
        }
    }

    fun searchProducts(query: String) {
        viewModelScope.launch {
            // Implement search
        }
    }

    data class HomeData(
        val specialOffers: List<Any>,
        val recommendedProducts: List<Any>,
        val categories: List<Any>
    )

    sealed class HomeUiState {
        object Loading : HomeUiState()
        data class Success(val data: HomeData) : HomeUiState()
        data class Error(val message: String, val retryAction: () -> Unit) : HomeUiState()
    }
}
