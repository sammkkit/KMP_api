package org.example.assignment

import androidx.compose.ui.window.ComposeUIViewController
import org.example.assignment.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}