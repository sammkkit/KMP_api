package org.example.assignment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.example.assignment.network.BreachRepository
import org.example.assignment.util.NetworkError
import org.example.assignment.util.Result
import org.example.assignment.util.onError
import org.example.assignment.util.onSuccess

class BreachViewModel(
    private val repository: BreachRepository
) : ViewModel() {

    private val _breaches = MutableStateFlow<Result<List<Breach>, NetworkError>?>(null)
    val breaches: StateFlow<Result<List<Breach>, NetworkError>?> = _breaches.asStateFlow()

    init {
        fetchBreaches()
    }

    private fun fetchBreaches() {
        viewModelScope.launch {
            val result = repository.getBreaches()
            _breaches.value = result
        }
    }
}
