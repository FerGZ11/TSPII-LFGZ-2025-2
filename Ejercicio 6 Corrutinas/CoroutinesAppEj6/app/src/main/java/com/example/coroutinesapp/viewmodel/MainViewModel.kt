package com.example.coroutinesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {
    var resultState by mutableStateOf("")
        private set
    var countTime by mutableStateOf(0)
        private set
    var countTime2 by mutableStateOf(0)
        private set

    private var job: Job? = null

    fun beginTimers() {
        job = viewModelScope.launch {
            executeFirstCounter()
            executeSecondCounter()
        }
    }

    private suspend fun executeFirstCounter() {
        for (i in 1..5) {
            delay(1000)
            countTime = i
        }
    }

    private suspend fun executeSecondCounter() {
        for (i in 1..5) {
            delay(1000)
            countTime2 = i
        }
    }

    fun cancelTimers() {
        job?.cancel()
        countTime = 0
        countTime2 = 0
    }
}
