package com.medicalstore.app.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State, Event>(initialState: State) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state

    private val _event = MutableSharedFlow<Event>()
    val event: SharedFlow<Event> = _event.asSharedFlow()

    protected val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    protected val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    protected fun setState(reducer: State.() -> State) {
        _state.value = reducer(_state.value)
    }

    protected fun sendEvent(event: Event) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    protected fun setLoading(loading: Boolean) {
        _loading.value = loading
    }

    protected fun setError(error: String?) {
        _error.value = error
    }

    protected fun execute(
        showLoading: Boolean = true,
        action: suspend () -> Unit,
        onError: (Throwable) -> Unit = { setError(it.message) }
    ) {
        viewModelScope.launch {
            try {
                if (showLoading) setLoading(true)
                setError(null)
                action()
            } catch (e: Exception) {
                onError(e)
            } finally {
                if (showLoading) setLoading(false)
            }
        }
    }

    fun clearError() {
        setError(null)
    }
}
