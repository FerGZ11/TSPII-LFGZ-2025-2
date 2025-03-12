package com.example.coroutinesapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.coroutinesapp.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    var changeColor by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { viewModel.beginTimers() },
//            colors = ButtonDefaults.buttonColors(
//                if (changeColor) Color.Blue else Color.Red
//            )
        ) {
            Text("Iniciar contadores")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text("Contador 1: ${viewModel.countTime} [s]")
        Spacer(modifier = Modifier.height(10.dp))
        Text("Contador 2: ${viewModel.countTime2} [s]")
        Text(viewModel.resultState)
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { viewModel.cancelTimers() }
        ) {
            Text("Terminar procesos")
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun CoroutinesApp_Preview() {
    CoroutinesApp()
}*/