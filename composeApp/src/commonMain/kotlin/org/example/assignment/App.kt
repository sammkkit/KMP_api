package org.example.assignment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import assignment_aashay_sir.composeapp.generated.resources.Res
import assignment_aashay_sir.composeapp.generated.resources.compose_multiplatform
import org.example.assignment.presentation.BreachListScreen
import org.example.assignment.presentation.BreachViewModel
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    MaterialTheme{
        KoinContext {
            val viewModel = koinViewModel<BreachViewModel>()
            BreachListScreen(viewModel)
        }
    }
}