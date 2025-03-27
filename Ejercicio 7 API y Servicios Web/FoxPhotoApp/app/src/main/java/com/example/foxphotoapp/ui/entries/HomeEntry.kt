package com.example.foxphotoapp.ui.entries

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foxphotoapp.R
import com.example.foxphotoapp.model.FoxPhoto
import com.example.foxphotoapp.viewmodel.FoxUiState
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(
    foxUiState: FoxUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    //ResultScreen(photos = foxUiState, modifier.padding(top = contentPadding.calculateTopPadding()))
    when(foxUiState){
        is FoxUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is FoxUiState.Success -> ResultScreen(photos = foxUiState.photos, modifier.padding(top = contentPadding.calculateTopPadding()))
        is FoxUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(R.drawable.loading),
            contentDescription = "Loading"
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(R.drawable.error_loading),
            contentDescription = "Error"
        )
    }
}

@Composable
fun ResultScreen(photos: List<FoxPhoto>, modifier: Modifier = Modifier) {
    val jsonOutput = Json.encodeToString(photos)

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = jsonOutput)
    }
}