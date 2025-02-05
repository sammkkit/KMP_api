package org.example.assignment.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.assignment.util.NetworkError
import org.example.assignment.util.Result
@Composable
fun BreachListScreen(viewModel: BreachViewModel) {
    val breachesResult by viewModel.breaches.collectAsState()
    val breaches = (breachesResult as? Result.Success)?.data ?: emptyList()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Data Breaches") }) }
    ) { padding ->
        when (breachesResult) {
            is Result.Success -> {
                LazyColumn(modifier = Modifier.padding(padding)) {
                    items(breaches){breach->
                        BreachItem(breach)
                    }
                }
            }
            is Result.Error -> {
                Text(
                    text = "Error: ${(breachesResult as Result.Error<NetworkError>).error}",
                    modifier = Modifier.padding(16.dp),
                    color = Color.Red
                )
            }
            null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
