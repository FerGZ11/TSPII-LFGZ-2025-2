package com.example.foxphotoapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foxphotoapp.R
import com.example.foxphotoapp.ui.entries.HomeScreen
import com.example.foxphotoapp.viewmodel.FoxViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoxApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { CatTopBar(scrollBehavior = scrollBehavior)} // Cambia el comportamiento del scroll
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()) {
            val foxViewModel: FoxViewModel = viewModel()
            HomeScreen(foxUiState = foxViewModel.foxUiState, contentPadding = it)

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatTopBar(scrollBehavior: TopAppBarScrollBehavior, modifier:Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    )

}