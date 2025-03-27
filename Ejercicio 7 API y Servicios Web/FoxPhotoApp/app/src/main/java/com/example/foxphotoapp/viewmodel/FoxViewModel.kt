package com.example.foxphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foxphotoapp.model.FoxPhoto
import com.example.foxphotoapp.network.FoxApi
import com.example.foxphotoapp.network.FoxApiService
import com.example.foxphotoapp.network.fetchMultipleFoxPhotos
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface FoxUiState {
    data class Success(val photos: List<FoxPhoto>) : FoxUiState
    object Error : FoxUiState
    object Loading : FoxUiState
}

class FoxViewModel : ViewModel() {
    var foxUiState by mutableStateOf<FoxUiState>(FoxUiState.Loading)
        private set

    init {
        getFoxPhotos()
    }

    fun getFoxPhotos() {
        viewModelScope.launch {
            foxUiState = try {
                val listResult = fetchMultipleFoxPhotos(count = 10)
                FoxUiState.Success(listResult)
            } catch (e: IOException) {
                FoxUiState.Error
            }
        }
    }
}
